package com.cloudwell.paywell.myFavorite

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.analytics.AnalyticsManager
import com.cloudwell.paywell.analytics.AnalyticsParameters
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.constant.AllConstant
import com.cloudwell.paywell.database.DatabaseClient
import com.cloudwell.paywell.eventBus.GlobalApplicationBus
import com.cloudwell.paywell.myFavorite.adapter.AdapterForFavList
import com.cloudwell.paywell.myFavorite.adapter.HeaderRecyclerViewSection
import com.cloudwell.paywell.myFavorite.adapter.ItemMoveCallback
import com.cloudwell.paywell.myFavorite.adapter.StartDragListener
import com.cloudwell.paywell.myFavorite.helper.MenuStatus
import com.cloudwell.paywell.preference.FavoritePreference
import com.cloudwell.paywell.services.activity.myFavorite.model.FavoriteMenu
import com.cloudwell.paywell.services.activity.myFavorite.model.MessageEvent
import com.cloudwell.paywell.services.activity.myFavorite.model.MessageEventFavDeleted
import com.cloudwell.paywell.services.activity.myFavorite.model.MessageEventPositionMove
import com.cloudwell.paywell.utils.ResorceHelper
import com.google.android.material.snackbar.Snackbar
import com.orhanobut.logger.Logger
import com.squareup.otto.Subscribe
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_my_favorite_menu.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MyFavoriteMenuActivity : AppCompatActivity(), StartDragListener {


    lateinit var sectionAdapter: SectionedRecyclerViewAdapter;
    var allFavoriteData = kotlin.collections.mutableMapOf<String, List<FavoriteMenu>>()
    var previewPogistion = 0

    lateinit var touchHelper: ItemTouchHelper
    val totalFavCounter = 8;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_favorite_menu)

        assert(getSupportActionBar() != null)
        if (getSupportActionBar() != null) {
            getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
            getSupportActionBar()!!.setTitle(R.string.title_activity_my_favorite_menu)
        }

        initialisationView()

        AnalyticsManager.sendScreenView(AnalyticsParameters.KEY_FAVORITE_MENU_PAGE)

    }

    override fun requestDrag(viewHolder: RecyclerView.ViewHolder?) {
        viewHolder?.let { touchHelper.startDrag(it) }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed();
        finish()
    }


    @Subscribe
    fun onFavoriteItemAdd(event: MessageEvent) {

        var counter = FavoritePreference.with(applicationContext).getInt(AllConstant.COUNTER_FAVORITE, 4);

        if (counter >= totalFavCounter) {
            showMessage()
            return
        } else {
            counter = counter + 1;

            FavoritePreference.with(applicationContext).addInt(AllConstant.COUNTER_FAVORITE, counter).save()
            Logger.v("Add ", "Counter: " + counter);

            previewPogistion = event.index;
            event.title;

            val favoriteMenu = event.favoriteMenu;
            favoriteMenu.status = MenuStatus.Favourite.text;
            favoriteMenu.favoriteListPosition = counter;


            doAsync {
                DatabaseClient.getInstance(applicationContext).appDatabase.mFavoriteMenuDab().update(favoriteMenu)

                uiThread {
                    val resId = ResorceHelper.getResId(event.favoriteMenu.name, R.string::class.java)
                    Toast.makeText(applicationContext, getString(R.string.add) + getString(resId), Toast.LENGTH_LONG).show()
                    getAllUnFavoriteItem()
                    getAllFavoriteDate()
                }
            }

        }
    }

    @Subscribe
    fun onFavoriteItemdeleted(event: MessageEventFavDeleted) {

        var counter = FavoritePreference.with(applicationContext).getInt(AllConstant.COUNTER_FAVORITE, 4)
        counter = counter - 1

        if (counter < 0) {
            counter = 0;
        }

        FavoritePreference.with(applicationContext).addInt(AllConstant.COUNTER_FAVORITE, counter).save()
        Logger.v("deleted ", "Counter: " + counter);

        val favoriteMenu = event.favoriteMenu;
        favoriteMenu.status = MenuStatus.UnFavorite.text;
        favoriteMenu.favoriteListPosition = counter


        doAsync {
            DatabaseClient.getInstance(applicationContext).appDatabase.mFavoriteMenuDab().update(favoriteMenu)

            uiThread {
                getAllUnFavoriteItem()
                getAllFavoriteDate()
            }
        }


    }

    @Subscribe
    fun onFavoriteItemPositionMove(event: MessageEventPositionMove) {

        doAsync {
            DatabaseClient.getInstance(applicationContext).appDatabase.mFavoriteMenuDab().update(event.fromMenu)
            DatabaseClient.getInstance(applicationContext).appDatabase.mFavoriteMenuDab().update(event.toMenu)
        }

    }

    public override fun onResume() {
        super.onResume()
        GlobalApplicationBus.getBus().register(this)
    }

    public override fun onPause() {
        super.onPause()
        GlobalApplicationBus.getBus().unregister(this)
    }


    private fun generartedUnFavaroitRecycview(DBDatas: List<FavoriteMenu>) {
        val appHandler = AppHandler.getmInstance(applicationContext)
        val isEnglish = appHandler.getAppLanguage().equals("en", ignoreCase = true)


        allFavoriteData = mutableMapOf<String, List<FavoriteMenu>>()
        val allCategory = mutableSetOf<String>()

        DBDatas.forEach {
            it.category
            val resId = ResorceHelper.getResId(it.category, R.string::class.java);
            val string = getString(resId);
            Logger.v(string)
            allCategory.add(string)

        }

        allCategory.forEach {
            val category = it
            val data = mutableListOf<FavoriteMenu>()

            DBDatas.forEach {
                val resId = ResorceHelper.getResId(it.category, R.string::class.java);
                val string = getString(resId)
                if (category.equals(string)) {
                    data.add(it)
                }
            }

            allFavoriteData.put(category, data)
        }


        sectionAdapter = SectionedRecyclerViewAdapter()


//        // generator HeaderRecyclerViewSection
        for ((index, value) in allCategory.withIndex()) {
            val sectionData = HeaderRecyclerViewSection(index, value, allFavoriteData.get(value), isEnglish)
            sectionAdapter.addSection(sectionData)
        }

        val display = this.getWindowManager().getDefaultDisplay()
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)

        val density = resources.displayMetrics.density
        val dpWidth = outMetrics.widthPixels / density
        val columns: Int;
        if (dpWidth > 320) {
            columns = 3;
        } else {
            columns = 3;
        }

        val glm = GridLayoutManager(applicationContext, columns)
        glm.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (sectionAdapter.getSectionItemViewType(position)) {
                    SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER ->
                        return columns
                    else ->
                        return 1
                }
            }
        }

        val sectionHeader = findViewById<RecyclerView>(R.id.add_header) as RecyclerView
        sectionHeader.setLayoutManager(glm)
        sectionHeader.setHasFixedSize(true)
        sectionHeader.setAdapter(sectionAdapter)
        sectionHeader.isNestedScrollingEnabled = false;

        if (previewPogistion != 0) {
            sectionAdapter.notifyDataSetChanged();
            sectionAdapter.notifyItemRemoved(previewPogistion)
        }


    }

    private fun initialisationView() {
        getAllFavoriteDate();

        getAllUnFavoriteItem()


    }

    private fun getAllFavoriteDate() {


        val allUnFavoriteMenu = DatabaseClient.getInstance(applicationContext).appDatabase.mFavoriteMenuDab().allFavoriteMenu
        allUnFavoriteMenu.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Consumer<List<FavoriteMenu>> {
            @Throws(Exception::class)
            override fun accept(users: List<FavoriteMenu>) {

                val sortedWith = users.sortedWith(object : Comparator<FavoriteMenu> {
                    override fun compare(p1: FavoriteMenu, p2: FavoriteMenu): Int = when {
                        p1.favoriteListPosition > p2.favoriteListPosition -> 0
                        p1.favoriteListPosition == p2.favoriteListPosition -> 1
                        else -> -1
                    }
                })

                generatedFavoriteRacyView(sortedWith)

            }


        });


    }


    private fun generatedFavoriteRacyView(result: List<FavoriteMenu>) {
        val mAppHandler = AppHandler.getmInstance(applicationContext)
        val isEnglish = mAppHandler.getAppLanguage().equals("en", ignoreCase = true)

        val display = this.getWindowManager().getDefaultDisplay()
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)

        val density = resources.displayMetrics.density
        val dpWidth = outMetrics.widthPixels / density
        val columns: Int;
        if (dpWidth > 320) {
            columns = 4;
        } else {
            columns = 3;
        }


        val recyclerView = findViewById(R.id.add_favoirte) as RecyclerView
        recyclerView.setHasFixedSize(true)

        val glm = GridLayoutManager(applicationContext, columns)
        recyclerView.layoutManager = glm

        AdapterForFavList.mItems = result
        val recyclerListAdapter = AdapterForFavList(this, isEnglish)
        recyclerView.layoutManager = glm
        recyclerView.adapter = recyclerListAdapter;
        recyclerView.isNestedScrollingEnabled = false;

        val callback = ItemMoveCallback(recyclerListAdapter)
        touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)


    }

    private fun getAllUnFavoriteItem() {

        val allUnFavoriteMenu = DatabaseClient.getInstance(applicationContext).appDatabase.mFavoriteMenuDab().allUnFavoriteMenu
        allUnFavoriteMenu.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Consumer<List<FavoriteMenu>> {
            @Throws(Exception::class)
            override fun accept(users: List<FavoriteMenu>) {

                generartedUnFavaroitRecycview(users)
            }


        });
    }


    private fun showMessage() {

        val snackbar = Snackbar.make(coordinatorLayout_fav, R.string.can_not_add_more_than, Snackbar.LENGTH_LONG)
        snackbar.setActionTextColor(Color.parseColor("#ffffff"))
        val snackBarView = snackbar.view
        snackBarView.setBackgroundColor(Color.parseColor("#4CAF50"))
        snackbar.show()
    }


}
