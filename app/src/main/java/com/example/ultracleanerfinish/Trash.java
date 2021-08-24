package com.example.ultracleanerfinish;

import android.content.Intent;
import android.content.SharedPreferences;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Trash#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Trash extends Fragment {
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

    public Trash() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Trash.
     */
    // TODO: Rename and change types and number of parameters
    public static Trash newInstance(String param1, String param2) {
        Trash fragment = new Trash();
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
        View view = inflater.inflate(R.layout.fragment_trash, container, false);
        Button trash = (Button) view.findViewById(R.id.trash);
        ImageButton redbtnrocket = (ImageButton) getActivity().findViewById(R.id.redbtnrocket);
        ImageButton btn_battery_red = (ImageButton) getActivity().findViewById(R.id.btn_battery_red);
        ImageButton redbtn_fan = (ImageButton) getActivity().findViewById(R.id.redbtn_fan);
        ImageButton redbtn_trash = (ImageButton) getActivity().findViewById(R.id.redbtn_trash);
        ImageButton trashbtn = (ImageButton) getActivity().findViewById(R.id.trashbtn);
        ImageView warningtrash = (ImageView) getActivity().findViewById(R.id.warningtrash);
        ImageButton homebtn = (ImageButton) getActivity().findViewById(R.id.homebtn);
        ImageButton batterybtn = (ImageButton) getActivity().findViewById(R.id.batterybtn);
        ImageButton fanbtn = (ImageButton) getActivity().findViewById(R.id.fanbtn);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        TextView txt_header_trash = (TextView) view.findViewById(R.id.txt_header_trash);
        TextView txt_underheader = (TextView) view.findViewById(R.id.txt_underheader);


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


        int min = 50;
        int max = 200;
        int x = (int) (Math.random() * (max - min) + min);
        int procent = x * 100/ max;
        txt_header_trash.setText(procent + "%");
        txt_underheader.setText(Integer.toString(x) + "Mb found");

        if (wer - prefs.getLong("trash", 0) > 1000*60*2) {

        } else {
            trash.setText("Enlarged ");
            trash.setTextSize(23);
            redbtn_fan.setEnabled(true);
            redbtn_trash.setEnabled(true);
            redbtnrocket.setEnabled(true);
            btn_battery_red.setEnabled(true);
            txt_underheader.setText("0 Mb found");
            txt_header_trash.setText("0%");
            homebtn.setEnabled(true);
            batterybtn.setEnabled(true);
            fanbtn.setEnabled(true);
            trashbtn.setEnabled(true);

            ((ImageButton)getActivity().findViewById(R.id.redbtn_trash)).setVisibility(View.GONE);
            ((ImageButton)getActivity().findViewById(R.id.trashbtn)).setVisibility(View.VISIBLE);
            ((ImageView)getActivity().findViewById(R.id.warningtrash)).setVisibility(View.GONE);
        }

            trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i <= 100) {
                            trash.setText("Clearing\n"+ i + "%");
                            progressBar.setProgress(i);
                            i++;

                            redbtn_fan.setEnabled(false);
                            trash.setEnabled(false);
                            redbtn_trash.setEnabled(false);
                            redbtnrocket.setEnabled(false);
                            btn_battery_red.setEnabled(false);


                            homebtn.setEnabled(false);
                            batterybtn.setEnabled(false);
                            fanbtn.setEnabled(false);
                            trashbtn.setEnabled(false);

                            handler.postDelayed(this, 100);
                        } else {
                            trash.setText("Enlarged ");
                            trash.setTextSize(23);
                            handler.removeCallbacks(this);
                            redbtn_fan.setEnabled(true);
                            trash.setEnabled(true);
                            redbtn_trash.setEnabled(true);
                            redbtnrocket.setEnabled(true);
                            btn_battery_red.setEnabled(true);
                            txt_underheader.setText("0 Mb found");
                            txt_header_trash.setText("0%");
                            homebtn.setEnabled(true);
                            batterybtn.setEnabled(true);
                            fanbtn.setEnabled(true);
                            trashbtn.setEnabled(true);



                            Date date = new Date(System.currentTimeMillis());
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putLong("trash", date.getTime());
                            editor.apply();

                            ((ImageButton)getActivity().findViewById(R.id.redbtn_trash)).setVisibility(View.GONE);
                            ((ImageButton)getActivity().findViewById(R.id.trashbtn)).setVisibility(View.VISIBLE);
                            ((ImageView)getActivity().findViewById(R.id.warningtrash)).setVisibility(View.GONE);

                            Intent intent = new Intent(Trash.this.getActivity(), Afterwindow.class);
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

        prefs = this.getActivity().getSharedPreferences("trash",0);


    }
}