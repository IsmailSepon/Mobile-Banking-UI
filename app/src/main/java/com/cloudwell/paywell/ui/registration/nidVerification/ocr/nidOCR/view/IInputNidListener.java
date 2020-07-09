package com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.view;

import com.cloudwell.paywell.base.IBaseView;
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.model.User;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */
public interface IInputNidListener extends IBaseView {
    void openNextActivity(@NotNull User user);

    void setDefaultNIDImagInFirstNIDView();

    void setDefaultNIDImagInSecondNIDView();
}
