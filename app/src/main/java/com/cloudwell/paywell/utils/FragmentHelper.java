package com.cloudwell.paywell.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentHelper {


    public static void replaceFragment(Fragment fragment, FragmentManager manager, int container) {

        manager.beginTransaction().replace(container, fragment).addToBackStack(null).commit();

    }
}
