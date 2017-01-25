package com.tonymaces.webapicallexample.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Tony Macavilca Estrada on 25/01/2017.
 */

public class Territory implements Serializable {
    @Expose
    private String id;
    @Expose
    private String locality;
    @Expose
    private  String number;
    @Expose
    private  String description;

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
