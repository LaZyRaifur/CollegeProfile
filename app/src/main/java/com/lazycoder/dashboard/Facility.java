package com.lazycoder.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Facility extends AppCompatActivity {

    CardView sports, library, it, labrotary;

    @Override
    protected void attachBaseContext(Context newBase) {
//
//        //17.04.19
//        MultiDex.install(this);
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Arkhip_font.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_facility);

        sports = findViewById(R.id.sports);
        library = findViewById(R.id.library);
        it = findViewById(R.id.itClub);
        labrotary = findViewById(R.id.laboratory);


        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sports = new Intent(Facility.this, GalleryActivity.class);
                startActivity(sports);

            }
        });


        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sports = new Intent(Facility.this, GalleryActivity.class);
                startActivity(sports);

            }
        });


        labrotary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sports = new Intent(Facility.this, GalleryActivity.class);
                startActivity(sports);

            }
        });


        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sports = new Intent(Facility.this, GalleryActivity.class);
                startActivity(sports);

            }
        });
        ////marquee////////////
        MarqueeView marqueeView = findViewById(R.id.marquee);

        List<String> list = new ArrayList<>();
        list.add("Shaikh Burhanuddin Post Graduate College");
        list.add("---College facilities---");
        list.add("Modern class room Environment.");
        list.add("Proficient internal faculties");
        list.add("guest teachers from renowned institutions.");
        list.add("Rich Central library");
        list.add("individual Seminar for every department.");
        list.add("-----Extra-curricular facilities-----");
        list.add("Cultural event");
        list.add("Study tour,annual Sports, Cultural Club, IT Club");
        list.add("provided to improve level of competence.");
        list.add("Spacious, non-political campus environment");
        list.add("Full campus under wireless network");


        marqueeView.startWithList(list);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(Facility.this, "" + textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
