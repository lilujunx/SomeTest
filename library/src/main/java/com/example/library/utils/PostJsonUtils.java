package com.zihehealth.zihehealth.ZiheHealth.utils;

import com.zihehealth.zihehealth.ZiheHealth.entity.PostJson;
import com.google.gson.Gson;

/**
 * Created by admin on 2017/4/6.
 */

public class PostJsonUtils<T> {

    private static PostJsonUtils mPostJsonUtils;

    private PostJsonUtils() {

    }

    public static PostJsonUtils getPostJson() {
        if (mPostJsonUtils == null) {
            synchronized (PostJsonUtils.class) {
                if (mPostJsonUtils == null) {
                    mPostJsonUtils = new PostJsonUtils<>();
                }
            }
        }
        return mPostJsonUtils;
    }


    public String getPost(String msg, T data) {
        PostJson<T> postJson = new PostJson<>();
        Gson gson = new Gson();
        if (data != null) {
            postJson.setData(data);
        }
        postJson.setMsg(msg);
        return gson.toJson(postJson);
    }


}
