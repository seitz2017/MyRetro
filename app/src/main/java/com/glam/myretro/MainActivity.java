package com.glam.myretro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit_name, edit_hobby;
    Button search_btn, search_btn_smeal, search_btn_recipe, search_btn_fn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_hobby = (EditText) findViewById(R.id.edit_hobby);
        search_btn = (Button) findViewById(R.id.search_btn);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                String hobby = edit_hobby.getText().toString();
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("hobby", hobby);
                startActivity(intent);
            }
        });

        search_btn_smeal = (Button) findViewById(R.id.search_btn_smeal);
        search_btn_smeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String name = edit_name.getText().toString();
//                String hobby = edit_hobby.getText().toString();
                Intent intent = new Intent(MainActivity.this, SchoolActivity.class);
//                intent.putExtra("name", name);
//                intent.putExtra("hobby", hobby);
                startActivity(intent);
            }
        });

        search_btn_recipe = (Button) findViewById(R.id.search_btn_recipe);
        search_btn_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String name = edit_name.getText().toString();
//                String hobby = edit_hobby.getText().toString();
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
//                intent.putExtra("name", name);
//                intent.putExtra("hobby", hobby);
                startActivity(intent);
            }
        });
        search_btn_fn = (Button) findViewById(R.id.search_btn_fn);
        search_btn_fn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}