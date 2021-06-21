package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
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
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.DeviceProfile;
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegistrationRequest;
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.TokenResponse;
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.User;
import com.cloudwell.paywell.retrofit.ApiUtils;
import com.cloudwell.paywell.ui.registration.fragment.RegOneFeg;
import com.cloudwell.paywell.utils.FragmentHelper;
import com.vu.mobile.base.BaseFragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sepon on 4/15/2020.
 */
public class PreConfirmPasswordFeg extends BaseFragment {
    CustomKeyboard keyboard
            ;

    public static RegOneFeg newInstance() {
        return new RegOneFeg();
    }

    PinEntryEditText confirm_pin_et;
    String name , number, pin;
    private ProgressDialog dialog;

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

                        String mPin = str.toString();

                        if (mPin.equals(pin)){
                            register();

                        }else {
                            confirm_pin_et.setText("");
                            confirm_pin_et.setError("Incorrect");

                        }
                        //FragmentHelper.addFirstFragment(new PreEmailFreg(), getActivity().getSupportFragmentManager(), R.id.pre_psp_auth_container);

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

    private void register() {

        dialog = new ProgressDialog(requireActivity());
        dialog.show();

        RegistrationRequest registrationRequest = new RegistrationRequest();
        DeviceProfile profile = new DeviceProfile();

        profile.setAndroidId("test Sepon by API");// = "test Sepon by API"
        profile.setDeviceName("test Sepon by API"); //= "test Sepon by API"
        profile.setApiLevel("test Sepon by API"); //= "test Sepon by API"
        profile.setOsName("test Sepon by API"); //= "test Sepon by API"
        profile.setRefId("test Sepon by API"); //= "test Sepon by API"
        profile.setModel("test Sepon by API"); //= "test Sepon by API"
        profile.setAppVersionNo("test Sepon by API");//= "test Sepon by API"


        User user = new User();
        user.setPassword(pin);
        user.setUsername(number);

        registrationRequest.setDeviceProfile(profile);
        registrationRequest.setUser(user);



        ApiUtils.getConsumerAPI().userRegister(registrationRequest).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                if (response.isSuccessful()){
                    getToken(user);
                    Log.e("get TOKEN ", "tokrn API");

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                dialog.dismiss();
            }
        });


    }

    private void getToken(User user) {

        User user1 = new User();
        user1.setPassword("cloudwell");
        user1.setUsername("faizshiraji");

        ApiUtils.getConsumerAPI().userToken(user1).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                dialog.dismiss();
               // Toast.makeText(requireActivity(), " "+response.body().getJwttoken().toString(), Toast.LENGTH_SHORT).show();
                TokenResponse tokenResponse = response.body();
                Log.e("response", tokenResponse.getJwttoken());
                getRefreshToken(tokenResponse.getJwttoken());
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

                dialog.dismiss();
            }
        });
    }

    private void getRefreshToken(String jwttoken) {



    }


    private void getIntentData() {

        name = getArguments().getString("userName");
        number = getArguments().getString("userNumber");
        pin = getArguments().getString("PIN");


        Log.e("User Name : ", name);
        Log.e("User Number : ", number);
    }

}