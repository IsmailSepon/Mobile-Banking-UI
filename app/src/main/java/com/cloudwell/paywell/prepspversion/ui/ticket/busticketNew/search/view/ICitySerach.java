package com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.search.view;

import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.busTransportList.base.BaseView;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.model.new_v.CitiesListItem;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2020-04-22.
 */
public interface ICitySerach extends BaseView {

    void generateCitylist(@Nullable List<CitiesListItem> it);
}
