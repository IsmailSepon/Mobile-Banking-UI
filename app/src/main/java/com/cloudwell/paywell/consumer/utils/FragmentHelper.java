package com.cloudwell.paywell.consumer.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cloudwell.paywell.consumer.R;

public class FragmentHelper {


    public static void replaceFragment(Fragment fragment, FragmentManager manager, int container) {

        manager.beginTransaction().replace(container, fragment).addToBackStack(null).commit();

    }
}
