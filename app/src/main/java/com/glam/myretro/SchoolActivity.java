package com.glam.myretro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolActivity extends AppCompatActivity {
    TextView tv_get_smeal_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        tv_get_smeal_result = findViewById(R.id.tv_get_smeal_result);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //baseUrl은 /로 끝나야 한다 - /로 안끝나면 예외 발생
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.78.242.95/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> call = apiService.getSmeal(
          "20190425",
                 "20190525"
        );

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(!response.isSuccessful()){
                    Log.d("실패","onResponse: onResponse 실패 - ");
                }else{
                    Log.d("성공","onResponse: onResponse 성공 - " + response.body().toString());

                    ResponseBody body = response.body();
                    try {
                        String result = body.string();
                        tv_get_smeal_result.setText(result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("완전실패","onFailure: onFailure - " + t.getMessage());
            }
        });
    }
}