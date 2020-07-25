package com.tencent.tars.client.testapp.test;
import com.tencent.tars.client.testapp.model.UserInfo;
import org.json.*;
import com.tencent.tars.client.testapp.util.Util;


public class TestDeserializer {
    public static void main(){
        Util util = new Util();
        String jsonString = "{UserInfo:{uid:0,username:sherry,password:abc123,email:xl2gs@virginia.edu,age:22}}";
        UserInfo newUser = util.deserialize(jsonString);
        System.out.println(newUser.getUid() + " " + newUser.getUsername()+" "+newUser.getPassword()+ " "+newUser.getEmail() + " "+newUser.getAge());
    }
   

}