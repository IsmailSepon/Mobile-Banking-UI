package com.cloudwell.paywell.retrofit;

import com.cloudwell.paywell.data.network.AllUrl;
import com.cloudwell.paywell.data.network.RetrofitClient;
import com.cloudwell.paywell.prepspversion.network.NetClient;

import okhttp3.OkHttpClient;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/29/18.
 */
public class ApiUtils {
    private ApiUtils() {
    }

    private static final String BASE_URL = AllUrl.BASE_URL;
    private static final String BASE_URL_PHP7 = AllUrl.BASE_URL_PHP_7;
    private static final String CONSUMER = "http://consumerback.paywellonline.com:8080/consumerbackoffice/";


    public static final String KEY_SKEY = "fLdjl3VX_OPOx6zvadOGuCvq2Ay0civ6v-HUQeiLVRg";


        public static APIService getAPIService() {
            return RetrofitClient.INSTANCE.getClient(BASE_URL).create(APIService.class);
        }


    public static APIService getAPIServicePHP7() {
        return RetrofitClient.INSTANCE.getClientPHP(BASE_URL_PHP7).create(APIService.class);
    }


    public static APIService getAPIServiceV2() {
        return RetrofitClient.INSTANCE.getServiceV2(BASE_URL_PHP7).create(APIService.class);
    }

    public static APIService getAPITest(String url) {
        return RetrofitClient.INSTANCE.getServiceV2(url).create(APIService.class);
    }

    public static OkHttpClient getClient() {
        return RetrofitClient.INSTANCE.getClient();
    }




    public static APIService getConsumerAPI() {
        return RetrofitClient.INSTANCE.getConsumerClient(CONSUMER).create(APIService.class);
      //  return NetClient.INSTANCE.getClient(CONSUMER).create(APIService.class);
    }


}
