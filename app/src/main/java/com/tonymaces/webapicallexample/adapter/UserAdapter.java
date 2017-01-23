package com.tonymaces.webapicallexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tonymaces.webapicallexample.R;
import com.tonymaces.webapicallexample.model.User;

import java.util.ArrayList;

/**
 * Created by Tony Macavilca Estrada on 21/01/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private static final String TAG = UserAdapter.class.toString();
    private ArrayList<User> mUsers;
    private Context mContext;

    public UserAdapter(Context context) {
        this.mContext = context;
        this.mUsers = new ArrayList<>();
    }

    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_users,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserAdapter.UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.tvName.setText(String.valueOf(user.getName()));
        holder.tvUserName.setText(String.valueOf(user.getUsername()));
        holder.tvPassword.setText(String.valueOf(user.getPassword()));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvUserName;
        private TextView tvPassword;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvPassword = (TextView) itemView.findViewById(R.id.tvUserPassword);
        }
    }
}
