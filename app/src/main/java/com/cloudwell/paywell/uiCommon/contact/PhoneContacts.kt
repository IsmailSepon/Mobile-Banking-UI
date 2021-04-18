package com.cloudwell.paywell.uiCommon.contact

import android.database.Cursor
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager.LoaderCallbacks
import androidx.loader.app.LoaderManager.getInstance
import androidx.loader.content.Loader
import com.cloudwell.paywell.R

class PhoneContacts : AppCompatActivity()
//    , AdapterView.OnItemClickListener,
//    LoaderCallbacks<Cursor>

{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        //   getContactList();

       //    getLoaderManager().initLoader(1, null, this);
     //   getInstance(this)


    }



//    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//
//    }
//
//    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
//
//        return  null;
//    }
//
//    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
//
//    }
//
//    override fun onLoaderReset(loader: Loader<Cursor>) {
//
//    }
}