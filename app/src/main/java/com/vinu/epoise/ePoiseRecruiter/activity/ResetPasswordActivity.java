package com.vinu.epoise.ePoiseRecruiter.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vinu.epoise.ePoiseRecruiter.R;

/**
 * Created by ePoise on 12/14/2016.
 */

public class ResetPasswordActivity extends AppCompatActivity {

    private TextView resetPasswordEmail;
    private Button resetPasswordButton,backToLogin;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

        resetPasswordEmail =(TextView) findViewById(R.id.user_reset_email);
        resetPasswordButton =(Button) findViewById(R.id.user_reset_password_button);
        backToLogin=(Button) findViewById(R.id.login_back_button);

        mCoordinatorLayout=(CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPasswordProcess();
            }
        });

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplication(),LoginActivity.class);
                startActivity(intent);

            }
        });

    }

    private void resetPasswordProcess() {

        String resetPassword_email= resetPasswordEmail.getText().toString();

        if(!resetPassword_email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(resetPassword_email).matches()) {

            sendResetPassword(resetPassword_email);

        }else{
            if(resetPassword_email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(resetPassword_email).matches()){
                resetPasswordEmail.setError("Enter valid email ID");
            }else {
                resetPasswordEmail.setError(null);
            }
        }

    }

    private void sendResetPassword(String resetPasswordEmail) {


        if(resetPasswordEmail.equals("support@epoise.com")){
            //reset password process begins here
            ProgressDialog progressDialog=new ProgressDialog(ResetPasswordActivity.this);
            progressDialog.setMessage("Authenticating....");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
            progressDialog.setProgress(50);
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Reset Password");
            builder.setMessage("Reset password has been sent successfully to your registered emailID")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);

                        }
                    }).show();
        }else{
            Snackbar.make(mCoordinatorLayout, "Invalid email or password !", Snackbar.LENGTH_LONG).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
