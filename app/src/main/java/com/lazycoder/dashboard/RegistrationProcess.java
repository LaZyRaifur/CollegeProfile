package com.lazycoder.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RegistrationProcess extends AppCompatActivity {

    private static final String TAG = "RegistrationProcess";
    private static final int REQUEST_SIGNUP = 0;


//    @BindView(R.id.input_email) EditText _emailText;
//    @BindView(R.id.input_password)
//    EditText _passwordText;
//    @BindView(R.id.btn_login)
//    Button _loginButton;
//    @BindView(R.id.btn_signup)
//    Button _signupLink;

    //    EditText _emailText,_passwordText;
    Button _loginButton, _signupLink;

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
        setContentView(R.layout.activity_registration_process);
        //ButterKnife.bind(this);
//        _emailText = findViewById(R.id.input_email);
//        _passwordText = findViewById(R.id.input_password);
        _loginButton = findViewById(R.id.btn_login);
        _signupLink = findViewById(R.id.btn_signup);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //login();
                Intent intent = new Intent(RegistrationProcess.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start Sign up activity
                Intent intent = new Intent(getApplicationContext(), SignUpProcess.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();

                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

            }
        });
    }

    private void login() {

        Log.d(TAG, "Login");

//        if (!validate()){
//            onLoginFailed();
//            return;
//        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegistrationProcess.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating..........");
        progressDialog.show();

//        String name = _emailText.getText().toString();
//        String password = _passwordText.getText().toString();


        //implement own authentication
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }


    private void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    private void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

//
}
//    private boolean validate() {
//        boolean valid = true;
//
////        String email = _emailText.getText().toString();
////        String password = _passwordText.getText().toString();
//
////        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
////            _emailText.setError("enter a valid email address");
////            valid = false;
////        } else {
////            _emailText.setError(null);
////        }
////
////        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
////            _passwordText.setError("between 4 and 10 alphanumeric characters");
////            valid = false;
////        } else {
////            _passwordText.setError(null);
////        }
//
//        return valid;
//    }