package com.cloudwell.paywell.consumer.activity.registation.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.cloudwell.paywell.consumer.R;
import com.cloudwell.paywell.consumer.activity.registation.DatePickerFragmentDialog;
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity;

/**
 * Created by Sepon on 4/15/2020.
 */
public class Personal_detils_freg extends Fragment {

    public static EditText name_et, dateofbirth_et;
    Button btn;
    public static Personal_detils_freg newInstance() {
        return new Personal_detils_freg();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_freg_layout, container, false);


         btn = view.findViewById(R.id.nect_btn);
        dateofbirth_et = view.findViewById(R.id.date_of_birth);
        name_et = view.findViewById(R.id.fullname);
        dateofbirth_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragmentDialog();
                newFragment.show(getFragmentManager(),"Date Picker");
            }
        });
        name_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (name_et.getText().length() == 4){
                    btn.setBackgroundResource(R.drawable.round_btn_visable);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RegistationMainActivity parent = (RegistationMainActivity) getActivity();
                            parent.setPagerFragment(4);
                        }
                    });
                }
            }
        });


        return view;
    }
}
