package com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.transportSelect;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.busTicketRepository.BusTicketRepository;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.fragment.BusTicketStatusFragment;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.fragment.OnClickListener;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.model.Transport;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.search.BusCitySearchActivity;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.transportSelect.view.IBusSeletedView;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.transportSelect.viewmodel.BusSelectedViewModel;
import com.cloudwell.paywell.R;
import com.cloudwell.paywell.app.AppHandler;
import com.cloudwell.paywell.base.BusTricketBaseActivity;
import com.cloudwell.paywell.data.preferences.AppStorageBox;
import com.cloudwell.paywell.eventBus.GlobalApplicationBus;
import com.cloudwell.paywell.eventBus.model.MessageToBottom;
import com.cloudwell.paywell.utils.UniqueKeyGenerator;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class TransportSelectActivity extends BusTricketBaseActivity implements View.OnClickListener, IBusSeletedView {

    private Spinner busListSpinner;
    private ArrayAdapter<String> busListAdapter;
    private ArrayList<String> busNameList = new ArrayList<>();
    private ArrayList<Transport> mTransportList = new ArrayList<>();
    CardView cardLayout;
    mehdi.sakout.fancybuttons.FancyButton btn_next;
    private BusTicketRepository mBusTicketRepository;
    private BusSelectedViewModel viewMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_select);

        setToolbar(getString(R.string.transport), getApplicationContext().getResources().getColor(R.color.bus_ticket_toolbar_title_text_color));


        cardLayout = findViewById(R.id.cardLayout);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);

        busListSpinner = findViewById(R.id.boothList);
        busListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, busNameList);
        busListSpinner.setAdapter(busListAdapter);

        showProgressDialog();

        if (isInternetConnection()) {
            String uniqueKey = UniqueKeyGenerator.getUniqueKey(AppHandler.getmInstance(this).getRID());
            callGetBusListAPI(uniqueKey);
        } else {
            showNoInternetConnectionFound();
        }

        busListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                AppStorageBox.put(TransportSelectActivity.this, AppStorageBox.Key.SELETED_BUS_INFO, mTransportList.get(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        initViewModel();

    }

    private void initViewModel() {
        viewMode = ViewModelProviders.of(this).get(BusSelectedViewModel.class);
        viewMode.setView(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        GlobalApplicationBus.getBus().register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        GlobalApplicationBus.getBus().unregister(this);
    }

    private void callGetBusListAPI(String uniqueKey) {
        mBusTicketRepository = new BusTicketRepository();
        mBusTicketRepository.getBusList(uniqueKey).observeForever(new Observer<List<Transport>>() {
            @Override
            public void onChanged(@Nullable List<Transport> transports) {
                mTransportList = (ArrayList<Transport>) transports;
                if (transports != null && transports.size() > 0) {
                    for (int a = 0; a < transports.size(); a++) {
                        busNameList.add(transports.get(a).getBusname());
                    }
                    busListAdapter.notifyDataSetChanged();
                    dismissProgressDialog();
                } else {
                    dismissProgressDialog();

                    BusTicketStatusFragment busTicketStatusFragment = new BusTicketStatusFragment();
                    BusTicketStatusFragment.message = getString(R.string.please_try_again);
                    busTicketStatusFragment.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick() {
                            finish();
                        }
                    });
                    busTicketStatusFragment.show(getSupportFragmentManager(), "dialog");
                }
            }
        });

    }

    public void goToSearchBusTicket(String uniqueKey) {
        AppStorageBox.put(TransportSelectActivity.this, AppStorageBox.Key.SELETED_BUS_INFO, mTransportList.get(busListSpinner.getSelectedItemPosition()));
        Transport transport = (Transport) AppStorageBox.get(getApplicationContext(), AppStorageBox.Key.SELETED_BUS_INFO);

        viewMode.getSchudle(isInternetConnection(), transport, uniqueKey);


    }


    @Subscribe
    public void getAuthError(MessageToBottom messageToBottom) {

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dismissProgressDialog();
                cardLayout.setVisibility(View.INVISIBLE);
                btn_next.setVisibility(View.VISIBLE);
                showDialogMesssageWithFinished(getString(R.string.services_alert_msg));
            }
        });


    }

    @Override
    public void onClick(View v) {
        String uniqueKey = UniqueKeyGenerator.getUniqueKey(AppHandler.getmInstance(this).getRID());
        goToSearchBusTicket(uniqueKey);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void openNextActivity() {
        Intent intent = new Intent(getApplicationContext(), BusCitySearchActivity.class);
        startActivity(intent);
    }

    @Override
    public void showErrorMessage(@org.jetbrains.annotations.Nullable String status) {
        BusTicketStatusFragment busTicketStatusFragment = new BusTicketStatusFragment();
        BusTicketStatusFragment.message = status;
        busTicketStatusFragment.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hiddenProgress() {
        dismissProgressDialog();
    }
}
