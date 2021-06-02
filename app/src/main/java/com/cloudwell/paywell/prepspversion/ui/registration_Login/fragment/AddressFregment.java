package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.utils.FragmentHelper;

/**
 * Created by Sepon on 4/15/2020.
 */
public class AddressFregment extends Fragment {

    EditText name_et, dateofbirth_et;
    String[] country = {"Select Country", "Bangladesh", "India", "USA", "China", "Japan", "Other"};
    String[] district = {"Dhaka", "Barisal"};
    String[] thana = {"Badda", "Kalabagan"};
    String[] city = {"Dhaka", "Barisal"};
    Spinner country_sp, district_sp, thana_sp, city_sp;
    EditText address_et;
    Button address_btn;
    ImageView backBtn;

    public static AddressFregment newInstance() {
        return new AddressFregment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.address_freg_layout, container, false);

        address_et = view.findViewById(R.id.pre_address_er);
        address_btn = view.findViewById(R.id.pre_address_btn);
        backBtn = view.findViewById(R.id.pre_address_back);

        country_sp = view.findViewById(R.id.pre_country_spinner);
//        district_sp = view.findViewById(R.id.district_spinner);
//        thana_sp = view.findViewById(R.id.thana_spinner);
//        city_sp = view.findViewById(R.id.city_spinner);




        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        country_sp.setAdapter(aa);

//
//        if (dateofbirth_et.getText().length() == 4){
//            btn.setBackgroundResource(R.drawable.round_btn_visable);
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    RegistationMainActivity parent = (RegistationMainActivity) getActivity();
//                    parent.setPagerFragment(4);
//                }
//            });
//        }

        address_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (address_et.getText().length() == 4){
                    address_btn.setBackgroundResource(R.drawable.round_btn_visable);
            address_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    RegistationMainActivity parent = (RegistationMainActivity) getActivity();
//                    parent.setPagerFragment(5);

                    FragmentHelper.replaceFragment(new CurrencyFragment(), getActivity().getSupportFragmentManager(), R.id.pre_psp_auth_container);


                }
            });
                }

            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentHelper.removeFragment(getActivity().getSupportFragmentManager());
            }
        });



        return view;
    }


}
