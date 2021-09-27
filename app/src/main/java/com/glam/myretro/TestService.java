package com.glam.myretro;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestService {
    @GET("/fsafe/fingredient.php")
    Call<ResponseBody> getnutrition(
            @Query("pSize") String pSize,
            @Query("pIndex") String pIndex
    );
}
