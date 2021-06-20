package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.cloudwell.paywell.R;
import com.cloudwell.paywell.base.CustomKeyboard;
import com.cloudwell.paywell.utils.FragmentHelper;

/**
 * Created by Sepon on 4/15/2020.
 */
public class PreCreatePasswordFrag extends Fragment {

    public static PreCreatePasswordFrag newInstance() {
        return new PreCreatePasswordFrag();
    }

    PinEntryEditText creat_pin_et;
    CustomKeyboard keyboard;

    String name , number;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reg_one_layout, container, false);


        keyboard = view.findViewById(R.id.creat_pass_keyboard);
        creat_pin_et = view.findViewById(R.id.creat_pin_et);
        creat_pin_et.setRawInputType(InputType.TYPE_CLASS_TEXT);
        creat_pin_et.setTextIsSelectable(true);
        creat_pin_et.setShowSoftInputOnFocus(false);
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

//                        RegistationMainActivity parent = (RegistationMainActivity) getActivity();
//                        parent.setPagerFragment(1);

                        Bundle bundle = new Bundle();
                        bundle.putString("userName", name);
                        bundle.putString("userNumber", number);
                        bundle.putString("PIN", str.toString());

                        PreConfirmPasswordFeg frg = new PreConfirmPasswordFeg();
                        frg.setArguments(bundle);

                        FragmentHelper.addFirstFragment(frg, getActivity().getSupportFragmentManager(), R.id.pre_psp_auth_container);

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


        getIntentData();

        return view;
    }

    private void getIntentData() {

        name = getArguments().getString("userName");
        number = getArguments().getString("userNumber");



        Log.e("User Name : ", name);
        Log.e("User Number : ", number);
    }


}
