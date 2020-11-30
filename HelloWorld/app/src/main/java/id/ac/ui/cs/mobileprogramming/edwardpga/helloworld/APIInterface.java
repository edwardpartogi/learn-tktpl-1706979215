package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("/")
    Call<ResponseBody> addWifiData(@Body WifiInfoModel wifiInfo);
}
