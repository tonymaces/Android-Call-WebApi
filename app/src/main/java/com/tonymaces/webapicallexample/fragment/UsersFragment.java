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
import com.tonymaces.webapicallexample.adapter.UserAdapter;
import com.tonymaces.webapicallexample.model.User;
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
public class UsersFragment extends Fragment {
    public static final String TAG = UsersFragment.class.toString();
    private RecyclerView mRecyclerView;
    private UserAdapter mUserAdapter;
    private ArrayList<User> mUsers;

    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_users, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rvUsers);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        LoadUsers();
        IniAdapter();
        return v;
    }

    private void LoadUsers(){

        RestApiAdapter restApiAdapter = new RestApiAdapter(); // esblece una conceccion con la api instagram
        EndpointsApi endpointsApi = restApiAdapter.conectionRestApi(); // ejecuta la llamada al servidor
        Call<List<User>> userResponseCall =  endpointsApi.getUsers();  // ejecuto la llamada al server

        // con esto controllamos el resultado della respuesta
        userResponseCall.enqueue(new Callback<List<User>>(){


            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d(TAG,"Tutto ok");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }

    public  void IniAdapter(){

        mUserAdapter = new UserAdapter(getActivity());
        mRecyclerView.setAdapter(mUserAdapter);
    }
}
