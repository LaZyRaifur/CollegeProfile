package com.lazycoder.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    CardView mycard ;
    Intent i ;
    LinearLayout ll;

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
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ll = (LinearLayout) findViewById(R.id.ll);
        mycard = (CardView) findViewById(R.id.bankcardId);
//        i = new Intent(this,Ae.class);
//        mycard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(i);
//            }
//        });


        MarqueeView marqueeView = findViewById(R.id.marquee);

        List<String>list = new ArrayList<>();
        list.add("Shaikh Burhanuddin Post Graduate College");
        list.add("---College facilities---");
        list.add("1.Modern class room Environment.");
        list.add("2.Proficient internal faculties");
        list.add("3.guest teachers from renowned institutions.");
                list.add("4.Rich Central library");
                list.add("6.individual Seminar for every department.");
                list.add("-----Extra-curricular facilities-----");
        list.add("1.Cultural event");
        list.add("2.Study tour,annual Sports, Cultural Club, IT Club");
        list.add("provided to improve level of competence.");
        list.add("3.Spacious, non-political campus environment");
        list.add("4.Full campus under wireless network");



        marqueeView.startWithList(list);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(MainActivity.this, ""+textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
