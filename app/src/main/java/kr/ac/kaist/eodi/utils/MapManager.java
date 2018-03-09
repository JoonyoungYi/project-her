package kr.ac.kaist.eodi.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by yearnning on 15. 1. 28..
 */
public class MapManager {

    private Location location = null;

    public MapManager(Location location) {
        this.location = location;
    }

    public void showMap(Context context) {

        /**
         *
         */
        MAP_APPLICATION properMapApplication = getProperMapApplication(context);

        /**
         *
         */
        Uri uri = null;
        if (properMapApplication == MAP_APPLICATION.GOOGLE || properMapApplication == MAP_APPLICATION.ELSE) {
            uri = Uri.parse("geo:0,0?q=" + location.getLatitude() + "," + location.getLongitude() + "?z=15");
        } else {
            uri = Uri.parse("geo:" + location.getLatitude() + "," + location.getLongitude() + "?z=15");
        }

        /**
         *
         */
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        if (properMapApplication.package_name != null) {
            intent.setPackage(properMapApplication.package_name);
            context.startActivity(intent);

        } else if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);

        } else {
            Toast.makeText(context, "정상적으로 실행할 수 있는 지도 앱이 없습니다", Toast.LENGTH_SHORT).show();
        }
    }

    private MAP_APPLICATION getProperMapApplication(Context context) {

        if (isPackageInstalled(MAP_APPLICATION.GOOGLE.package_name, context)) {
            return MAP_APPLICATION.GOOGLE;

        } else if (isPackageInstalled(MAP_APPLICATION.NAVER.package_name, context)) {
            return MAP_APPLICATION.NAVER;

        } else if (isPackageInstalled(MAP_APPLICATION.DAUM.package_name, context)) {
            return MAP_APPLICATION.DAUM;

        } else {
            return MAP_APPLICATION.ELSE;
        }
    }

    private boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private enum MAP_APPLICATION {
        GOOGLE("com.google.android.apps.maps"), NAVER("com.nhn.android.nmap"), DAUM("net.daum.android.map"), ELSE(null);
        public String package_name;

        private MAP_APPLICATION(String package_name) {
            this.package_name = package_name;
        }
    }

}
