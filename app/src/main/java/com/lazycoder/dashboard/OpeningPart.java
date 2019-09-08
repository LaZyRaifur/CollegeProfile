package com.lazycoder.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class OpeningPart extends AppCompatActivity {

    Button btnGuest, btnStudents;

    //    @Override
//    protected void attachBaseContext(Context newBase) {
////
////        //17.04.19
////        MultiDex.install(this);
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("Arkhip_font.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build());
        setContentView(R.layout.activity_opening_part);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnGuest = findViewById(R.id.guest);
        btnStudents = findViewById(R.id.students);


        ////////////////Guest season/////////////////
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent guest = new Intent(OpeningPart.this, MainActivity.class);
                startActivity(guest);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });


        ////////////students season///////////////////

        btnStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent student = new Intent(OpeningPart.this, RegistrationProcess.class);
                startActivity(student);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });


    }
}
