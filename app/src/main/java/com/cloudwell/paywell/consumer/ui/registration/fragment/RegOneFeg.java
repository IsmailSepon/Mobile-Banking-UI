package com.cloudwell.paywell.consumer.ui.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
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
import com.cloudwell.paywell.consumer.R;
import com.cloudwell.paywell.consumer.base.CustomKeyboard;
import com.cloudwell.paywell.consumer.ui.registration.RegistationMainActivity;

/**
 * Created by Sepon on 4/15/2020.
 */
public class RegOneFeg extends Fragment {

    public static RegOneFeg newInstance() {
        return new RegOneFeg();
    }

    PinEntryEditText creat_pin_et;
    CustomKeyboard keyboard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reg_one_layout, container, false);


        keyboard = view.findViewById(R.id.creat_pass_keyboard);
        creat_pin_et = view.findViewById(R.id.creat_pin_et);
        creat_pin_et.setRawInputType(InputType.TYPE_CLASS_TEXT);
        creat_pin_et.setTextIsSelectable(true);
        InputConnection ic = creat_pin_et.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);
        creat_pin_et.post(new Runnable() {
            @Override
            public void run() {
                creat_pin_et.requestFocus();
                InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imgr.hideSoftInputFromWindow(creat_pin_et.getWindowToken(), 0);
            }
        });
        if (creat_pin_et != null) {
            creat_pin_et.setAnimateText(true);
            creat_pin_et.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
                @Override
                public void onPinEntered(CharSequence str) {

                    if (str.length() == 4){
                        RegistationMainActivity parent = (RegistationMainActivity) getActivity();
                        parent.setPagerFragment(1);

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
