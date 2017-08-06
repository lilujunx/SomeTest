package com.zihehealth.zihehealth.ZiheHealth.utils;

import android.util.Log;

import com.example.library.utils.SDUtil;
import com.zihehealth.zihehealth.ZiheHealth.entity.LoginCharPost;
import com.zihehealth.zihehealth.ZiheHealth.entity.LoginEntity;
import com.zihehealth.zihehealth.ZiheHealth.entity.OnlineDoctorEntity;
import com.zihehealth.zihehealth.ZiheHealth.ui.activity.OnlineDoctorActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by admin on 2017/4/6.
 */

public class LogerUtils {
    public static void saveLoger(LoginEntity.LoginResponseData loginResponseData) {
        try {
            String root = SDUtil.getExternalStoragePath() + "/xinyisheng";
            File file = new File(root);
            if (!file.exists()) {
                file.mkdirs();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(root + "/out.zhyk"));
            oos.writeObject(loginResponseData);
            Log.e("xx", "存储用户信息" + SDUtil.getExternalStoragePath() + "/xinyisheng/out.zhyk");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("xx", "存储失败");
            Log.e("xx", e.toString());
        }
    }

    public static void updateTime(String add) {
        LoginEntity.LoginResponseData loger = LogerUtils.getLoger();
        int time = Integer.parseInt(loger.getAppoint_online_times());
        if (add.equals("+")) {
            loger.setAppoint_online_times(String.valueOf(time + 1));
        } else {
            loger.setAppoint_online_times(String.valueOf(time - 1));
        }
        LogerUtils.saveLoger(loger);
    }

    public static LoginEntity.LoginResponseData getLoger() {
        LoginEntity.LoginResponseData loginResponseData = new LoginEntity.LoginResponseData();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SDUtil.getExternalStoragePath() + "/xinyisheng/out.zhyk"));
            loginResponseData = (LoginEntity.LoginResponseData) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginResponseData;
    }

    public static void saveChatLoger(LoginCharPost loginCharPost) {
        try {
            String root = SDUtil.getExternalStoragePath() + "/xinyisheng";
            File file = new File(root);
            if (!file.exists()) {
                file.mkdirs();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(root + "/outx.zhyk"));
            oos.writeObject(loginCharPost);
            Log.e("xx", "存储用户信息" + SDUtil.getExternalStoragePath() + "/xinyisheng/outx.zhyk");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("xx", "存储失败");
            Log.e("xx", e.toString());
        }
    }

    public static LoginCharPost getChatLoger() {
        LoginCharPost loginCharPost = new LoginCharPost();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SDUtil.getExternalStoragePath() + "/xinyisheng/outx.zhyk"));
            loginCharPost = (LoginCharPost) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginCharPost;
    }

    public static void saveOnlineDoctor(OnlineDoctorEntity loginCharPost) {
        try {
            String root = SDUtil.getExternalStoragePath() + "/xinyisheng";
            File file = new File(root);
            if (!file.exists()) {
                file.mkdirs();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(root + "/outxdzhyk"));
            oos.writeObject(loginCharPost);
            Log.e("xx", "存储用户信息" + SDUtil.getExternalStoragePath() + "/xinyisheng/outxdzhyk");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("xx", "存储失败");
            Log.e("xx", e.toString());
        }
    }

    public static OnlineDoctorEntity getOnlineDoctor() {
        OnlineDoctorEntity loginCharPost = new OnlineDoctorEntity();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SDUtil.getExternalStoragePath() + "/xinyisheng/outxdzhyk"));
            loginCharPost = (OnlineDoctorEntity) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginCharPost;
    }
}
