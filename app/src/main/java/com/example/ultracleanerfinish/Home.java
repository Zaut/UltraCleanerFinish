package com.example.ultracleanerfinish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Date;

public class    Home extends AppCompatActivity {
    View home;
    Fragment fragmentHome;
    Fragment fragmentBattery;
    Fragment fragmentCpu;
    Fragment fragmentTrash;
    ImageView warningrocket, warningbattery, warningcpu, warningtrash;
    ImageButton homebtn,batterybtn,fanbtn,trashbtn, redbtnrocket, btn_battery_red, redbtn_fan, redbtn_trash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homebtn = findViewById(R.id.homebtn);
        redbtnrocket = findViewById(R.id.redbtnrocket);
        batterybtn = findViewById(R.id.batterybtn);
        fanbtn = findViewById(R.id.fanbtn);
        trashbtn = findViewById(R.id.trashbtn);
        warningrocket = findViewById(R.id.warningrocket);
        warningcpu = findViewById(R.id.warningcpu);
        btn_battery_red = findViewById(R.id.btn_battery_red);
        warningbattery = findViewById(R.id.warningbattery);
        redbtn_fan = findViewById(R.id.redbtn_fan);
        redbtn_trash = findViewById(R.id.redbtn_trash);
        warningtrash = findViewById(R.id.warningtrash);
        home = findViewById(R.id.fragbattery);

        fragmentHome = new FHome();
        fragmentBattery = new Battery();
        fragmentCpu = new CPU();
        fragmentTrash = new Trash();
        Date date2 = new Date(System.currentTimeMillis());
        Long wer = Long.valueOf(date2.getTime());
        SharedPreferences prefss = getSharedPreferences("time",MODE_PRIVATE);
        Long restoredText = prefss.getLong("time", 0);

                if (wer - restoredText > 1000*60*2) {

                } else {
                   fanbtn.setVisibility(View.VISIBLE);
                   redbtn_fan.setVisibility(View.GONE);
                   warningcpu.setVisibility(View.GONE);
                }

        Date date3 = new Date(System.currentTimeMillis());
        Long home = Long.valueOf(date3.getTime());
        SharedPreferences homepref = getSharedPreferences("home",MODE_PRIVATE);
        Long restoredhome = homepref.getLong("home", 0);

        if (home - restoredhome > 1000*60*2) {

        } else {
            homebtn.setVisibility(View.VISIBLE);
            redbtnrocket.setVisibility(View.GONE);
            warningrocket.setVisibility(View.GONE);
        }

        Date date4 = new Date(System.currentTimeMillis());
        Long battery = Long.valueOf(date4.getTime());
        SharedPreferences batterypref = getSharedPreferences("battery",MODE_PRIVATE);
        Long restoredbattery = batterypref.getLong("battery", 0);

        if (battery - restoredbattery > 1000*60*2) {

        } else {
            batterybtn.setVisibility(View.VISIBLE);
            btn_battery_red.setVisibility(View.GONE);
            warningbattery.setVisibility(View.GONE);
        }

        Date date5 = new Date(System.currentTimeMillis());
        Long trash = Long.valueOf(date5.getTime());
        SharedPreferences trashrypref = getSharedPreferences("trash",MODE_PRIVATE);
        Long restoredtrash = trashrypref.getLong("trash", 0);

        if (trash - restoredtrash > 1000*60*2) {

        } else {
            trashbtn.setVisibility(View.VISIBLE);
            redbtn_trash.setVisibility(View.GONE);
            warningbattery.setVisibility(View.GONE);
        }


    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        try {

            String fName = intent.getStringExtra("fragment_number");
            Log.d("teg", fName);
            Fragment fragment;
            switch (fName) {
                case ("1"):
                    fragment = fragmentHome;

                    homebtn.setBackgroundTintList(getColorStateList(R.color.blue));
                    homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_white));

                    batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                    btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                    batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));

                    fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                    redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                    fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                    trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                    redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                    trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));
                    break;
                case ("2"):
                    fragment = fragmentBattery;
                    btn_battery_red.setBackgroundTintList(getColorStateList(R.color.blue));
                    batterybtn.setBackgroundTintList(getColorStateList(R.color.blue));
                    batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_white));


                    homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                    redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));
                    homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));

                    fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                    redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                    fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                    trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                    redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                    trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));
                    break;
                case ("3"):
                    fragment = fragmentCpu;

                    redbtn_fan.setBackgroundTintList(getColorStateList(R.color.blue));
                    fanbtn.setBackgroundTintList(getColorStateList(R.color.blue));
                    fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_whit));

                    homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                    homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));
                    redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));

                    btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                    batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                    batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));

                    trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                    redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                    trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));
                    break;
                case ("4"):
                    fragment = fragmentTrash;
                    redbtn_trash.setBackgroundTintList(getColorStateList(R.color.blue));
                    trashbtn.setBackgroundTintList(getColorStateList(R.color.blue));
                    trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_white));


                    fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                    redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                    fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                    homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                    homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));
                    redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));

                    btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                    batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                    batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));
                    break;
                default:
                    fragment = fragmentHome;
                    break;
            }
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fr_place, fragment);
            ft.commit();
        } catch (Exception ex) {

        }
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Выйти из приложения?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {


                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid()); System.exit(1);
                        finishAndRemoveTask();


                    }
                }).create().show();
    }


    public void onClick(View v) {
        Fragment fragment = null;


        switch (v.getId()) {
            case R.id.homebtn:
                fragment = fragmentHome;

                homebtn.setBackgroundTintList(getColorStateList(R.color.blue));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_white));

                batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));

                fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));
                break;

            case R.id.redbtnrocket:
                fragment = fragmentHome;

                homebtn.setBackgroundTintList(getColorStateList(R.color.blue));
                redbtnrocket.setBackgroundTintList(getColorStateList(R.color.blue));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_white));


                batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));

                fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));

                break;

            case R.id.btn_battery_red:
                fragment = fragmentBattery;
                btn_battery_red.setBackgroundTintList(getColorStateList(R.color.blue));
                batterybtn.setBackgroundTintList(getColorStateList(R.color.blue));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_white));


                homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));

                fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));
                break;

            case R.id.batterybtn:
                fragment = fragmentBattery;
                batterybtn.setBackgroundTintList(getColorStateList(R.color.blue));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_white));

                homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));
                redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));

                fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));



                break;

            case R.id.fanbtn:
                fragment = fragmentCpu;

                fanbtn.setBackgroundTintList(getColorStateList(R.color.blue));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_whit));

                homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));
                redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));

                btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));

                trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));
                break;


            case R.id.redbtn_fan:
                fragment = fragmentCpu;

                redbtn_fan.setBackgroundTintList(getColorStateList(R.color.blue));
                fanbtn.setBackgroundTintList(getColorStateList(R.color.blue));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_whit));

                homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));
                redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));

                btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));

                trashbtn.setBackgroundTintList(getColorStateList(R.color.white));
                redbtn_trash.setBackgroundTintList(getColorStateList(R.color.white));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_blue));
                break;


            case R.id.trashbtn:
                fragment = fragmentTrash;

                trashbtn.setBackgroundTintList(getColorStateList(R.color.blue));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_white));


                redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));
                redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));

                btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));
                break;

            case R.id.redbtn_trash:
                fragment = fragmentTrash;
                redbtn_trash.setBackgroundTintList(getColorStateList(R.color.blue));
                trashbtn.setBackgroundTintList(getColorStateList(R.color.blue));
                trashbtn.setImageDrawable(getDrawable(R.drawable.ic_trash_white));

                redbtn_fan.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setBackgroundTintList(getColorStateList(R.color.white));
                fanbtn.setImageDrawable(getDrawable(R.drawable.ic_fan_blue));

                homebtn.setBackgroundTintList(getColorStateList(R.color.white));
                homebtn.setImageDrawable(getDrawable(R.drawable.ic_rocket_blue));
                redbtnrocket.setBackgroundTintList(getColorStateList(R.color.white));

                btn_battery_red.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setBackgroundTintList(getColorStateList(R.color.white));
                batterybtn.setImageDrawable(getDrawable(R.drawable.ic_battery_blue));
                break;
        }
       FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.replace(R.id.fr_place, fragment);
        ft.commit();
    }

}