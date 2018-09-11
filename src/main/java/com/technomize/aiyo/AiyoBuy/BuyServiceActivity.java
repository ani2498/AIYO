package com.technomize.aiyo.AiyoBuy;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.technomize.aiyo.R;

/**
 * Created by rishi on 8/29/2018.
 */

public class BuyServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Shimmer mshimmer;
    ShimmerTextView mnotificationTv,maddaserviceTv;
    ImageView mbackarrowIv;
    LinearLayout mnoticeboardLL,maddaserviceLL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyserviceactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mbackarrowIv=(ImageView)toolbar.findViewById(R.id.backarrowtoolbartv);
        mnoticeboardLL=(LinearLayout)findViewById(R.id.buyservicesnoticeboardLL);
        maddaserviceLL=(LinearLayout)findViewById(R.id.addaservicebuyserviceLL);

        mnotificationTv=(ShimmerTextView)findViewById(R.id.shimmernotification_tv);
        maddaserviceTv=(ShimmerTextView)findViewById(R.id.addaservice_tv);

        mbackarrowIv.setOnClickListener(this);
        mnoticeboardLL.setOnClickListener(this);
        maddaserviceLL.setOnClickListener(this);
        startAnimation();
    }

    public void startAnimation() {
        if (mshimmer != null && mshimmer.isAnimating()) {
            mshimmer.cancel();
        } else {
            mshimmer = new Shimmer();
            mshimmer.start(mnotificationTv);
            mshimmer.start(maddaserviceTv);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_dashboard, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backarrowtoolbartv:
                BuyServiceActivity.this.finish();
                break;
            case R.id.buyservicesnoticeboardLL:
                Intent nb=new Intent(BuyServiceActivity.this,NoticeboardBuyServiceActivity.class);
                startActivity(nb);
                break;
            case R.id.addaservicebuyserviceLL:
                Intent asa=new Intent(BuyServiceActivity.this,AddAServiceBuyServiceActivity.class);
                startActivity(asa);
                break;
        }
    }
}
