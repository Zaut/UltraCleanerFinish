package com.example.ultracleanerfinish;


import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class GetApps {
    public static List<Drawable> getApps(Activity activity) {
        List<Drawable> result = new ArrayList<>();
        PackageManager packageManager = activity.getPackageManager();
        List<ApplicationInfo> listOfAppInfo = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo applicationInfo : listOfAppInfo) {
            // this is our app
            if (applicationInfo.packageName.equals(activity.getPackageName())) continue;

            // this is system app
            try {
                if ((packageManager.getApplicationInfo(applicationInfo.packageName,
                        PackageManager.GET_META_DATA).flags & ApplicationInfo.FLAG_SYSTEM) != 0) continue;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            result.add(packageManager.getApplicationIcon(applicationInfo));
        }

        return result;
    }
}
