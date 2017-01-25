package com.tonymaces.webapicallexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tonymaces.webapicallexample.R;
import com.tonymaces.webapicallexample.model.Territory;

import java.util.ArrayList;

/**
 * Created by Tony Macavilca Estrada on 25/01/2017.
 */

public class TerritoryAdapter extends RecyclerView.Adapter<TerritoryAdapter.TerritoryViewHolder> {
    private static final String TAG = TerritoryAdapter.class.toString();
    private ArrayList<Territory> mTerritories;
    private Context mContext;

    public TerritoryAdapter(Context mContext) {
        this.mContext = mContext;
        this.mTerritories = new ArrayList<>();
    }

    @Override
    public TerritoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_territories,parent,false);
        return new TerritoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TerritoryViewHolder holder, int position) {
        Territory territory = mTerritories.get(position);
        holder.tvLocality.setText(String.valueOf(territory.getLocality()));
        holder.tvNumber.setText(String.valueOf(territory.getNumber()));
        holder.tvDescription.setText(String.valueOf(territory.getDescription()));
    }

    @Override
    public int getItemCount() {
        return mTerritories.size();
    }

    public void setTerritory(Territory territory){
        Log.d(TAG,territory.getLocality());
        mTerritories.add(territory);
        notifyDataSetChanged();
    }

    public class TerritoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLocality;
        private TextView tvNumber;
        private TextView tvDescription;

        public TerritoryViewHolder(View itemView) {
            super(itemView);
            tvLocality = (TextView) itemView.findViewById(R.id.tvLocality);
            tvNumber = (TextView) itemView.findViewById(R.id.tvNumber);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
