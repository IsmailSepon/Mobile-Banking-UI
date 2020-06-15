package com.cloudwell.paywell.consumer.activity.registation.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cloudwell.paywell.consumer.R;
import com.cloudwell.paywell.consumer.activity.registation.customview.PinEntryEditText;
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity;

/**
 * Created by Sepon on 4/15/2020.
 */
public class Reg_three_Feg extends Fragment {

    public static Reg_three_Feg newInstance() {
        return new Reg_three_Feg();
    }
    PinEntryEditText etMobileOrRID;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reg_three_layout, container, false);


        etMobileOrRID = view.findViewById(R.id.etMobileOrRID);
        etMobileOrRID.requestFocus();
        etMobileOrRID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (etMobileOrRID.getText().length() == 6){
                    RegistationMainActivity parent = (RegistationMainActivity) getActivity();
                    parent.setPagerFragment(3);
                }
            }
        });

        return view;
    }
}
