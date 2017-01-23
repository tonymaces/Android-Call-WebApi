package com.tonymaces.webapicallexample.restApi.adapter;

import com.tonymaces.webapicallexample.restApi.ConstantRestApi;
import com.tonymaces.webapicallexample.restApi.EndpointsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tony Macavilca Estrada on 21/01/2017.
 */

public class RestApiAdapter {
    public EndpointsApi conectionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) // fa la serialization de forma general
                .build();

        return  retrofit.create(EndpointsApi.class);
    }
}
