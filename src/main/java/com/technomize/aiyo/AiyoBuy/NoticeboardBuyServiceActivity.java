package com.technomize.aiyo.AiyoBuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.technomize.aiyo.R;

/**
 * Created by rishi on 9/1/2018.
 */

public class NoticeboardBuyServiceActivity extends AppCompatActivity implements View.OnClickListener {

    CarouselView carouselView,carouselView2;
    LinearLayout expandNoticeBoard;
    int[] sampleImages = {R.drawable.temp, R.drawable.temp, R.drawable.temp, R.drawable.temp};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyservicenoticeboardlactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        expandNoticeBoard=(LinearLayout)findViewById(R.id.buyserviceexpandLL);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        expandNoticeBoard.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_dashboard, menu);
        return true;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buyserviceexpandLL:
                Intent ev=new Intent(NoticeboardBuyServiceActivity.this,NoticeboardBuyServiceExpandActivity.class);
                startActivity(ev);
            break;
        }
    }
}
