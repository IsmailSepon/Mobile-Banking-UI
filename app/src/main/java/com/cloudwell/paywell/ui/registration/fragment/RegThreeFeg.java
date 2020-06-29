package com.cloudwell.paywell.ui.registration.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.base.PinEntryEditText;
import com.cloudwell.paywell.ui.registration.RegistationMainActivity;

/**
 * Created by Sepon on 4/15/2020.
 */
public class RegThreeFeg extends Fragment {

    public static RegThreeFeg newInstance() {
        return new RegThreeFeg();
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
