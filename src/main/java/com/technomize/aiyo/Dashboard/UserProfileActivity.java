package com.technomize.aiyo.Dashboard;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.technomize.aiyo.R;

import java.util.Calendar;

/**
 * Created by rishi on 9/4/2018.
 */

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mdatepickertv;
    DatePicker datePicker;
    Calendar calendar;
    EditText musername;
    int year, month, day;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofileactivity);

        mdatepickertv=(TextView)findViewById(R.id.selectdateTv);
        musername=(EditText)findViewById(R.id.usernameEt);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        mdatepickertv.setOnClickListener(this);
        musername.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.selectdateTv:
                setDate();
                break;
            case R.id.usernameEt:
                break;
        }
    }
    @SuppressWarnings("deprecation")
    public void setDate() {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {

                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };
    private void showDate(int year, int month, int day) {
        mdatepickertv.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}
