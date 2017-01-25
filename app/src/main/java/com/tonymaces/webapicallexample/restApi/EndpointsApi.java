package com.tonymaces.webapicallexample.restApi;

import com.tonymaces.webapicallexample.model.Territory;
import com.tonymaces.webapicallexample.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tony Macavilca Estrada on 21/01/2017.
 */

public interface EndpointsApi {
    @GET(ConstantRestApi.URL_GET_USERS)
    Call<List<User>> getUsers();

    @GET(ConstantRestApi.URL_GET_TERRITORIES)
    Call<List<Territory>> getTerritories();
}
