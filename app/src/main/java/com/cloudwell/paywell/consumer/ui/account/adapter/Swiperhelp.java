package com.cloudwell.paywell.consumer.ui.account.adapter;

import androidx.recyclerview.widget.ItemTouchHelper;

public abstract class Swiperhelp extends ItemTouchHelper.SimpleCallback {

    public Swiperhelp(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }
}
