package com.cloudwell.paywell.ui.BusinessUI.sendFund.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;



public class HorizontalPicker extends RecyclerView {
    private SlimAdapter slimAdapter;
    private LeftmostElementPickerLayoutManager pickerLayoutManager;

    public HorizontalPicker(Context context) {
        super(context);

        init(context);
    }

    public HorizontalPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public HorizontalPicker(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                try {

                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int w = getWidth();
                    addItemDecoration(new EndOffsetDecoration(w - 50));

                    //firstSelection();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        StartSnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(this);

        pickerLayoutManager = new LeftmostElementPickerLayoutManager(context, LinearLayoutManager.HORIZONTAL, this, false);

        setLayoutManager(pickerLayoutManager);

        slimAdapter = SlimAdapter.create()
                .register(R.layout.picker_item_layout, new SlimInjector<String>() {
                    @Override
                    public void onInject(String data, IViewInjector injector) {
                        injector.text(R.id.picker_item,data);
                    }
                }).attachTo(this);

    }

    public void addData(List<?> data){
        slimAdapter.updateData(data);

        post(new Runnable() {
            @Override
            public void run() {
                firstSelection();
            }
        });
    }

    public void addData(List<?> data, final int selectedItem){
        slimAdapter.updateData(data);

        post(new Runnable() {
            @Override
            public void run() {
                selectItem(selectedItem);
                //firstSelection();
            }
        });
    }

    public void setOnScrollStopListener(onScrollStopListener listener){
        if(pickerLayoutManager!=null){
            pickerLayoutManager.setOnScrollStopListener(listener);
        }
    }

    public void firstSelection(){
        pickerLayoutManager.firstSelection();


    }

    public void selectItem(int position) {

        try {
            if (position < slimAdapter.getItemCount()) {
                pickerLayoutManager.select(position);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public interface onScrollStopListener{

        void selectedView(View view);
    }
}
