package com.tonymaces.webapicallexample.restApi.deserialize;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.tonymaces.webapicallexample.restApi.model.UserResponse;

import java.lang.reflect.Type;

/**
 * Created by Tony Macavilca Estrada on 21/01/2017.
 */

public class UserDeserialize implements JsonDeserializer<UserResponse> {
    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
