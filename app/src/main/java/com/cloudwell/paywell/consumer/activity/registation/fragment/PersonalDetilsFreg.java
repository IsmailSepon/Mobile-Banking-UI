package com.cloudwell.paywell.consumer.activity.registation.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cloudwell.paywell.consumer.R;
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Sepon on 4/15/2020.
 */
public class PersonalDetilsFreg extends Fragment {

    public static EditText name_et, dateofbirth_et;
    Button btn;
    private int mYear, mMonth, mDay, mHour, mMinute;

    public static PersonalDetilsFreg newInstance() {
        return new PersonalDetilsFreg();
    }


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_freg_layout, container, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setNestedScrollingEnabled(false);
        }

        btn = view.findViewById(R.id.nect_btn);
        dateofbirth_et = view.findViewById(R.id.date_of_birth);
        name_et = view.findViewById(R.id.fullname);
        dateofbirth_et.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Calendar calendar = Calendar.getInstance();

                    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.DatePickerDialogTheme, new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            Calendar newDate = Calendar.getInstance();
                            newDate.set(year, monthOfYear, dayOfMonth);

                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                            String date = simpleDateFormat.format(newDate.getTime());
                        }
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                    datePickerDialog.show();
                    return true;
                }
                return false;
            }
        });
//        dateofbirth_et.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Calendar calendar = Calendar.getInstance();
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.DatePickerDialogTheme, new DatePickerDialog.OnDateSetListener() {
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        Calendar newDate = Calendar.getInstance();
//                        newDate.set(year, monthOfYear, dayOfMonth);
//
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                        String date = simpleDateFormat.format(newDate.getTime());
//                    }
//                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
//
//                datePickerDialog.show();
//
////
////                // Get Current Date
////                final Calendar c = Calendar.getInstance();
////                mYear = c.get(Calendar.YEAR);
////                mMonth = c.get(Calendar.MONTH);
////                mDay = c.get(Calendar.DAY_OF_MONTH);
////
////
////                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
////                        new DatePickerDialog.OnDateSetListener() {
////
////                            @Override
////                            public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
////
////                                dateofbirth_et.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
////
////                            }
////                        }, mYear, mMonth, mDay);
////                datePickerDialog.show();
//            }
//        });
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
