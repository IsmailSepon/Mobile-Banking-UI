package com.cloudwell.paywell.ui.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.cloudwell.paywell.R;
import com.cloudwell.paywell.base.CustomKeyboard;
import com.cloudwell.paywell.ui.registration.RegistationMainActivity;

/**
 * Created by Sepon on 4/15/2020.
 */
public class RegTwoFeg extends Fragment {
    CustomKeyboard keyboard;

    public static RegOneFeg newInstance() {
        return new RegOneFeg();
    }

    PinEntryEditText confirm_pin_et;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reg_two_layout, container, false);

        keyboard = view.findViewById(R.id.confirm_pass_keyboard);
        confirm_pin_et = view.findViewById(R.id.confirm_pin_et);
        confirm_pin_et.requestFocus();
        confirm_pin_et.setShowSoftInputOnFocus(false);
        InputConnection ic = confirm_pin_et.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);
        confirm_pin_et.post(new Runnable() {
            @Override
            public void run() {
                confirm_pin_et.requestFocus();
                InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imgr.hideSoftInputFromWindow(confirm_pin_et.getWindowToken(), 0);
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