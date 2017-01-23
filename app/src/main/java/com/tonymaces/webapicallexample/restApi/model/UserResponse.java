package com.tonymaces.webapicallexample.restApi.model;

import com.tonymaces.webapicallexample.model.User;

import java.util.ArrayList;

/**
 * Created by Tony Macavilca Estrada on 21/01/2017.
 */

public class UserResponse {
    ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
