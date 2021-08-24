    package com.example.ultracleanerfinish;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CPU#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CPU extends Fragment {
    private AdView mAdView;
    SharedPreferences prefs;

    Animation animation, animation2, animation3, animation1, animation4;

    int i = 0;
    ProgressBar progressBar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CPU() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CPU.
     */
    // TODO: Rename and change types and number of parameters
    public static CPU newInstance(String param1, String param2) {
        CPU fragment = new CPU();
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
        View view = inflater.inflate(R.layout.fragment_c_p_u, container, false);
        Button cpu = (Button) view.findViewById(R.id.cpu);
        List<Drawable> list = GetApps.getApps(requireActivity());
        Collections.shuffle(list);

        ImageView img1 = (ImageView) view.findViewById(R.id.img1);
        ImageView img2 = (ImageView) view.findViewById(R.id.img2);
        ImageView img3 = (ImageView) view.findViewById(R.id.img3);
        ImageView img4 = (ImageView) view.findViewById(R.id.img4);


        TextView txt1 = (TextView) view.findViewById(R.id.txt1);
        TextView txt2 = (TextView) view.findViewById(R.id.txt2);
        TextView txt3 = (TextView) view.findViewById(R.id.txt3);
        TextView txt4 = (TextView) view.findViewById(R.id.txt4);
        TextView textView = (TextView)  view.findViewById(R.id.temperature);


        ImageButton redbtn_fan = (ImageButton) getActivity().findViewById(R.id.redbtn_fan);
        ImageButton redbtnrocket = (ImageButton) getActivity().findViewById(R.id.redbtnrocket);
        ImageButton btn_battery_red = (ImageButton) getActivity().findViewById(R.id.btn_battery_red);
        ImageButton redbtn_trash = (ImageButton) getActivity().findViewById(R.id.redbtn_trash);
        ImageButton homebtn = (ImageButton)  getActivity().findViewById(R.id.homebtn);
        ImageButton batterybtn = (ImageButton)  getActivity().findViewById(R.id.batterybtn);
        ImageButton fanbtn = (ImageButton)  getActivity().findViewById(R.id.fanbtn);
        ImageButton trashbtn = (ImageButton)  getActivity().findViewById(R.id.trashbtn);

       LinearLayout qwer = (LinearLayout) view.findViewById(R.id.progrgam);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);



        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale);
        animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.scale2);
        animation3 = AnimationUtils.loadAnimation(getActivity(), R.anim.scale3);
        animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.scale1);
        animation4 = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);
        save();


        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = (AdView) view.findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



       img1.setImageDrawable(list.get(1));
       img2.setImageDrawable(list.get(2));
       img3.setImageDrawable(list.get(3));
       img4.setImageDrawable(list.get(4));

        Date date2 = new Date(System.currentTimeMillis());
        Long wer = Long.valueOf(date2.getTime());




        textView.setText("31°C".toUpperCase());
        TextPaint paint = textView.getPaint();
        float width = paint.measureText("31°C");
        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#F31935"),
                        Color.parseColor("#FF8F3E"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);





        int min1 = 50;
        int max1 = 60;
        int z = (int) ((Math.random() * ((max1 - min1) + 1)) + min1);
        textView.setText(Integer.toString(z)+"°C");



        Double min = 1.0;
        Double max = 8.0;
        double x = (Math.random() * ((max - min) + 1)) + min;
        double q = (Math.random() * ((max - min) + 1)) + min;
        double w = (Math.random() * ((max - min) + 1)) + min;
        double e = (Math.random() * ((max - min) + 1)) + min;
        double xrounded = Math.round(x * 10.0) / 10.0;
        double xrounde = Math.round(q * 10.0) / 10.0;
        double xround = Math.round(w * 10.0) / 10.0;
        double xroun = Math.round(e * 10.0) / 10.0;
        txt1.setText(Double.toString(xrounded) + "MB");
        txt2.setText(Double.toString(xrounde)+ "MB");
        txt3.setText(Double.toString(xround)+ "MB");
        txt4.setText(Double.toString(xroun)+ "MB");

        int min2 = 35;
        int max2 = 45;
        int p = (int) ((Math.random() * ((max2 - min2) + 1)) + min2);
        textView.setText(Integer.toString(p)+"°C");


                if (wer - prefs.getLong("time", 0) > 1000*60*2) {

                } else {
                    cpu.setText("optimized");



                    redbtn_fan.setEnabled(true);
                    redbtn_trash.setEnabled(true);
                    redbtnrocket.setEnabled(true);
                    btn_battery_red.setEnabled(true);

                    homebtn.setEnabled(true);
                    batterybtn.setEnabled(true);
                    fanbtn.setEnabled(true);
                    trashbtn.setEnabled(true);
                    qwer.setVisibility(View.GONE);
                    textView.setText(Integer.toString(p)+"°C");

                    ((ImageButton)getActivity().findViewById(R.id.redbtn_fan)).setVisibility(View.GONE);
                    ((ImageButton)getActivity().findViewById(R.id.fanbtn)).setVisibility(View.VISIBLE);
                    ((ImageView)getActivity().findViewById(R.id.warningcpu)).setVisibility(View.GONE);

                    Intent intent = new Intent(CPU.this.getActivity(), Afterwindow.class);
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


        }
        cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                img1.startAnimation(animation);
                img2.startAnimation(animation1);
                img3.startAnimation(animation2);
                img4.startAnimation(animation3);
                animation4.setStartOffset(12000);
                qwer.startAnimation(animation4);


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (i <= 100) {
                            cpu.setTextSize(18);
                            cpu.setText("optimization\n" +i + "%");

                            cpu.setEnabled(false);
                            redbtn_fan.setEnabled(false);
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
                        }else {
                            cpu.setText("optimized");
                            handler.removeCallbacks(this);
                            cpu.setEnabled(true);
                            redbtn_fan.setEnabled(true);
                            redbtn_trash.setEnabled(true);
                            redbtnrocket.setEnabled(true);
                            btn_battery_red.setEnabled(true);
                            homebtn.setEnabled(true);
                            batterybtn.setEnabled(true);
                            fanbtn.setEnabled(true);
                            trashbtn.setEnabled(true);
                            qwer.setVisibility(View.GONE);


                            Date date = new Date(System.currentTimeMillis());
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putLong("time", date.getTime());
                            editor.apply();


                            ((ImageButton)getActivity().findViewById(R.id.redbtn_fan)).setVisibility(View.GONE);
                            ((ImageButton)getActivity().findViewById(R.id.fanbtn)).setVisibility(View.VISIBLE);
                            ((ImageView)getActivity().findViewById(R.id.warningcpu)).setVisibility(View.GONE);

                            Intent intent = new Intent(CPU.this.getActivity(), Afterwindow.class);
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
                },100);
            }
        });
        return view;
        }
    private void save(){

      prefs = this.getActivity().getSharedPreferences("time",0);


    }
}