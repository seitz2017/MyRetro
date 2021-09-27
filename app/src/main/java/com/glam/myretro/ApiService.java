package com.glam.myretro;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

        //public static final String API_URL = "http://jsonplaceholder.typicode.com/";

        @GET ("/nice/smenu.php")
        Call<ResponseBody>getSmeal(
                @Query("startDate") String startDate,
                @Query("endDate") String endDate
        );
}
