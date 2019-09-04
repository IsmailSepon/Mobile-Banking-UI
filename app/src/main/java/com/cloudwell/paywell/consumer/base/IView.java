package com.cloudwell.paywell.consumer.base;

import com.cloudwell.paywell.consumer.ui.auth.model.UserLoginResponse;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
public interface IView {
    void noInternetConnectionFound();
    void showProgress();
    void HiddenProgress();
    void onSuccess(UserLoginResponse userLoginResponse);
    void onFailure(String message);
}
