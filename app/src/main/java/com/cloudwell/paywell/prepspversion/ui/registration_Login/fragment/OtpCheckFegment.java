package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.base.PinEntryEditText;
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.TokenResponse;
import com.cloudwell.paywell.retrofit.ApiUtils;
import com.cloudwell.paywell.utils.FragmentHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sepon on 4/15/2020.
 */
public class OtpCheckFegment extends Fragment {

    public static OtpCheckFegment newInstance() {
        return new OtpCheckFegment();
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

                if (etMobileOrRID.getText().length() == 6) {
                    hideKeyboardFrom(getActivity(), etMobileOrRID);

                    checkOTP(etMobileOrRID.getText());

//                    RegistationMainActivity parent = (RegistationMainActivity) getActivity();
//                    parent.setPagerFragment(3);
                 //   FragmentHelper.replaceFragment(new AddressFregment(), getActivity().getSupportFragmentManager(), R.id.pre_psp_auth_container);

                //    FragmentHelper.addFirstFragment(new RegistrationPersonalDetailsFragment(), getActivity().getSupportFragmentManager(), R.id.pre_psp_auth_container);
                }
            }
        });

        return view;
    }

    private void checkOTP(Editable text) {
        ApiUtils.getConsumerAPI().checkconsumerOTp("", "").enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });



    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
