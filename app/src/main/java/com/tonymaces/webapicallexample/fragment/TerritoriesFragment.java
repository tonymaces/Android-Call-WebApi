package com.tonymaces.webapicallexample.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tonymaces.webapicallexample.R;
import com.tonymaces.webapicallexample.adapter.TerritoryAdapter;
import com.tonymaces.webapicallexample.model.Territory;
import com.tonymaces.webapicallexample.restApi.EndpointsApi;
import com.tonymaces.webapicallexample.restApi.adapter.RestApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class TerritoriesFragment extends Fragment {
    public static final String TAG = TerritoriesFragment.class.toString();
    private RecyclerView mRecyclerView;
    private TerritoryAdapter  mTerritoryAdapter;
    private ArrayList<Territory> mTerritories;

    public TerritoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_territories, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvTerritories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        LoadTerritories();
        IniAdapter();

        return  view;
    }

    private  void  LoadTerritories(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.conectionRestApi();
        Call<List<Territory>> territoryResponseCall = endpointsApi.getTerritories();
        territoryResponseCall.enqueue(new Callback<List<Territory>>() {
            @Override
            public void onResponse(Call<List<Territory>> call, Response<List<Territory>> response) {
                if (response.isSuccessful()){
                    Log.d(TAG,"response isSuccess");
                    List<Territory> territories = response.body();
                    for (int i=0; i <territories.size(); i++){
                        Territory territory = territories.get(i);
                        mTerritoryAdapter.setTerritory(territory);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Territory>> call, Throwable t) {
                Log.e("Call Failure", t.toString());
            }
        });
    }

    public  void IniAdapter(){
        mTerritoryAdapter = new TerritoryAdapter(getActivity());
        mRecyclerView.setAdapter(mTerritoryAdapter);
    }
}
