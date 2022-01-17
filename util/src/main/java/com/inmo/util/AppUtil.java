package com.inmo.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * APP工具类
 *
 * @author Administrator
 * @date 2021-11-23
 */
public class AppUtil {

    private static final String TAG = AppUtil.class.getSimpleName();

    /**
     * 获取设备里面安装的应用
     *
     * @param context
     * @param type    类型 0-所有应用程序 1-系统自带APP 2-第三方APP 3-安装在SDCard的应用程序
     * @return
     */
    public static List<PackageInfo> getPackages(Context context, int type) {
        List<PackageInfo> packageInfo = context.getPackageManager().getInstalledPackages(0);
        List<PackageInfo> result = new ArrayList<>();
        switch (type) {
            case 0:
                result = packageInfo;
                break;
            case 1:
                for (PackageInfo info : packageInfo) {
                    if ((info.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 1) {
                        result.add(info);
                    }
                }
                break;
            case 2:
                for (PackageInfo info : packageInfo) {
                    if ((info.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                        result.add(info);
                    } else if ((info.applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) == 1) {
                        result.add(info);
                    }
                }
                break;
            case 3:
                for (PackageInfo info : packageInfo) {
                    if ((info.applicationInfo.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == 1) {
                        result.add(info);
                    }
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 通过包名检测APP是否安装
     *
     * @param packageName 包名
     * @return true or false
     */
    public static boolean isInstalled(Context mContext, String packageName) {
        boolean isInstalled = false;
        if (!TextUtils.isEmpty(packageName)) {
            PackageInfo packageInfo;
            try {
                packageInfo = mContext.getPackageManager().getPackageInfo(packageName, 0);
            } catch (PackageManager.NameNotFoundException e) {
                packageInfo = null;
                e.printStackTrace();
            }
            if (packageInfo == null) {
                isInstalled = false;
            } else {
                isInstalled = true;
            }
        }
        Log.i(TAG, packageName + "is installed ? " + isInstalled);
        return isInstalled;
    }

    private static List<String> selfStudyApps;

    /**
     * 第三方APP中过滤自研应用
     *
     * @return
     */
    public static List<PackageInfo> filterSelfStudyApp(Context context) {
        List<PackageInfo> result = new ArrayList<>();
        selfStudyApps = new ArrayList<>();
        selfStudyApps.add("com.inmoglass.launcher");
        selfStudyApps.add("com.yulong.coolgallery");
        selfStudyApps.add("com.inmo.settings");
        selfStudyApps.add("com.yulong.coolcamera");
        selfStudyApps.add("com.inmoglass.music");
        selfStudyApps.add("com.koushikdutta.vysor");
        selfStudyApps.add("com.inmo.translation");
        selfStudyApps.add("com.inmo.settings");
        selfStudyApps.add("com.inmolens.inmomemo");
        selfStudyApps.add("com.inmolens.voiceidentify");
        selfStudyApps.add("com.inmoglass.sensorcontrol");
        List<PackageInfo> packageInfo = getPackages(context, 2);
        for (PackageInfo info : packageInfo) {
            if ((info.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0 && !selfStudyApps.contains(info.packageName)) {
                result.add(info);
            }
        }
        return result;
    }
}
