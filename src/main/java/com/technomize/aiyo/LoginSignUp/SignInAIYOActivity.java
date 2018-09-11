package com.technomize.aiyo.LoginSignUp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.technomize.aiyo.R;

/**
 * Created by rishi on 8/20/2018.
 */

public class SignInAIYOActivity extends AppCompatActivity implements View.OnClickListener{

    public TextView mforgotPswdtv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinaiyo_layout);

        mforgotPswdtv=(TextView)findViewById(R.id.forgotTv);



        mforgotPswdtv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forgotTv:
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
