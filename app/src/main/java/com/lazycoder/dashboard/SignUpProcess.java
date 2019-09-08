package com.lazycoder.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignUpProcess extends AppCompatActivity {


    private static final String TAG = "SignUpProcess";


    EditText _addressText, _emailText, _mobileText, _passwordText, _reEnterPasswordText, _nameText;
    Button _signupButton;
    TextView _loginLink;
//    @BindView(R.id.input_name)
//    EditText _nameText;
//    @BindView(R.id.input_address) EditText _addressText;
//    @BindView(R.id.input_email) EditText _emailText;
//    @BindView(R.id.input_mobile) EditText _mobileText;
//    @BindView(R.id.input_password) EditText _passwordText;
//    @BindView(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
//    @BindView(R.id.btn_signup)
//    Button _signupButton;
//    @BindView(R.id.link_login)
//    TextView _loginLink;

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

        setContentView(R.layout.activity_sign_up_process);

//        ButterKnife.bind(this);

        _nameText = findViewById(R.id.input_name);
        _addressText = findViewById(R.id.input_address);
        _emailText = findViewById(R.id.input_email);
        _passwordText = findViewById(R.id.input_password);
        _reEnterPasswordText = findViewById(R.id.input_reEnterPassword);
        _mobileText = findViewById(R.id.input_mobile);
        _signupButton = findViewById(R.id.btn_signup);
        _loginLink = findViewById(R.id.link_login);


        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  signup();
                Intent intent = new Intent(SignUpProcess.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });

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
                //Toast.makeText(MainActivity.this, "" + textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Finish the registration screen and return to the login page
                Intent intent = new Intent(getApplicationContext(), RegistrationProcess.class);
                startActivity(intent);
                finish();

                overridePendingTransition(R.anim.push_left_in, R.anim.anim_marquee_out);
            }
        });
    }

    private void signup() {
        Log.d(TAG, "SignUp");

        //if non-valid/////////
//        if (!validate()){
//            onSignupFailed();
//            return;
//        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpProcess.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account............");
        progressDialog.show();
//
//        String name = _nameText.getText().toString();
//        String address = _addressText.getText().toString();
//        String email = _emailText.getText().toString();
//        String mobile = _mobileText.getText().toString();
//        String password = _passwordText.getText().toString();
//        String reEnterPassword = _reEnterPasswordText.getText().toString();

        //implement sign logic here
        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        //on complete call either onSignupSuccess or SignupFailed
                        //depending on success
                        onSignupSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000
        );


    }


    //method//////
    private void onSignupSuccess() {

        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }


    //method

    private void onSignupFailed() {

        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_SHORT).show();
        _signupButton.setEnabled(true);
    }


    //method for validation

//    private boolean validate() {
//
//        boolean valid = true;
//
//
//        String name = _nameText.getText().toString();
//        String address = _addressText.getText().toString();
//        String email = _emailText.getText().toString();
//        String mobile = _mobileText.getText().toString();
//        String password = _passwordText.getText().toString();
//        String reEnterPassword = _reEnterPasswordText.getText().toString();
//
//        if (name.isEmpty() || name.length() < 3) {
//            _nameText.setError("at least 3 characters");
//            valid = false;
//        } else {
//            _nameText.setError(null);
//        }
//
//        if (address.isEmpty()) {
//            _addressText.setError("Enter Valid Address");
//            valid = false;
//        } else {
//            _addressText.setError(null);
//        }
//
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            _emailText.setError("enter a valid email address");
//            valid = false;
//        } else {
//            _emailText.setError(null);
//        }
//
//        if (mobile.isEmpty() || mobile.length()!=10) {
//            _mobileText.setError("Enter Valid Mobile Number");
//            valid = false;
//        } else {
//            _mobileText.setError(null);
//        }
//
//        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            _passwordText.setError("between 4 and 10 alphanumeric characters");
//            valid = false;
//        } else {
//            _passwordText.setError(null);
//        }
//
//        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
//            _reEnterPasswordText.setError("Password Do not match");
//            valid = false;
//        } else {
//            _reEnterPasswordText.setError(null);
//        }
//
//        return valid;
//    }
}
