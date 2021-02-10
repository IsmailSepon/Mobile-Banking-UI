package com.cloudwell.paywell.retrofit;


import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.finalReview.model.RequestAirPrebookingSearchParamsForServer;
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.RequestAirPriceSearch;
import com.cloudwell.paywell.app.APIResposeGenerateToken;
import com.cloudwell.paywell.notification.model.ResposeReScheduleNotificationAccept;
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.ReposeAirSearch;
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.RequestAirSearch;
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.search.model.ResGetAirports;
import com.cloudwell.paywell.services.activity.eticket.airticket.booking.model.BookingList;
import com.cloudwell.paywell.services.activity.eticket.airticket.bookingStatus.model.ResIssueTicket;
import com.cloudwell.paywell.services.activity.eticket.airticket.finalReview.model.ResAirPreBooking;
import com.cloudwell.paywell.services.activity.eticket.airticket.finalReview.model.ResBookingAPI;
import com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.model.ResposeAirPriceSearch;
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.airRules.ResposeAirRules;
import com.cloudwell.paywell.services.activity.eticket.airticket.flightSearch.model.ResCommistionMaping;
import com.cloudwell.paywell.services.activity.eticket.airticket.ticketCencel.model.ResSingleBooking;
import com.cloudwell.paywell.services.activity.eticket.airticket.ticketViewer.model.ResInvoideEmailAPI;
import com.cloudwell.paywell.services.activity.notification.model.RequestSDABalancceRetrun;
import com.cloudwell.paywell.services.activity.notification.model.deletetNotification.ReposeDeletedNotification;
import com.cloudwell.paywell.services.activity.notification.model.deletetNotification.RequestDeletedNotification;
import com.cloudwell.paywell.utils.ParameterUtility;
import com.google.gson.JsonObject;

import java.util.Map;

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


    @POST("PaywelltransactionHaltrip/uploadBookingFiles")
    Call<JsonObject> uploadBookingFiles(@Part("username") String username,
                                        @Part("booking_id") String password,
                                        @Part("params") String fileUploadReqSearchPara);


    @POST("PaywelltransactionHaltrip/send_invoice_to_user")
    @Multipart
    Call<ResInvoideEmailAPI> callSendInvoiceAPI(@Part("username") String username,
                                                @Part("booking_id") String bookingId,
                                                @Part("price_invoice_status") int priceInvoiceStatus,
                                                @Part("email_address") String email_address);


    @POST("PaywelltransactionHaltrip/getCommissionMapping")
    @Multipart
    Call<ResCommistionMaping> callGetCommissionMappingAPI(@Part("username") String username, @Part(ParameterUtility.KEY_REF_ID) String refId);


    @POST("PaywelltransactionHaltrip/getSingleBooking")
    @Multipart
    Call<ResSingleBooking> getSingleBooking(@Part("username") String username, @Part("booking_id") String bookingId, @Part(ParameterUtility.KEY_REF_ID) String refId);

    @POST("PaywelltransactionHaltrip/airTicketIssue")
    @Multipart
    Call<ResIssueTicket> callIssueTicketAPI(@Part("username") String username, @Part("password") String password, @Part("BookingID") String BookingID, @Part("IsAcceptedPriceChangeandIssueTicket") boolean ssAcceptedPriceChangeandIssueTicket, @Part(ParameterUtility.KEY_REF_ID) String refId);


    @POST("PaywelltransactionHaltrip/reIssueNotificationAccept")
    @Multipart
    Call<ResposeReScheduleNotificationAccept> reIssueNotificationAccept(@Part("username") String username, @Part("id") int id, @Part("accept_status") int accept_status);



    @POST("PaywellParibahanService/getBusSchedule?")
    @FormUrlEncoded
    Call<ResponseBody> getBusSchedule(@Field("username") String username, @Field("transport_id") String transport_id, @Field("skey") String skey, @Field("accessKey") String accessKey, @Field(ParameterUtility.KEY_REF_ID) String refId);


    @FormUrlEncoded
    @POST("PaywellParibahanService/seatCheck")
    Call<ResponseBody> seatCheck(@Field("username") String username,
                                 @Field("skey") String skey,
                                 @Field("accessKey") String accessKey,
                                 @Field("transport_id") String transport_id,
                                 @Field("route") String route,
                                 @Field("bus_id") String bus_id,
                                 @Field("departure_id") String departure_id,
                                 @Field("departure_date") String departure_date,
                                 @Field("seat_ids") String seat_ids,
                                 @Field(ParameterUtility.KEY_REF_ID) String refId);



    @POST("Authantication/PaywellAuth/refreshToken")
    Call<ResposeAppsAuth> refreshToken(@Header("Authorization") String AuthorizationKey, @Body RequestRefreshToken body);


}
