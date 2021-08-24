package com.example.ultracleanerfinish;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.w3c.dom.Text;

import java.util.Date;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FHome extends Fragment {
    private AdView mAdView;
    int i = 0;
    SharedPreferences prefs;
    ProgressBar progressBar;
    FragmentTransaction ft;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FHome newInstance(String param1, String param2) {
        FHome fragment = new FHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f_home, container, false);
        Button button = (Button) view.findViewById(R.id.boost);
        ImageButton redbtnrocket = (ImageButton) getActivity().findViewById(R.id.redbtnrocket);
        ImageButton btn_battery_red = (ImageButton) getActivity().findViewById(R.id.btn_battery_red);
        ImageButton redbtn_fan = (ImageButton) getActivity().findViewById(R.id.redbtn_fan);
        ImageButton redbtn_trash = (ImageButton) getActivity().findViewById(R.id.redbtn_trash);
        ImageButton homebtn = (ImageButton) getActivity().findViewById(R.id.homebtn);
        ImageButton batterybtn = (ImageButton) getActivity().findViewById(R.id.batterybtn);
        ImageButton fanbtn = (ImageButton) getActivity().findViewById(R.id.fanbtn);
        ImageButton trashbtn = (ImageButton) getActivity().findViewById(R.id.trashbtn);
        TextView txt_header = (TextView) view.findViewById(R.id.txt_header);
        TextView txt_header2 = (TextView) view.findViewById(R.id.txt_header2);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        TextView info_txt = (TextView) view.findViewById(R.id.info_txt);
        TextView info_txt2 = (TextView) view.findViewById(R.id.info_txt2);


        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = (AdView) view.findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        save();


        Date date2 = new Date(System.currentTimeMillis());
        Long wer = Long.valueOf(date2.getTime());




        ActivityManager actManager = (ActivityManager)getActivity().getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        double totalMemory = memInfo.totalMem / (1000 * 1000 * 1000);
        String test = String.valueOf(totalMemory);



        double min3 = 1;
        double max3  = totalMemory;
        double n = Math.random() * (totalMemory - min3) + min3;   //рандомное число
        double u = Math.random() * (max3 - min3) + min3;   //рандомное число
        double jp = n * 100/ totalMemory;
        double jp2 = u * 100/ max3;
        double procent = Math.round(jp * 100)/100;  //процент
        int value = (int) procent;
        int value2 = (int) procent - 25;
        txt_header.setText(value + "%");
        double result = Math.round(n * 100.00)/100.00;
        double after = Math.round((result - 1)* 100.00) / 100.00;
        info_txt.setText(result + "Gb /" + test + "Gb");



        if (wer - prefs.getLong("home", 0) > 1000*60*2) {

        } else {
            info_txt.setVisibility(View.INVISIBLE);
            info_txt2.setVisibility(View.VISIBLE);
            txt_header.setVisibility(View.INVISIBLE);
            txt_header2.setVisibility(View.VISIBLE);
            info_txt2.setText(after + "Gb /" + test + "Gb");
            txt_header2.setText(value2 +"%");
            button.setText("optimized");
            button.setTextSize(20);

            redbtnrocket.setEnabled(true);
            btn_battery_red.setEnabled(true);
            redbtn_fan.setEnabled(true);
            redbtn_trash.setEnabled(true);

            homebtn.setEnabled(true);
            batterybtn.setEnabled(true);
            fanbtn.setEnabled(true);
            trashbtn.setEnabled(true);


            ((ImageButton) getActivity().findViewById(R.id.redbtnrocket)).setVisibility(View.GONE);
            ((ImageButton) getActivity().findViewById(R.id.homebtn)).setVisibility(View.VISIBLE);
            ((ImageView) getActivity().findViewById(R.id.warningrocket)).setVisibility(View.GONE);


        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i <= 100) {

                            button.setText("Scanning\n" +i + "%");
                            button.setTextSize(20);
                            btn_battery_red.setEnabled(false);
                            redbtn_fan.setEnabled(false);
                            button.setEnabled(false);
                            redbtn_trash.setEnabled(false);
                            redbtnrocket.setEnabled(false);

                            homebtn.setEnabled(false);
                            batterybtn.setEnabled(false);
                            fanbtn.setEnabled(false);
                            trashbtn.setEnabled(false);

                            progressBar.setProgress(i);
                            i++;
                            handler.postDelayed(this, 100);
                        } else {

                            info_txt.setVisibility(View.INVISIBLE);
                            info_txt2.setVisibility(View.VISIBLE);
                            txt_header.setVisibility(View.INVISIBLE);
                            txt_header2.setVisibility(View.VISIBLE);
                            info_txt2.setText(after + "Gb /" + test + "Gb");
                            txt_header2.setText(value2 +"%");


                            button.setText("optimized");
                            button.setTextSize(20);
                            handler.removeCallbacks(this);
                            button.removeCallbacks(this);
                            redbtnrocket.setEnabled(true);
                            btn_battery_red.setEnabled(true);
                            redbtn_fan.setEnabled(true);
                            redbtn_trash.setEnabled(true);

                            homebtn.setEnabled(true);
                            batterybtn.setEnabled(true);
                            fanbtn.setEnabled(true);
                            trashbtn.setEnabled(true);

                            Date date = new Date(System.currentTimeMillis());
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putLong("home", date.getTime());
                            editor.apply();


                            ((ImageButton) getActivity().findViewById(R.id.redbtnrocket)).setVisibility(View.GONE);
                            ((ImageButton) getActivity().findViewById(R.id.homebtn)).setVisibility(View.VISIBLE);
                            ((ImageView) getActivity().findViewById(R.id.warningrocket)).setVisibility(View.GONE);


                            Intent intent = new Intent(FHome.this.getActivity(), Afterwindow.class);
                            if (redbtnrocket.getVisibility() == View.GONE){
                                intent.putExtra("homeinvisible", "invisible");
                            }else{
                                intent.putExtra("homeinvisible", "visible");
                            }
                            if (btn_battery_red.getVisibility() == View.GONE){
                                intent.putExtra("batteryinvisible", "invisible");
                            }else{
                                intent.putExtra("batteryinvisible", "visible");
                            }
                            if (redbtn_fan.getVisibility() == View.GONE){
                                intent.putExtra("cpuinvisible", "invisible");
                            }else{
                                intent.putExtra("cpuinvisible", "visible");
                            }
                            if (redbtn_trash.getVisibility() == View.GONE){
                                intent.putExtra("cleaninvisible", "invisible");
                            }else{
                                intent.putExtra("cleaninvisible", "visible");
                            }
                            startActivity(intent);
                        }
                    }
                }, 100);
            }
        });
        return view;
    }
    private void save(){

        prefs = this.getActivity().getSharedPreferences("home",0);


    }
}