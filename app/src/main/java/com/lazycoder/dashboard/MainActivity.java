package com.lazycoder.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    CardView facility, gallery, administration, academic, More;
    Intent i;
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
        ll = findViewById(R.id.ll);

        facility = findViewById(R.id.FacilityId);
        academic = findViewById(R.id.academicId);
        administration = findViewById(R.id.administrationId);
        gallery = findViewById(R.id.galleryId);
        More = findViewById(R.id.moreId);


//        mycard = (CardView) findViewById(R.id.bankcardId);
////        i = new Intent(this,Ae.class);
////        mycard.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                startActivity(i);
////            }
////        });


        //////////////Facility//////////////////
        facility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Facility.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                return;
            }
        });


        gallery = findViewById(R.id.galleryId);
        i = new Intent(this, GalleryActivity.class);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);

            }
        });

        ////academic activities////////////
        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, academic);

                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.academic, popup.getMenu());

                ///onMenuItemClickListener//////////////
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.admission:
                                break;
                            case R.id.result:
                                break;
                        }

                        return true;
                    }
                });
                popup.show();
            }
        });

        More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, More);

                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.more, popup.getMenu());


                //registering more with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.contactUs:
                                showContactDialog(MainActivity.this, "Address: 62, Nazimuddin Road, Dhaka-1100\n" +
                                        "\n" +
                                        "Telephone: +88 02-57300204\n" +
                                        "\n" +
                                        "Mobile: +88 01771242644, 01819023177\n" +
                                        "\n" +
                                        "Email: info@sbpgc.edu.bd\n" +
                                        "Web: www.sbpgc.edu.bd");
                                break;
                            case R.id.journals:
//                               LayoutInflater inflater = getLayoutInflater();
//                               View layout = inflater.inflate(R.layout.journals, (ViewGroup) findViewById(R.id.custom_toast_layout));
//                               TextView tv = (TextView) layout.findViewById(R.id.txtvw);
//                               tv.setText("can not find this page!!!!");
//                               Toast toast = new Toast(getApplicationContext());
//                               toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100);
//                               toast.setDuration(Toast.LENGTH_LONG);
//                               toast.setView(layout);
//                               toast.show();
                                showDialog(MainActivity.this, "Can not find any Journals from the website!!!");
                                break;

                            case R.id.notifications:
                                Intent i = new Intent(MainActivity.this, Notifications.class);
                                startActivity(i);

                                break;

                        }


                        return true;
                    }
                });

                popup.show();//showing more menu
            }
        });//closing the setOnClickListener method


        ///administration popup menu /////////////////////////////////////////
        administration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, administration);

                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.administration, popup.getMenu());


                //registering more with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.chairman:
                                showChairmanDialog(MainActivity.this, "Professor Dr. Md. Harunor Rashid Khan\n" +
                                        "Department of Soil, Water & Environment , DU");
                                break;
                            case R.id.principal:
                                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                                startActivity(intent);

//
                                break;
                            case R.id.controller:
                                Intent intent1 = new Intent(MainActivity.this, GalleryActivity.class);
                                startActivity(intent1);

                                break;
                            case R.id.administration_officer:
                                Intent intent2 = new Intent(MainActivity.this, GalleryActivity.class);
                                startActivity(intent2);

                                break;
                            case R.id.departmentContactNumber:
                                Intent intent3 = new Intent(MainActivity.this, GalleryActivity.class);
                                startActivity(intent3);

                                break;

                        }


                        return true;
                    }
                });

                popup.show();//showing more menu
            }
        });

        //closing the setOnClickListener method


        MarqueeView marqueeView = findViewById(R.id.marquee);

        List<String> list = new ArrayList<>();
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
                Toast.makeText(MainActivity.this, "" + textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showChairmanDialog(Activity activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.chairman);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton1 = dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    //alert dialog
    private void showContactDialog(Activity activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.contactus);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton1 = dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    ////////////alert dialog////////////////
    private void showDialog(Activity activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.journals);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton1 = dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogButton2 = dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


}