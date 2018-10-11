package com.ingrammicro.inrans00.imonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

public class HomeActivity extends AppCompatActivity {
   Button selectCountry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //ScrollView sv = (ScrollView)findViewById(R.id.scroll);
        //sv.setEnabled(false);
       // String name = getIntent().getStringExtra("CountryName");

        Button selectCountry = (Button) findViewById(R.id.button_countrydata);
        selectCountry.setCompoundDrawablesWithIntrinsicBounds(getIntent().getIntExtra("countryFlag", 0), 0, 0, 0);


        selectCountry.setText(""  + getIntent().getStringExtra("countryName"));
        selectCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,
                        CountryActivity.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
            }



    }

