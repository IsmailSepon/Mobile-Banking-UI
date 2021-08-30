package com.cloudwell.paywell.retrofit;


import com.cloudwell.paywell.prepspversion.MovieResponse;
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegistrationRequest;
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.TokenResponse;
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.User;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.booking.model.BookingList;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.bookingStatus.model.ResIssueTicket;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.finalReview.model.RequestAirPrebookingSearchParamsForServer;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.finalReview.model.ResAirPreBooking;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.finalReview.model.ResBookingAPI;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.model.RequestAirPriceSearch;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.model.ResposeAirPriceSearch;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.flightDetails1.model.airRules.ResposeAirRules;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.ticketCencel.model.ResSingleBooking;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.ticketViewer.model.ResInvoideEmailAPI;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.cencel.model.RequestOtpCheck;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.cencel.model.ResposeOptCheck;
import com.cloudwell.paywell.activity.model.RequestChangePin;
import com.cloudwell.paywell.app.APIResposeGenerateToken;
import com.cloudwell.paywell.notification.model.ResposeReScheduleNotificationAccept;
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.ReposeAirSearch;
import com.cloudwell.paywell.prepspversion.ui.ticket.airticket.airportSearch.model.RequestAirSearch;
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.search.model.ResGetAirports;
import com.cloudwell.paywell.services.activity.eticket.airticket.flightSearch.model.ResCommistionMaping;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.busTransactionLog.RequestBusTranstionLog;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.cencel.model.RequestTicketInformationForCancel;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.cencel.model.ResponseTicketInformationCancel;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.model.RequestRenerateOtpForCancelTicket;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.model.ResGetBusListData;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.model.ResPaymentBookingAPI;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.BusLunCityRequest;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.BusLunCityResponse;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.CancelBookedTicketReques;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.CancelBookedTicketResponse;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.GetSeatViewRquestPojo;
import com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.model.new_v.RequestScheduledata;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.SeatBlockRequestPojo;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.TicketInformationForCancelRequest;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.ticket_confirm.ReqConfirmTicket;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.ticket_confirm.ResBookAPI;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.ticket_confirm.ResposeTicketConfirm;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.ticket_confirm_cancel.ConfirmTicketCancelResponse;
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.transactionLog.TransactionLogDetailsModel;
import com.cloudwell.paywell.activity.model.ReposeGenerateOTP;
import com.cloudwell.paywell.services.activity.home.model.RequestGenerateOTP;
import com.cloudwell.paywell.services.activity.home.model.forgetPin.ReposeForgetPIn;
import com.cloudwell.paywell.services.activity.home.model.forgetPin.RequestForgetPin;
import com.cloudwell.paywell.services.activity.notification.model.RequestSDABalancceRetrun;
import com.cloudwell.paywell.services.activity.notification.model.ResNotificationAPI;
import com.cloudwell.paywell.services.activity.notification.model.deletetNotification.ReposeDeletedNotification;
import com.cloudwell.paywell.services.activity.notification.model.deletetNotification.RequestDeletedNotification;
import com.cloudwell.paywell.services.activity.notification.model.getNotification.RequestNotificationAll;
import com.cloudwell.paywell.utils.ParameterUtility;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/29/18.
 */
public interface APIService {


    @POST()
    @FormUrlEncoded
    Call<APIResposeGenerateToken> callGenerateToken(@Url String ur, @Header("Authorization") String AuthorizationKey, @FieldMap Map<String, String> params);
//
//    @POST("Recharge/mobileRecharge/bulkTopup")
//    Call<TopupReposeData> callTopAPI(@Body RequestTopup requestTopup);
//
//    @POST("Recharge/mobileRecharge/singleTopup")
//    Call<SingleTopupResponse> callSingleTopUpAPI(@Body RequestSingleTopup singleTopup);
//
//
//    @POST("Retailer/RetailerService/getRtlrSDAinfo")
//    Call<ResponseBody> getRtlrSDAinfo(@Body RequestSDAInfo requestSDAInfo);
//
//    @POST("Retailer/BankDepositSystem/getDistrictListforBankDeposit")
//    Call<ReposeDistrictListerBankDeposit> callDistrictDataAPI(@Body RequestDistrict requestDistrict);
//
//    @POST("Retailer/BankDepositSystem/getBankBranch")
//    Call<BranchData> callBranchDataAPI(@Body RequestBranch requestBranch);
//
//
//    @POST("Retailer/BankDepositSystem/getBankInfo")
//    Call<BankResponse> callBankDataAPI(@Body GetBankPojo bankPojo);
//
//
//    @POST("Retailer/BankDepositSystem/depositBankSlip")
//    Call<RefillRequestData> callBalanceRefillAPI(@Body RequestRefillBalance requestRefillBalance);
//
//    @POST("Retailer/RetailerService/checkBalance")
//    Call<APIResBalanceCheck> callCheckBalance(@Body RequestBalanceCheck requestBalanceCheck);
//
//
//    @POST("Notification/NotificationSystem/setUserFCMToken")
//    Call<ResponseBody> setUserFCMToken(@Body RequestUserFCMToken requestUserFCMToken);
//
//    @POST("Notification/NotificationSystem/getUnreadNotifications")
//    Call<APIResNoCheckNotification> callCheckNotification(@Body RequestNotification requestNotification);
//
    @POST("Notification/NotificationSystem/getNotificationsbyType")
    Call<ResNotificationAPI> callNotificationAPI(@Body RequestNotificationAll requestNotification);
//
//    @POST("Notification/NotificationSystem/notificationCheckAndroid")
//    Call<ResNotificationReadAPI> callNotificationReadAPI(@Body RequestNotificationAll requestNotification);

    @POST("Notification/NotificationSystem/userNotificationDelete")
    Call<ReposeDeletedNotification> deleteNotification(@Body RequestDeletedNotification requestDeletedNotification);


    @POST("SDA/SDASystem/SDAToMerchentBalanceReturn")
    Call<ResponseBody> SDAToMerchentBalanceReturn(@Body RequestSDABalancceRetrun RequestSDABalancceRetrun);


    @Multipart
    @POST("PaywelltransactionHaltrip/airSearch")
    Call<ReposeAirSearch> callAirSearch(@Part("username") String username,
                                        @Part("search_params") RequestAirSearch search_params,
                                        @Part(ParameterUtility.KEY_REF_ID) String refId);


    @Multipart
    @POST("PaywelltransactionHaltrip/airPriceSearch")
    Call<ResposeAirPriceSearch> callairPriceSearch(@Part("username") String username,
                                                   @Part("search_params") RequestAirPriceSearch search_params,
                                                   @Part(ParameterUtility.KEY_REF_ID) String refId);
//
//
    @Multipart
    @POST("PaywelltransactionHaltrip/airRulesSearch")
    Call<ResposeAirRules> airRulesSearch(@Part("username") String username,
                                         @Part("search_params") RequestAirPriceSearch search_params);


    @GET("PaywelltransactionHaltrip/getAirports?")
    Call<ResGetAirports> getAirports(@Query("username") String username, @Query("format") String format, @Query("iso") String iso, @Query(ParameterUtility.KEY_REF_ID) String refId);

    @FormUrlEncoded
    @POST("PaywelltransactionHaltrip/getBookingList")
    Call<BookingList> callAirBookingListSearch(@Field("username") String username,
                                               @Field("limit") int limit,
                                               @Field(ParameterUtility.KEY_REF_ID) String refId);

    @Multipart
    @POST("PaywelltransactionHaltrip/airPreBooking")
    Call<ResAirPreBooking> airPreBooking(@Part("username") String username,
                                         @Part("format") String format,
                                         @Part("search_params") RequestAirPrebookingSearchParamsForServer search_params,
                                         @Part(ParameterUtility.KEY_REF_ID) String refId);


    @Multipart
    @POST("PaywelltransactionHaltrip/airBooking")
    Call<ResBookingAPI> airBooking(@Part("username") String username,
                                   @Part("password") String password,
                                   @Part("format") String format,
                                   @Part("search_params") RequestAirPrebookingSearchParamsForServer search_params,
                                   @Part(ParameterUtility.KEY_REF_ID) String refId);

    @POST("PaywelltransactionHaltrip/cancelBooking")
    @FormUrlEncoded
    Call<JsonObject> cancelBooking(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("BookingID") String bookingId,
                                   @Field("reason") String cancelReason,
                                   @Field("format") String apiFormat,
                                   @Field(ParameterUtility.KEY_REF_ID) String refId);


    @POST("PaywelltransactionHaltrip/cancelTicket")
    @FormUrlEncoded
    Call<JsonObject> cancelTicket(@Field("username") String username,
                                  @Field("password") String password,
                                  @Field("BookingID") String bookingId,
                                  @Field("reason") String cancelReason,
                                  @Field("cancel_type") String cancel_type,
                                  @Field("format") String apiFormat,
                                  @Field(ParameterUtility.KEY_REF_ID) String refId);

    @POST("PaywelltransactionHaltrip/reIssueTicket")
    @FormUrlEncoded
    Call<JsonObject> reIssueTicket(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("BookingID") String bookingId,
                                   @Field("reason") String cancelReason,
                                   @Field(ParameterUtility.KEY_REF_ID) String refId);


    @POST("/PaywelltransactionHaltrip/reScheduleTicket")
    @FormUrlEncoded
    Call<JsonObject> reScheduleTicket(@Field("username") String username,
                                      @Field("password") String password,
                                      @Field("BookingID") String bookingId,
                                      @Field("reason") String cancelReason,
                                      @Field("SearchId") String searchId,
                                      @Field("ResultID") String resultID,
                                      @Field("format") String apiFormat);

    @POST("/PaywelltransactionHaltrip/infoUpdateTicket")
    @Multipart
    Call<JsonObject> infoUpdateTicket(@Part("username") String username,
                                      @Part("password") String password,
                                      @Part("BookingID") String bookingId,
                                      @Part("reason") String cancelReason,
                                      @Part("passengers") String passengers,
                                      @Part(ParameterUtility.KEY_REF_ID) String refId);


//    @POST("PaywelltransactionHaltrip/getCancelMap")
//    @FormUrlEncoded
//    Call<ResCancellationMapping> getCancelMap(@Field("username") String username,
//                                              @Field("booking_id") String bookingId,
//                                              @Field(ParameterUtility.KEY_REF_ID) String refId);
//
    @Multipart
    @POST("PaywelltransactionHaltrip/uploadBookingFiles")
    Call<JsonObject> uploadBookingFiles(@Part("username") String username,
                                        @Part("booking_id") String password,
                                        @Part("params") String fileUploadReqSearchPara);
//

    @POST("PaywelltransactionHaltrip/send_invoice_to_user")
    @Multipart
    Call<ResInvoideEmailAPI> callSendInvoiceAPI(@Part("username") String username,
                                                @Part("booking_id") String bookingId,
                                                @Part("price_invoice_status") int priceInvoiceStatus,
                                                @Part("email_address") String email_address);
//

    @POST("PaywelltransactionHaltrip/getCommissionMapping")
    @Multipart
    Call<ResCommistionMaping> callGetCommissionMappingAPI(@Part("username") String username, @Part(ParameterUtility.KEY_REF_ID) String refId);

//
    @POST("PaywelltransactionHaltrip/getSingleBooking")
    @Multipart
    Call<ResSingleBooking> getSingleBooking(@Part("username") String username, @Part("booking_id") String bookingId, @Part(ParameterUtility.KEY_REF_ID) String refId);
//
    @POST("PaywelltransactionHaltrip/airTicketIssue")
    @Multipart
    Call<ResIssueTicket> callIssueTicketAPI(@Part("username") String username, @Part("password") String password, @Part("BookingID") String BookingID, @Part("IsAcceptedPriceChangeandIssueTicket") boolean ssAcceptedPriceChangeandIssueTicket, @Part(ParameterUtility.KEY_REF_ID) String refId);
//
//
    @POST("PaywelltransactionHaltrip/reIssueNotificationAccept")
    @Multipart
    Call<ResposeReScheduleNotificationAccept> reIssueNotificationAccept(@Part("username") String username, @Part("id") int id, @Part("accept_status") int accept_status);

//
//    @POST()
//    @Multipart
//    Call<ResEkShopToken> getEkshopToken(@Url String url, @Part("uid") String rid, @Part("utype") String utype, @Part(ParameterUtility.KEY_REF_ID) String refId);
//
//    @POST()
//    @Multipart
//    Call<ResEKReport> getReport(@Url String url, @Part("uid") String rid, @Part("start_date") String start_date, @Part("end_date") String end_date, @Part("order_code") String order_code, @Part(ParameterUtility.KEY_REF_ID) String refId);
//
    @POST("PaywellParibahanService/getBusListData")
    @FormUrlEncoded
    Call<ResGetBusListData> getBusListData(@Field("username") String username, @Field("skey") String skey, @Field(ParameterUtility.KEY_REF_ID) String refId);



    @POST("PaywellParibahanService/getBusSchedule?")
    @FormUrlEncoded
    Call<ResponseBody> getBusSchedule(@Field("username") String username, @Field("transport_id") String transport_id, @Field("skey") String skey, @Field("accessKey") String accessKey, @Field(ParameterUtility.KEY_REF_ID) String refId);

//
//    @FormUrlEncoded
//    @POST("PaywellParibahanService/seatCheck")
//    Call<ResponseBody> seatCheck(@Field("username") String username,
//                                 @Field("skey") String skey,
//                                 @Field("accessKey") String accessKey,
//                                 @Field("transport_id") String transport_id,
//                                 @Field("route") String route,
//                                 @Field("bus_id") String bus_id,
//                                 @Field("departure_id") String departure_id,
//                                 @Field("departure_date") String departure_date,
//                                 @Field("seat_ids") String seat_ids,
//                                 @Field(ParameterUtility.KEY_REF_ID) String refId);
//

    @POST("Tickets/BusAndLaunchService/getTransactionData")
    Call<TransactionLogDetailsModel> getBusTransactionLogFromServer(@Body RequestBusTranstionLog requestBusTranstionLog);
//
//    @POST
//    @FormUrlEncoded
//    Call<String> getToken(@Url String ur,
//                          @Field("rid") String rid);
//
//
//    @FormUrlEncoded
//    @POST("PaywellParibahanService/seatCheckAndBlock")
//    Call<ResSeatCheckBookAPI> seatCheckAndBlock(@Field("userName") String username,
//                                                @Field("skey") String skey,
//                                                @Field("accessKey") String accessKey,
//                                                @Field("transport_id") String transport_id,
//                                                @Field("transport_lbls") String transport_lbls,
//                                                @Field("route") String route,
//                                                @Field("bus_id") String bus_id,
//                                                @Field("bus_lbls") String bus_lbls,
//                                                @Field("coach_no") String coach_no,
//                                                @Field("departure_id") String departure_id,
//                                                @Field("departure_date") String departure_date,
//                                                @Field("departure_time") String departure_time,
//                                                @Field("boarding_point_id") String boarding_point_id,
//                                                @Field("boarding_point_name") String boarding_point_name,
//                                                @Field("seat_ids") String seat_ids,
//                                                @Field("seat_lbls") String seat_lbls,
//                                                @Field("bus_is_ac") String bus_is_ac,
//                                                @Field("extra_charge") Double extra_charge,
//                                                @Field("ticket_price") Double ticket_price,
//                                                @Field("total_amount") String total_amount,
//                                                @Field(ParameterUtility.KEY_REF_ID) String refId);

    @FormUrlEncoded
    @POST("PaywellParibahanService/confirmPayment")
    Call<ResPaymentBookingAPI> confirmPayment(@Field("username") String username,
                                              @Field("skey") String skey,
                                              @Field("accessKey") String accessKey,
                                              @Field("transactionId") String transactionId,
                                              @Field("customerName") String customerName,
                                              @Field("customerPhone") String customerPhone,
                                              @Field("customerAddress") String customerAddress,
                                              @Field("customerEmail") String customerEmail,
                                              @Field("customerAge") String customerAge,
                                              @Field("customerGender") String customerGender,
                                              @Field("password") String password,
                                              @Field(ParameterUtility.KEY_REF_ID) String refId);
//
//    @POST("Utility/PollyBiddyutSystem/pollyBiddyutBillPayAsync")
//    Call<PalliBidyutBillPayResponse> postPalliBidyutBills(@Body PalliBidyutBillPayRequest body);
//
//
//    @POST("Retailer/BalanceRefill/nagodTrxClaim")
//    Call<ResTranstionINquiry> BalanceClaimRequest(@Body BalanceClaimModel balanceClaimModel);
//
//    @POST("Retailer/BalanceRefill/nagodSuccessfulTrxList")
//    Call<RefillLog> refillLogInquiry(@Body RefillLogRequestModel RefillLogRequestModel);
//
//
//    @POST("MYCash/Utility/DESCOPrepaid_billInfo")
//    Call<DescoInquiryResponse> descoInquiryRequest(@Body DescoRequestInquiryModel requestInquiryModelDesco);
//
//    @POST("MYCash/Utility/DESCOPrepaid_billPayment")
//    Call<DescoBillPaySubmitResponse> descoBillPayement(@Body DescoBillPaySubmit descoBillPaySubmit);
//
//
//
//
//
//    @POST("Registration/UserRegistration/userInformationForRegistration")
//    Call<ResponseBody> userInformationForRegistration(@Body RegistrationModel regModel);
//
//
//    @POST("Retailer/RetailerService/userServiceProfiling")
//    Call<ReposeUserProfile> userServiceProfiling(@Body AuthRequestModel regModel);
//
//    @POST("Registration/UserRegistration/userServiceProfilingReg")
//    Call<ReposeUserProfile> userServiceProfilingReg(@Body AuthRequestModel regModel);
//
//
//    @POST("Registration/UserRegistration/unverifiedDataUpdate")
//    Call<ResponseBody> unverifiedDataCollectAndUpdate(@Body JsonObject body);
//
    @POST("Authantication/PaywellAuth/getToken?")
    Call<ResposeAppsAuth> getAppsAuthToken(@Header("Authorization") String AuthorizationKey, @Body RequestAppsAuth body);
//
    @POST("Authantication/PaywellAuth/refreshToken")
    Call<ResposeAppsAuth> refreshToken(@Header("Authorization") String AuthorizationKey, @Body RequestRefreshToken body);
//

    @POST("Authantication/PaywellAuth/checkOTP")
    Call<ResposeOptCheck> checkOTP(@Body RequestOtpCheck body);
//

    @POST("Authantication/PaywellAuth/resetPassword")
    Call<ReposeForgetPIn> resetPassword(@Body RequestForgetPin body);


    @POST("Authantication/PaywellAuth/changePassword")
    Call<ReposeForgetPIn> changePassword(@Body RequestChangePin body);


    @POST("Authantication/PaywellAuth/generateOTP")
    Call<ReposeGenerateOTP> generateOTP(@Body RequestGenerateOTP body);
//
//
//    @POST("Reports/TransactionReportSystem/TransactionReport")
//    Call<ResponseBody> PBInquiry(@Body ReqInquiryModel regModel);
//
//
//    @POST("Utility/PollyBiddyutSystem/pollybuddutRegistration")
//    Call<ResposePBReg> pollybuddutRegistration(@Body RequestPBRegistioin RequestPBRegistioin);
//
//
//    @POST("Utility/PollyBiddyutSystem/pollyBiddyutBillStatus")
//    Call<ResBIllStatus> callBillStatusRequestAPI(@Body RequestBillStatus requestBillStatus);
//
//
//
//    @POST("Utility/PollyBiddyutSystem/pollyBiddyutPhoneNoChange")
//    Call<ResposeMobileNumberChange> pollyBiddyutPhoneNoChange(@Body RequestMobileNumberChange requestBillStatus);
//
//
//
//    @POST("Android/AndroidWebViewController/StatementInquiry")
//    Call<ResponseBody> StatementInquiry(@Body RequestBody body);
//
//
//    @POST("Android/AndroidWebViewController/balanceStatement")
//    Call<ResponseBody> balanceStatement(@Body RequestBody body);
//
//
//    @POST("Android/AndroidWebViewController/salesStatement")
//    Call<ResponseBody> salesStatementForhttps(@Body RequestBody body);
//
//    @POST("Android/AndroidWebViewController/getAllTransactionStatement")
//    Call<ResponseBody> getAllTransactionStatementForHttps(@Body RequestBody body);
//
//
//    @POST("PaymentGateway/PaymentGatewaySystem/card")
//    Call<ResponseBody> card(@Body RequestBody body);
//
//
//    @POST("Recharge/BrilliantRecharge/transactionLog")
//    Call<APIBrilliantTRXLog> getBrillintTNXLog(@Body BrillintTNXLog requestBrillintTNXLog);
//
//    @POST("Recharge/BrilliantRecharge/addBalance")
//    Call<ResponseBody> addBrillintBalance(@Body BrillintAddBalanceModel requestBrillintAddBalance);
//
//
//    @POST("Recharge/BrilliantRecharge/transactionEnquiry")
//    Call<BrilliantTopUpInquiry> getEnquery(@Body EnqueryModel requestEnqueryModel);
//
//    @POST("Utility/IvacSystem/getIvacCenter")
//    Call<ResponseBody> getIvacCenter(@Body GetIvacCenterModel requestGetIvacCenter);
//
//    @POST("Utility/IvacSystem/IVACRequest")
//    Call<ResponseBody> confirmFeePay(@Body IvacFeePayModel confirmFeePay);
//
//
//    @POST("Utility/IvacSystem/getIvacTrxByWebFileNo")
//    Call<IvcTrxResponseModel> getIvacTrx(@Body GetIvacTrx getIvacTrx);
//
//    @POST("Utility/IvacSystem/getIvacTrxList")
//    Call<ResponseBody> getIvacTrxList(@Body IvacTrxListModel ivacTrxListModel);
//
//    @POST("Retailer/RetailerService/doUpdateRetailersCurrentLocation")
//    Call<ResponseBody> updateCurrentLocation(@Body CurrentLocationModel locationModel);
//
//
//    @POST("Retailer/RetailerService/updateMarchentAndBusinessType")
//    Call<ResponseBody> updateMerchentBusiness(@Body MerchantRequestPojo merchantRequestPojo);
//
//    @POST("Registration/UserRegistration/userSubBusinessType")
//    Call<ResponseBody> getUserSubBusinessType(@Body UserSubBusinessTypeModel userSubBusinessTypeModel);
//
//    @POST("Registration/UserRegistration/getDistrictInfo")
//    Call<RespsoeGetDistrictList> getDistrictInfo(@Body RequestDistrictList requestDistrictList);
//
//
//    @POST("Registration/UserRegistration/getThanaInfo")
//    Call<ResponseBody> getThanaInfo(@Body RequestThanaAPI requestThanaAPI);
//
//
//    @POST("Registration/UserRegistration/getPostOfficeInfo")
//    Call<ResponseBody> getPostOfficeInfo(@Body RequestPostCodeList requestPostCodeList);
//    @POST("Reports/TransactionReportSystem/TransactionReport")
//    Call<TranscationLogResponseModel> getTransactionLog(@Body TranscationRequestModel transcationRequestModel);
//
//    @POST("Recharge/mobileRecharge/rechargeOffer")
//    Call<ResponseBody> getRechargeOffer(@Body RechargeOfferRequestModel rechargeOfferRequestModel);
//
//    @POST("Recharge/mobileRecharge/mobileRechargeEnquiry")
//    Call<RechargeEnqueryResponseModel> getRechargeEnquiry(@Body RechargeEnqueryModel rechargeEnqueryModel);
//
//    @POST("MYCash/Utility/getDESCOBillInfo")
//    Call<DESCOBillInfoResponse> getDESCOBillInfo(@Body DESCOBillInfo descoBillInfo);
//
//
//    @POST("MYCash/Utility/DESCOBillPay")
//    Call<BillPayResponseModel> confirmBillPay(@Body BillPayMOdel billPayMOdel);
//
//    @POST("MYCash/Utility/getKGDCLBillInfo")
//    Call<SubmitInquiry> kgdlcSubmitInquiry(@Body KgdlcBillInfoRequest kgdlcBillInfoRequest);
//
//    @POST("MYCash/Utility/KGDCLBillPay")
//    Call<SubmitBillResponse> kgdlcSubmitBill(@Body SubmitBillRequestPojo submitBillRequestPojo);
//
//    @POST("MYCash/Utility/getDPDCBillInfo")
//    Call<DpdcResponse> getDPDCBillInfo(@Body DPDCbillInfoModel dpdCbillInfoModel);
//
//    @POST("MYCash/Utility/DPDCBillPay")
//    Call<DpdcResponse> submitDPDCBillPay(@Body DPDCBillPayModel dpdcBillPayModel);
//
//
//    @POST("MYCash/MFS/generateOTP")
//    Call<ResponseBody> generateOTPMYCash(@Body com.cloudwell.paywell.services.activity.mfs.mycash.cash.model.RequestGenerateOTP RequestGenerateOTP);
//
//    @POST("MYCash/MFS/miniStatement")
//    Call<ResponseBody> miniStatement(@Body RequestMiniStatment requestMiniStatment);
//
//
//    @POST("MYCash/MFS/balanceEnquiry")
//    Call<ResponseBody> balanceEnquiry(@Body RequestBalanceInquray requestBalanceInquray);
//
//    @POST("MYCash/MFS/fundManagement")
//    Call<ResponseBody> fundManagement(@Body RequestFundManagment requestFundManagment);
//
//    @POST("MYCash/MFS/customerRegistration")
//    Call<ResponseBody> customerRegistration(@Body RequestLCustomerReg requestLCustomerReg);
//
//    @POST("MYCash/MFS/cashIn")
//    Call<ResponseBody> cashIn(@Body RequestCashIn requestCashIn);
//
//    @POST("MYCash/MFS/changePIN")
//    Call<ResponseBody> changePinNumber(@Body RequestChangePInNumber RequestChangePInNumber);
//
//
//    @POST("MYCash/MFS/lastTransactionList")
//    Call<ResponseBody> lastTransactionList(@Body RequestTrxInquiry requestTrxInquiry);
//
//
//    @POST("MYCash/MFS/lastSuccessfulCashOutList")
//    Call<ResponseBody> cashOut(@Body RequestCashOut requestCashOut);
//
//    @POST("MYCash/MFS/doMyCahsToCashOrBankTransfer")
//    Call<ResponseBody> myCasyhToCashOrBankTransfer(@Body RequestBalanceTransferRequest RequestBalanceTransferRequest);
//
//
//    @POST("MYCash/MFS/checkMyCashPendingCashRequest")
//    Call<ResponseBody> checkMyCashPendingCashRequest(@Body RequestBalanceTransferConfirm requestBalanceTransferConfirm);
//
//    @POST("MYCash/Utility/getWASABillInfo")
//    Call<ResponseBody> getWASABillInfo(@Body WASABillInfoModel wasaBillInfoModel);
//
//    @POST("MYCash/MFS/myCashPendingCashRequestConfirmation")
//    Call<ResponseBody> myCashPendingCashRequestConfirmation(@Body ReqeustPaymentConfmation ReqeustPaymentConfmation);
//
//    @POST("MYCash/Utility/WASABillPay")
//    Call<ResponseBody> submitWASABillPay(@Body SubmitBill submitBill);
//
//    @POST("MYCash/MFS/getMYCashRetailerPayWellBalance")
//    Call<ResponseBody> getMYCashRetailerPayWellBalance(@Body RequestBalacne requestBalacne);
//
//    @POST("MYCash/Utility/getWZPDCLBillInfo")
//    Call<ResponseBody> getWZPDCLBillInfo(@Body WZPDCLBillInfo wzpdclBillInfo);
//
//    @POST("MYCash/Utility/WZPDCLBillPay")
//    Call<ResponseBody> submitWZPDCLBillPay(@Body WZPDCLBillPayModel wzpdclBillPayModel);
//
//    @POST("Utility/InternetBillPay/banglalionBillPay")
//    Call<ResponseBody> banglalionRecharge(@Body RechargeRequestPojo rechargeRequestPojo);
//
//    @POST("Utility/InternetBillPay/banglalionEnquiry")
//    Call<ResponseBody> banglalionRechargeInquiry(@Body RechargeResponsePojo rechargeResponsePojo);
//
//    //BBC
//    @POST("Utility/BBC/getCourseList")
//    Call<CourseListRresponsePojo> getBBCcourseList(@Body CourseLlistRequestPojo pojo);
//
//    @POST("Utility/BBC/registrationInfo")
//    Call<StatusCheckResponsePojo> getBBCregistationInfo(@Body RegistationInfo pojo);
//
//    @POST("Utility/BBC/subscription")
//    Call<ResponseBody> getBBCsubscribe(@Body BbcSubscriptionPojo pojo);
//
//    @POST("Reports/TransactionReportSystem/TransactionReport")
//    Call<TransactionResponsePOjo> getBBCTransactionLog(@Body BbcTranscationLog transcationLog);
//
//    //new Nagdh
//    @POST("PaymentGateway/PaymentGatewaySystem/nagadApiProcess")
//    Call<NagadWebResponse> gestNahadg(@Body Nagadv2requestPojo nagadv2requestPojo);
//
//
//    //Bank info
//    @POST("Retailer/BankDepositSystem/addRtlrBankInfo")
//    Call<ResposeAddLinkBankAccount> uploadBankInfo(@Body BankPojo bankPojo);
//
//    @POST("Retailer/BankDepositSystem/getRtlrBankAccList")
//    Call<BankLinkedListResponsePojo> getRetailerBankList(@Body BankListRequestPojo bankListRequestPojo);
//
//    @POST("Retailer/BankDepositSystem/removeBankAccount")
//    Call<ResponseBody> removeBankInfo(@Body RemoveReqPojo removeReqPojo);
//
//    //Bongo
//    @POST("Utility/Bongo/getBannerList")
//    Call<BongoBannerResponse> getBannerList(@Body BongoPkgListReqPojo bongoPkgListReqPojo);
//
//    @POST("Utility/Bongo/getPackageList")
//    Call<BongoResponsePojo> getBongoPackgeList(@Body BongoPkgListReqPojo bongoPkgListReqPojo);
//
//    @POST("Utility/Bongo/activatePackage")
//    Call<BongoActiveResponse> getBongoActivePackgeList(@Body BongoActivePkgPojo bongoActivePkgPojo);
//
//    @POST("Utility/Bongo/getSubscriptionCount")
//    Call<CountResponse> getBongoSubscriptionCount(@Body BongoSubscriptionPojo bongoSubscriptionPojo);
//
//    @POST("Reports/TransactionReportSystem/TransactionReport")
//    Call<BongoTRXresponse> getBongoTransactionLog(@Body BongoTRXrequestModel transcationLog);
//
////    @POST("Retailer/BankDepositSystem/removeBankAccount")
////    Call<ResponseBody> removeBankInfo(@Body RemoveReqPojo removeReqPojo);
//
//
//
//
//    //Bus lunch ticket new version

    @POST("Tickets/BusAndLaunchService/busAndLaunchCities")
    Call<BusLunCityResponse> getbusAndLaunchCities(@Body BusLunCityRequest busLunCityRequest);

    @POST("Tickets/BusAndLaunchService/getScheduleData")
    Call<ResponseBody> getScheduleData(@Body RequestScheduledata requestScheduledata);

    @POST("Tickets/BusAndLaunchService/getSeatView")
    Call<ResponseBody> getSeatView(@Body GetSeatViewRquestPojo getSeatViewRquestPojo);

//
    @POST("Tickets/BusAndLaunchService/getSeatStatus")
    Call<ResponseBody> getSeatStatus(@Body GetSeatViewRquestPojo GetSeatViewRquestPojo);

    @POST("Tickets/BusAndLaunchService/seatBlock")
    Call<ResBookAPI> seatBlock(@Body SeatBlockRequestPojo seatBlockRequestPojo);

    @POST("Tickets/BusAndLaunchService/cancelBookedTicket")
    Call<CancelBookedTicketResponse> cancelBookedTicket(@Body CancelBookedTicketReques cancelBookedTicketReques);

    @POST("Tickets/BusAndLaunchService/confirmTicket")
    Call<ResposeTicketConfirm> confirmTicket(@Body ReqConfirmTicket reqConfirmTicket);

    @POST("Tickets/BusAndLaunchService/ticketInformationForCancel")
    Call<ConfirmTicketCancelResponse> ticketInformationForCancel(@Body TicketInformationForCancelRequest ticketInformationForCancelRequest);


    @POST("Tickets/BusAndLaunchService/ticketInformationForCancel")
    Call<ResponseTicketInformationCancel> ticketInformationForCancel(@Body RequestTicketInformationForCancel RequestTicketInformationForCancel);


    @POST("Tickets/BusAndLaunchService/cancelTicket")
    Call<ResponseTicketInformationCancel> cancelTicket(@Body RequestTicketInformationForCancel RequestTicketInformationForCancel);


    @POST("Tickets/BusAndLaunchService/generateOtpForCancelTicket")
    Call<ResponseTicketInformationCancel> generateOtpForCancelTicket(@Body RequestRenerateOtpForCancelTicket requestRenerateOtpForCancelTicket);

    @POST("register")
    Call<ResponseBody> userRegister(@Body RegistrationRequest reg);



    @POST("authenticate")
    Call<TokenResponse> userToken(@Body User reg);

    @POST("user/checkotp")
    Call<TokenResponse> checkconsumerOTp(@Header("Authorization" )String auth, @Body String reg);





    @POST("refreshtoken")
    @FormUrlEncoded
    Call<TokenResponse> reFreshToken( @Header("Authorization") String auth, @Header("isRefreshToken")  boolean key);





    @GET("discover/movie")
    Call<MovieResponse> testt(@Query("api_key") String username);






}
