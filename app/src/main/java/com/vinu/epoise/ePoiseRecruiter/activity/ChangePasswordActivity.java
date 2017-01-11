package com.vinu.epoise.ePoiseRecruiter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vinu.epoise.ePoiseRecruiter.R;

/**
 * Created by ePoise on 1/9/2017.
 */

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private CoordinatorLayout mCoordinatorLayout;
    private EditText oldPasswordText,newPasswordText,confirmedPasswordText;
    private Button changePasswordButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_change_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getSupportActionBar().setTitle(R.string.change_password);


        oldPasswordText=(EditText) findViewById(R.id.old_password);
        newPasswordText=(EditText) findViewById(R.id.new_password);
        confirmedPasswordText=(EditText) findViewById(R.id.confirm_password);
        changePasswordButton=(Button) findViewById(R.id.btn_change_password);

        changePasswordButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if(id==R.id.btn_change_password){
            changePassword();
        }
    }

    private void changePassword() {
        String oldPassword=oldPasswordText.getText().toString();
        String newPassword=newPasswordText.getText().toString();
        String confirmedPassword=confirmedPasswordText.getText().toString();

        if(!oldPassword.isEmpty() && !newPassword.isEmpty() && !confirmedPassword.isEmpty() && newPassword.equals(confirmedPassword)){

            changePasswordProcess(oldPassword,newPassword,confirmedPassword);

        }else{

            if(oldPassword.isEmpty()){
                oldPasswordText.setError("Enter Old Password");
            }else{
                oldPasswordText.setError(null);
            }
            if(newPassword.isEmpty()){
                newPasswordText.setError("Enter New Password");
            }else{
                newPasswordText.setError(null);
            }
            if(newPassword.length() < 4 && newPassword.length() > 10){
                newPasswordText.setError("Enter minimum 4 characters");
            }else{
                newPasswordText.setError(null);
            }

            if(confirmedPassword.isEmpty()){
                confirmedPasswordText.setError("Enter Confirm Password");

            }else {
                confirmedPasswordText.setError(null);
            }
            if(!confirmedPassword.equals(newPassword)){
                confirmedPasswordText.setError("Passwords are not matched");
            }else {
                confirmedPasswordText.setError(null);
            }
        }

    }
    private void changePasswordProcess(String oldPassword, String newPassword, String confirmedPassword) {

        if(oldPassword.equals("vinu123") && newPassword.equals(confirmedPassword)){

            Toast.makeText(getApplicationContext(), "Password has been changed successfully,Kindly re authenticate", Toast.LENGTH_LONG).show();

            Intent intent=new Intent(getApplication(),LoginActivity.class);
            startActivity(intent);

        }else{
            if(!oldPassword.equals("vinu123")){
                Snackbar.make(mCoordinatorLayout,"Wrong Old password", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        }).show();
            }
            if(oldPassword.equals(newPassword)){
                Snackbar.make(mCoordinatorLayout,"Enter other than old password", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        }).show();
            }
        }

    }

}
