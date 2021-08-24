package com.example.ultracleanerfinish;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Afterwindow extends AppCompatActivity implements View.OnClickListener{
    private AdView mAdView;
    Button boost,optimize,battery,clean;
    ActionBar actionBar;
    ImageView done_logo;
    TextView check, done;
    int count = 0;
    LinearLayout btnboost, btnbattery, btnclean, btnoptiamze;
    private static final int CHOOSE_THIEF = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterwindow);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        done_logo = (ImageView) findViewById(R.id.done_logo);
        check = (TextView) findViewById(R.id.check);
        done = (TextView) findViewById(R.id.done);
        btnboost = (LinearLayout) findViewById(R.id.btnboost);
        btnbattery = (LinearLayout) findViewById(R.id.btnbattery);
        btnclean = (LinearLayout) findViewById(R.id.btnclean);
        btnoptiamze = (LinearLayout) findViewById(R.id.btnoptiamze);
        boost = (Button) findViewById(R.id.boost);
        optimize = (Button) findViewById(R.id.optimize);
        battery = (Button) findViewById(R.id.battery);
        clean = (Button) findViewById(R.id.clean);

        boost.setOnClickListener(this);
        optimize.setOnClickListener(this);
        battery.setOnClickListener(this);
        clean.setOnClickListener(this);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


         Intent intent = getIntent();
         String home = intent.getStringExtra("homeinvisible");
        Log.d("qwe", String.valueOf(home.equals("visible")));
        Log.d("qwe", home);
         String battery = intent.getStringExtra("batteryinvisible");
         String cpu = intent.getStringExtra("cpuinvisible");
         String clean = intent.getStringExtra("cleaninvisible");
         if (home.equals("invisible")){
                btnboost.setVisibility(View.GONE);
                count++;
            }
        if (battery.equals("invisible")){
            btnbattery.setVisibility(View.GONE);
            count++;
        }
        if (cpu.equals("invisible")){
            btnoptiamze.setVisibility(View.GONE);
            count++;
        }
        if (clean.equals("invisible")){
            btnclean.setVisibility(View.GONE);
            count++;
        }
        if (count == 4) {
            done.setText("Everything is done");
            done_logo.setVisibility(View.VISIBLE);

        }else
        check.setText(count + " / 4" );
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Afterwindow.this, Home.class);
        switch (v.getId()) {
            case R.id.boost:
                intent.putExtra("fragment_number", "1");
                intent.putExtra("сhek", "1");
                startActivity(intent);
                break;
            case R.id.battery:

                intent.putExtra("fragment_number", "2");
                intent.putExtra("сhek", "2");
                startActivity(intent);
                break;
            case R.id.clean:
                intent.putExtra("fragment_number", "4");
                intent.putExtra("сhek", "4");
                startActivity(intent);

                break;
            case R.id.optimize:
                intent.putExtra("fragment_number", "3");
                intent.putExtra("сhek", "3");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}