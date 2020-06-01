package com.cloudwell.paywell.consumer.activity.registation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cloudwell.paywell.consumer.R;
import com.cloudwell.paywell.consumer.activity.registation.EmailVerificationActivity;
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity;

/**
 * Created by Sepon on 4/15/2020.
 */
public class Reg_email_freg extends Fragment {

    EditText email_et;
    Button btn;
    public static Reg_email_freg newInstance() {
        return new Reg_email_freg();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reg_email_layout, container, false);


         btn = view.findViewById(R.id.email_btn);
        email_et = view.findViewById(R.id.email_et);
        email_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (email_et.getText().length() == 4){
                    btn.setBackgroundResource(R.drawable.round_btn_visable);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getActivity(), EmailVerificationActivity.class));
                        }
                    });
                }
            }
        });


        return view;
    }
}
