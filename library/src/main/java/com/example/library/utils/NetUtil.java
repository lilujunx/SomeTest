package com.zihehealth.zihehealth.ZiheHealth.utils;


import com.zihehealth.zihehealth.ZiheHealth.Constant;

import javax.xml.XMLConstants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Administrator on 2016/11/18.
 */

public class NetUtil {


    public static <T> T getRetrofitCall (Class<T> service){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        return (T)retrofit.create(service);
    }

    public static <T> T getRetrofitCallXML (Class<T> service){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return (T)retrofit.create(service);
    }
}
