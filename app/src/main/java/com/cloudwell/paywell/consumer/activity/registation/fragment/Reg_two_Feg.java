package com.cloudwell.paywell.consumer.activity.registation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.cloudwell.paywell.consumer.R;
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity;

/**
 * Created by Sepon on 4/15/2020.
 */
public class Reg_two_Feg extends Fragment {

    public static Reg_One_Feg newInstance() {
        return new Reg_One_Feg();
    }
    PinEntryEditText confirm_pin_et;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reg_two_layout, container, false);


        confirm_pin_et = view.findViewById(R.id.confirm_pin_et);
        confirm_pin_et.requestFocus();
        confirm_pin_et.post(new Runnable() {
            @Override
            public void run() {
                confirm_pin_et.requestFocus();
                InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imgr.showSoftInput(confirm_pin_et, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        if (confirm_pin_et != null) {
            confirm_pin_et.setAnimateText(true);
            confirm_pin_et.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
                @Override
                public void onPinEntered(CharSequence str) {

                    if (str.length() == 4){
                        RegistationMainActivity parent = (RegistationMainActivity) getActivity();
                        parent.setPagerFragment(2);

                    }
//                    if (str.toString().equals("1234")) {
//                        Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();
//                    } else {
//                        pinEntry2.setError(true);
//                        Toast.makeText(getActivity(), "FAIL", Toast.LENGTH_SHORT).show();
//                        pinEntry2.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                pinEntry2.setText(null);
//                            }
//                        }, 1000);
//                    }
                }
            });
        }


        return view;
    }



}