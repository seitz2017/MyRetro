package com.glam.myretro;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
//    @GET("/nice/smenu.php")
//    Call<ResponseBody> getComment(@Query("postId") String postId);

    @GET("/fsafe/recipe.php")
    Call<ResponseBody> getRecipe(
            @Query("startDate") String startDate,
            @Query("endDate") String endDate
    );


}
