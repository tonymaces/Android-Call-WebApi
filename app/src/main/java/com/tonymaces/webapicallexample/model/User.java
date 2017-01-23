package com.tonymaces.webapicallexample.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tony Macavilca Estrada on 21/01/2017.
 */

public class User implements Serializable {
    @Expose
    private  String id;
    @Expose
    private  String name;
    @Expose
    private  String username;
    @Expose
    private  String password;
    @Expose
    private Date createdAt;
    @Expose
    private Date updatedAt;
    @Expose
    private Date sessionToken;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(Date sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
