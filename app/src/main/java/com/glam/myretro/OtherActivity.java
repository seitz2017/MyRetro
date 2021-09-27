package com.glam.myretro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherActivity extends AppCompatActivity {

    String name, hobby;
    TextView get_name, get_hobby,get_item,get_item5;
    Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        get_name = (TextView) findViewById(R.id.get_name);
        get_hobby = (TextView) findViewById(R.id.get_link);
        get_item = (TextView) findViewById(R.id.get_item);

        get_item5 = (TextView) findViewById(R.id.get_item5);

        back_btn = (Button) findViewById(R.id.back_activity);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        hobby = intent.getStringExtra("hobby");
        Log.e("OtherActivity", "받아온 이름 : " + name + ", 취미 : " + hobby);

        // 레트로핏으로 서버에서 값을 받아온다
        getNameHobby(name, hobby);



        back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

    }

    private void getNameHobby(String name, String hobby)
    {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Naver> call = apiInterface.getNameHobby(name, hobby);
        call.enqueue(new Callback<Naver>()
        {
            @Override
            public void onResponse(@NonNull Call<Naver> call, @NonNull Response<Naver> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    String getted_name = response.body().getName();
                    String getted_hobby = response.body().getHobby();
                    Items getted_items = response.body().getItems()[1];

                    Items naveritem[] = new Items[10];
                    naveritem[0] = response.body().getItems()[0];
                    naveritem[5] = response.body().getItems()[5];

                    Log.e("getNameHobby()", "서버에서 이름 : " + getted_name + ", 서버에서 받아온 취미 : " + getted_hobby);
                    get_name.setText(getted_name);
                    get_hobby.setText(getted_hobby);
                    get_item.setText("타이틀 : "+getted_items.getTitle()+System.getProperty("line.separator")+System.getProperty("line.separator")+"링크 : "+getted_items.getLink());
                    get_item5.setText("타이틀5 : "+naveritem[5].getTitle()+System.getProperty("line.separator")+System.getProperty("line.separator")+"링크5 : "+naveritem[5].getLink());
                    //getted_items.getLink()
                    //getted_items.getTitle()

                    Log.e("첫번째로우 데이터", "getted_items.getTitle(): " + getted_items.getTitle() + ", getted_items.getLink() : " + getted_items.getLink());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Naver> call, @NonNull Throwable t)
            {
                Log.e("getNameHobby()", "에러 : " + t.getMessage());
            }
        });
    }
}