package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.otp;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-11-19.
 */
public interface OtpReceivedInterface {
    void onOtpReceived(String otp);
    void onOtpTimeout();
}
