package com.example.ultracleanerfinish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



import java.util.Date;

import static android.content.Context.BATTERY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Battery#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Battery extends Fragment {
    private AdView mAdView;
    SharedPreferences prefs;

    ProgressBar progressBar;
    int i = 0;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Battery.
     */
    // TODO: Rename and change types and number of parameters
    public static Battery newInstance(String param1, String param2) {
        Battery fragment = new Battery();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Battery() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_battery, container, false);
        Button battery = (Button) view.findViewById(R.id.battery);
        ImageButton batterybtn = (ImageButton) getActivity().findViewById(R.id.batterybtn);
        ImageView warningrocket = (ImageView) getActivity().findViewById(R.id.warningbattery);
        ImageButton btn_battery_red = (ImageButton) getActivity().findViewById(R.id.btn_battery_red);
        ImageButton redbtnrocket = (ImageButton) getActivity().findViewById(R.id.redbtnrocket);
        ImageButton redbtn_fan = (ImageButton) getActivity().findViewById(R.id.redbtn_fan);
        ImageButton redbtn_trash = (ImageButton) getActivity().findViewById(R.id.redbtn_trash);
        ImageButton homebtn = (ImageButton) getActivity().findViewById(R.id.homebtn);
        ImageButton fanbtn = (ImageButton) getActivity().findViewById(R.id.fanbtn);
        ImageButton trashbtn = (ImageButton) getActivity().findViewById(R.id.trashbtn);
        TextView time_battery = (TextView) view.findViewById(R.id.time_battery);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        TextView txt_header_battery = (TextView) view.findViewById(R.id.txt_header_battery);


       /* int min1 = 80;
        int max1 = 95;
        int x = (int) ((Math.random() * ((max1 - min1) + 1)) + min1);
        txt_header_battery.setText(Integer.toString(x)+"%");

        int min2 = 20;
        int max2 = 40;
        int q = (int) ((Math.random() * ((max2 - min2) + 1)) + min2);*/



        BatteryManager bm = (BatteryManager)getActivity().getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        String test =String.valueOf(batLevel);
        txt_header_battery.setText(test + "%");

        int ty = batLevel * 6;
        int hourse  = ty / 60;
        int minutes = ty % 60;
        time_battery.setText("Charging time \n" + hourse + "h " + minutes + "m");

        save();


        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = (AdView) view.findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Date date2 = new Date(System.currentTimeMillis());
        Long wer = Long.valueOf(date2.getTime());
        if (wer - prefs.getLong("battery", 0) > 1000*60*2) {

        } else {
            battery.setText("Enlarged ");
            txt_header_battery.setText(test +"%");

            redbtn_fan.setEnabled(true);
            redbtn_trash.setEnabled(true);
            redbtnrocket.setEnabled(true);
            btn_battery_red.setEnabled(true);

            homebtn.setEnabled(true);
            batterybtn.setEnabled(true);
            fanbtn.setEnabled(true);
            trashbtn.setEnabled(true);
            int m = minutes + 15;
            time_battery.setText("Charging time \n" + hourse + "h" +  m +"m");
            ((ImageButton)getActivity().findViewById(R.id.btn_battery_red)).setVisibility(View.GONE);
            ((ImageButton)getActivity().findViewById(R.id.batterybtn)).setVisibility(View.VISIBLE);
            ((ImageView)getActivity().findViewById(R.id.warningbattery)).setVisibility(View.GONE);
        }


        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i <= 100) {
                            battery.setText("Increase\n" +i + "%");


                            redbtn_fan.setEnabled(false);
                            battery.setEnabled(false);
                            redbtn_trash.setEnabled(false);
                            redbtnrocket.setEnabled(false);
                            btn_battery_red.setEnabled(false);

                            homebtn.setEnabled(false);
                            batterybtn.setEnabled(false);
                            fanbtn.setEnabled(false);
                            trashbtn.setEnabled(false);


                            progressBar.setProgress(i);
                            i++;
                            handler.postDelayed(this, 100);
                        } else {
                            battery.setText("Enlarged ");
                            handler.removeCallbacks(this);
                            txt_header_battery.setText(test +"%");

                            redbtn_fan.setEnabled(true);
                            redbtn_trash.setEnabled(true);
                            redbtnrocket.setEnabled(true);
                            battery.setEnabled(true);
                            btn_battery_red.setEnabled(true);

                            homebtn.setEnabled(true);
                            batterybtn.setEnabled(true);
                            fanbtn.setEnabled(true);
                            trashbtn.setEnabled(true);
                            int m = minutes + 15;
                            time_battery.setText("Charging time \n" + hourse + "h" + m +"m");


                            Date date = new Date(System.currentTimeMillis());
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putLong("battery", date.getTime());
                            editor.apply();

                            ((ImageButton)getActivity().findViewById(R.id.btn_battery_red)).setVisibility(View.GONE);
                            ((ImageButton)getActivity().findViewById(R.id.batterybtn)).setVisibility(View.VISIBLE);
                            ((ImageView)getActivity().findViewById(R.id.warningbattery)).setVisibility(View.GONE);

                            Intent intent = new Intent(Battery.this.getActivity(), Afterwindow.class);
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

        prefs = this.getActivity().getSharedPreferences("battery",0);


    }
}

