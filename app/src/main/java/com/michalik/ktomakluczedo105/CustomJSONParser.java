package com.michalik.ktomakluczedo105;

import android.util.JsonReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.sql.Date;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by michalik on 12.06.16.
 */
public class CustomJSONParser {

    private String json;
    private List<UsersKeys> usersKeysList;

    public CustomJSONParser(String json){
        this.json = json;
        usersKeysList = new ArrayList<UsersKeys>();
    }

    void parseObject(){
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement =  jsonParser.parse(json);
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        Gson gson = new Gson();
        usersKeysList = gson.fromJson(json, new TypeToken<List<UsersKeys>>(){}.getType());
        usersKeysList.toString();
    }


    public List<UsersKeys> getUsersKeysList() {
        return usersKeysList;
    }
}
