package com.tencent.tars.client.testapp.util;
import com.tencent.tars.client.testapp.model.UserInfo; 
import org.json.*;

public class Util {
    public Util(){

    }
    public UserInfo deserialize(String jsonString) {
    	JSONObject obj = new JSONObject(jsonString).getJSONObject("UserInfo");
        int uid = obj.getInt("uid");
        String username = obj.getString("username");
        String password = obj.getString("password");
        String email = obj.getString("email");
        int age = obj.getInt("age");
        UserInfo newUser = new UserInfo(uid, username, password, email, age);
        return newUser;
    }
}