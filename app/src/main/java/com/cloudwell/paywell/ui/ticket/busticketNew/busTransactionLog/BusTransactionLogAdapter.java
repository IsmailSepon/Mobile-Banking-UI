package com.cloudwell.paywell.ui.ticket.busticketNew.busTransactionLog;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.ui.ticket.busticketNew.cancelList.CancelListActivity;
import com.cloudwell.paywell.ui.ticket.busticketNew.cencel.model.RequestTicketInformationForCancel;
import com.cloudwell.paywell.ui.ticket.busticketNew.model.BusTransactionModel;
import com.cloudwell.paywell.R;
import com.cloudwell.paywell.app.AppHandler;
import com.cloudwell.paywell.utils.FullScreenDialogPayWell;

import java.util.ArrayList;


/**
 * Created by YASIN on 03,July,2019
 * Email: yasinenubd5@gmail.com
 */
public class BusTransactionLogAdapter extends RecyclerView.Adapter<BusTransactionLogAdapter.TransactionLogViewHolder> {


    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private final AppCompatActivity context;
    private ArrayList busTransactionModelArrayList;

    public BusTransactionLogAdapter(ArrayList busTransactionModelArrayList, AppCompatActivity context) {
        this.busTransactionModelArrayList = busTransactionModelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public TransactionLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_SEPARATOR) {
            return new TransactionLogViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_trnsactionlog_list_item_header, parent, false));
        } else {
            return new TransactionLogViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_transactionlog_list_item_view, parent, false));

        }
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionLogViewHolder holder, int position) {

        int rowType;
        if (busTransactionModelArrayList.get(position) instanceof BusTransactionModel) {
            rowType = 0;
        } else {
            rowType = 1;
        }

        switch (rowType) {
            case TYPE_SEPARATOR:
                TextView header = holder.itemView.findViewById(R.id.busHeaderTitle);
                header.setText((String) busTransactionModelArrayList.get(position));
                break;
            case TYPE_ITEM:
                TextView tvBookingId = holder.itemView.findViewById(R.id.bookingIdTV);
                TextView tvTransactionId = holder.itemView.findViewById(R.id.tvTransactionId);
                TextView tvbookingIdStringTV = holder.itemView.findViewById(R.id.bookingIdStringTV);
                TextView tvWebBookingId = holder.itemView.findViewById(R.id.webBookingId);
                TextView tvWebBookingIDTV = holder.itemView.findViewById(R.id.WebBookingIDTV);
                TextView amount = holder.itemView.findViewById(R.id.priceTV);
                TextView status = holder.itemView.findViewById(R.id.statusTV);


                BusTransactionModel model = (BusTransactionModel) busTransactionModelArrayList.get(position);

                status.setText(model.getMessage());
                tvTransactionId.setText(model.getTransactioID());
                amount.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getTicketPrice());


                if (!model.getBookingId().equals("")) {
                    tvBookingId.setVisibility(View.VISIBLE);
                    tvbookingIdStringTV.setVisibility(View.VISIBLE);
                    tvBookingId.setText(model.getBookingId());
                } else {
                    tvBookingId.setVisibility(View.GONE);
                    tvbookingIdStringTV.setVisibility(View.GONE);
                }

                if (model.getWebBookingId() != null) {
                    tvWebBookingId.setVisibility(View.VISIBLE);
                    tvWebBookingIDTV.setVisibility(View.VISIBLE);

                    tvWebBookingId.setText(model.getWebBookingId());
                } else {
                    tvWebBookingId.setVisibility(View.GONE);
                    tvWebBookingIDTV.setVisibility(View.GONE);
                }


                ConstraintLayout linearLayout = holder.itemView.findViewById(R.id.mainClickLL);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FullScreenDialogPayWell fullScreenDialogPayWell = FullScreenDialogPayWell.newInstance("Transaction Details",
                                R.style.FullScreenDialogStyle, new FullScreenDialogPayWell.OnSetFullScreenDialogView() {
                                    @Override
                                    public View setView(LayoutInflater inflater, ViewGroup container, Dialog dialog) {
                                        View view1 = inflater.inflate(R.layout.transaction_details_dialog, container, false);
                                        Toolbar toolbar = view1.findViewById(R.id.toolbar);
                                        TextView bookingId = view1.findViewById(R.id.bookingIdTV);
                                        TextView webBookingId = view1.findViewById(R.id.webBookingIdTV);
                                        TextView busTrasLogId = view1.findViewById(R.id.busTrasLogId);
                                        TextView travelDateTV = view1.findViewById(R.id.travelDateTV);
                                        TextView priceTv = view1.findViewById(R.id.priceTV);
                                        TextView customerNameTV = view1.findViewById(R.id.customerNameTV);
                                        TextView customerGenderTV = view1.findViewById(R.id.customerGenderTV);
                                        TextView customerMobileTV = view1.findViewById(R.id.mobileNumTV);
                                        TextView ticketNum = view1.findViewById(R.id.ticketNumTV);
                                        TextView boardingPoint = view1.findViewById(R.id.boardingPointTV);
                                        TextView departureDateTV = view1.findViewById(R.id.departureDateTV);
                                        TextView departureTimeTV = view1.findViewById(R.id.departureTimeTV);
                                        TextView seatNumTV = view1.findViewById(R.id.seatNumTV);
                                        TextView coachNumTV = view1.findViewById(R.id.coachNumTV);
                                        TextView transportNameTV = view1.findViewById(R.id.transportNameTV);
                                        TextView journeyFromTV = view1.findViewById(R.id.journeyFromTV);
                                        TextView journeyToTV = view1.findViewById(R.id.journeyToTV);
                                        TextView addressTv = view1.findViewById(R.id.addressTv);
                                        TextView emailTv = view1.findViewById(R.id.emailTv);

                                        BusTransactionModel model = (BusTransactionModel) busTransactionModelArrayList.get(position);

                                        if (model.getBookingId() == null) {
                                            bookingId.setText(context.getString(R.string.not_available));
                                        } else {
                                            bookingId.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getBookingId());
                                        }

                                        if (model.getWebBookingId() == null) {
                                            webBookingId.setText(context.getString(R.string.not_available));
                                        } else {
                                            webBookingId.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getWebBookingId());
                                        }

                                        if (model.getCustomerName() == null) {
                                            customerNameTV.setText(context.getString(R.string.not_available));
                                        } else {
                                            customerNameTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getCustomerName());
                                        }

                                        if (model.getCustomerGender() == null) {
                                            customerGenderTV.setText(context.getString(R.string.not_available));
                                        } else {
                                            customerGenderTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getCustomerGender());
                                        }

                                        if (model.getCustomerPhone() == null) {
                                            customerMobileTV.setText(context.getString(R.string.not_available));
                                        } else {
                                            customerMobileTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getCustomerPhone());
                                        }

                                        if (model.getTicketNum() == null) {
                                            ticketNum.setText(context.getString(R.string.not_available));
                                        } else {
                                            ticketNum.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getTicketNum());
                                        }

                                        if (model.getCustomerAddress() == null) {
                                            addressTv.setText(context.getString(R.string.not_available));
                                        } else {
                                            addressTv.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getCustomerAddress());
                                        }

                                        if (model.getCustomerEmail() == null) {
                                            emailTv.setText(context.getString(R.string.not_available));
                                        } else {
                                            emailTv.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getCustomerEmail());
                                        }


                                        busTrasLogId.setText(model.getTransactioID());
                                        travelDateTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getDepartureDate());
                                        priceTv.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getTicketPrice());
                                        departureTimeTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getDepartureTime());
                                        seatNumTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getSeatNum());
                                        coachNumTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getCoachNum());
                                        transportNameTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getBusName());
                                        journeyFromTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getTravellingTo());
                                        journeyToTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getTravellingFrom());
                                        boardingPoint.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getBoardingPoint());
                                        departureDateTV.setText(((BusTransactionModel) busTransactionModelArrayList.get(position)).getDepartureDate());

                                        toolbar.setNavigationIcon(R.drawable.back);
                                        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                dialog.dismiss();
                                            }
                                        });
                                        toolbar.setBackgroundColor(context.getResources().getColor(R.color.color_tab_background_bus));
                                        toolbar.setTitle("Transaction Details");


                                        view1.findViewById(R.id.btBack).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog.dismiss();
                                            }
                                        });

                                        Button btCancelButton = view1.findViewById(R.id.btCancel);
                                        btCancelButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                startCancelListActivity(model);
                                            }
                                        });

                                        if (model.getBookingStatus().equals("200")){
                                            btCancelButton.setVisibility(View.VISIBLE);
                                        }else {
                                            btCancelButton.setVisibility(View.GONE);
                                        }

                                        return view1;
                                    }


                                    @Override
                                    public int describeContents() {
                                        return 0;
                                    }

                                    @Override
                                    public void writeToParcel(Parcel parcel, int i) {
                                    }
                                });


                        FragmentTransaction ft = context.getSupportFragmentManager().beginTransaction();
                       // fullScreenDialogPayWell.show(ft, TAG);
                    }
                });

                linearLayout.setOnLongClickListener((View.OnLongClickListener) v -> {

                    String transactioID = model.getTransactioID();
                    copy(transactioID);

                    return true;

                });


                break;
        }


    }

    private void startCancelListActivity(BusTransactionModel model) {
        AppHandler mAppHandler = AppHandler.getmInstance(context.getApplicationContext());

        RequestTicketInformationForCancel m = new RequestTicketInformationForCancel();
        m.setTrxId(model.getTransactioID());
        m.setTicketNo(model.getTicketNum());
        m.setUsername(mAppHandler.getUserName());

        Intent i = new Intent(context, CancelListActivity.class);
        i.putExtra("RequestTicketInformationForCancel", m);
        context.startActivity(i);
    }


    public void copy(String data) {
        ClipboardManager systemService = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        systemService.setText(data);
        Toast.makeText(context, "Transaction ID to clip", Toast.LENGTH_LONG).show();
    }


    @Override
    public int getItemViewType(int position) {
        if (busTransactionModelArrayList.get(position) instanceof BusTransactionModel) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return busTransactionModelArrayList.size();
    }

    public interface OnDialogClose {
        void onClose();
    }

    public class TransactionLogViewHolder extends RecyclerView.ViewHolder {
        public TransactionLogViewHolder(View itemView) {
            super(itemView);
        }
    }


}
