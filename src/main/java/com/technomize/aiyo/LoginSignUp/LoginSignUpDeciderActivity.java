package com.technomize.aiyo.LoginSignUp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.technomize.aiyo.Dashboard.UserDashboardActivity;
import com.technomize.aiyo.R;

/**
 * Created by rishi on 8/19/2018.
 */

public class LoginSignUpDeciderActivity extends AppCompatActivity implements View.OnClickListener{

    public TextView signIn,signUP,fbSignUp,forgotPaswd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup_decider);

        signIn=(TextView)findViewById(R.id.aiyo_signin_id);
        fbSignUp=(TextView)findViewById(R.id.facebook_signin_id);
        signUP=(TextView)findViewById(R.id.aiyoSignUp);
        forgotPaswd=(TextView)findViewById(R.id.forgot_pswd_tv);


        signIn.setOnClickListener(this);
        signUP.setOnClickListener(this);
        fbSignUp.setOnClickListener(this);
        forgotPaswd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aiyo_signin_id:
                Intent intent=new Intent(LoginSignUpDeciderActivity.this,SignInAIYOActivity.class);
                startActivity(intent);
                break;
            case R.id.aiyoSignUp:
                Intent intent2=new Intent(LoginSignUpDeciderActivity.this,SignUpAIYOActivity.class);
                startActivity(intent2);
                break;
            case R.id.facebook_signin_id:
                Intent temp=new Intent(LoginSignUpDeciderActivity.this, UserDashboardActivity.class);
                startActivity(temp);
                break;
            case R.id.forgot_pswd_tv:
                EditText emailetdialog;
                Button sendemaildialog;
                View view=getLayoutInflater().inflate(R.layout.forgot_password,null);
                emailetdialog=(EditText)view.findViewById(R.id.forgot_pswd_email);
                sendemaildialog=(Button)view.findViewById(R.id.forgot_pswd_send);
                final AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setView(view);

                sendemaildialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {

                                dialog.dismiss();
                            }
                        });
                    }
                });
                builder.show();
                break;
        }
    }
}
