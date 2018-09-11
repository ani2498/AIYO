package com.technomize.aiyo.AiyoBuy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.technomize.aiyo.R;

/**
 * Created by rishi on 9/4/2018.
 */

public class AddAServiceBuyServiceActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    LinearLayout maddaserviceform,mrequestnewLL,mrequestdoneLL;
    SeekBar mdurationseekbar;
    TextView mdurationpasthourstv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addaservicebuyserviceactivity);

        maddaserviceform=(LinearLayout)findViewById(R.id.addaservicebuyserviceformLL);
        mrequestnewLL=(LinearLayout)findViewById(R.id.requestnewLL);
        mrequestdoneLL=(LinearLayout)findViewById(R.id.requestnewdoneLL);
        mdurationseekbar=(SeekBar)findViewById(R.id.durationseekbarbuysrevice);
        mdurationpasthourstv=(TextView)findViewById(R.id.pastdurationbuyservicetv);

        mdurationseekbar.setOnSeekBarChangeListener(this);

        maddaserviceform.setOnClickListener(this);
        mrequestdoneLL.setOnClickListener(this);
        mrequestnewLL.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.requestnewLL:
                mrequestnewLL.setVisibility(View.GONE);
                mrequestdoneLL.setVisibility(View.VISIBLE);
                maddaserviceform.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mdurationpasthourstv.setText(progress+" hours");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
