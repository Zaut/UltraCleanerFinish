package com.example.ultracleanerfinish;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
        SharedPreferences prefs;
    private CheckBox check;
    private TextView textView;
    private TextView loading;
    private TextView txt;
    private TextView first;
    private ProgressBar progressBar;
    private Button button;
    private AdView mAdView;
        private static final int CHOOSE_THIEF = 20;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checked();




        final CheckBox checkBox = (CheckBox)findViewById(R.id.check);

        final Button b = (Button)findViewById(R.id.btn_start);
        final TextView tt = (TextView)findViewById(R.id.tt);
        final ProgressBar bar = (ProgressBar)findViewById(R.id.bar);
        first = (TextView)findViewById(R.id.first);
            textView = findViewById(R.id.first);
            button = findViewById(R.id.btn_start);
            check = findViewById(R.id.check);
            txt = findViewById(R.id.txt);
            progressBar = findViewById(R.id.bar);

            loading = findViewById(R.id.textView4);
            progressBar.setMax(100);
            progressBar.setScaleY(2f);


            if(prefs.getBoolean("cheked", false)){
                Log.d("123", "321");
                check.setVisibility(View.GONE);
                first.setVisibility(View.GONE);
                b.setEnabled(true);
                tt.setVisibility(View.GONE);
            }else {
                Log.d("qwe", "ewq");
                check.setVisibility(View.VISIBLE);
                first.setVisibility(View.VISIBLE);
            };

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    b.setEnabled(true);
                    tt.setVisibility(View.GONE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("cheked", true);
                    editor.apply();


                } else {
                    bar.setVisibility(View.GONE);
                    loading.setVisibility(View.GONE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("cheked", false);
                    editor.apply();

                }
            }
        });

    }


    private void checked(){

       prefs = getSharedPreferences("cheked", MODE_PRIVATE);


    }

    private void progressAnimation() {
        ProgressAnimation animation = new ProgressAnimation(this,progressBar, 0f,100f);
        animation.setDuration(3400);
        progressBar.setAnimation(animation);

    }



        public void onClick(View view) {
        textView.setVisibility(View.GONE);
        check.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        loading.setVisibility(View.VISIBLE);
        loading.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        progressAnimation();
        TextView textview = findViewById(R.id.txt);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(3400);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                textview.setText(valueAnimator.getAnimatedValue().toString() + "%");
            }
        });
        valueAnimator.start();




    }

}