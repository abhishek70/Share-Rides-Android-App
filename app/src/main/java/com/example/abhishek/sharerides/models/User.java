package com.example.abhishek.sharerides.models;

import android.support.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by abhishekdesai on 6/8/16.
 */
public class User {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String password;
    private String userType;

    // Constructor
    public void user(){

    }

    // Setters
    public void setFirstName(String firstName){

        this.firstName = firstName;
    }

    public void setLastName(String lastName){

        this.lastName = lastName;
    }

    public void setMobileNumber(String mobileNumber){

        this.mobileNumber = mobileNumber;
    }

    public void setEmailId(String emailId){

        this.emailId = emailId;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setUserType(String userType) {

        this.userType = userType;
    }

    // Getters
    public String getFirstName(){

        return this.firstName;
    }

    public String getLastName(){

        return this.lastName;
    }

    public String getMobileNumber(){
        return this.mobileNumber;
    }

    public String getEmailId(){

        return this.emailId;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUserType(){
        return this.userType;
    }

    @Nullable
    public static String toJSON(User user){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("firstName", user.getFirstName());
            jsonObject.put("lastName", user.getLastName());
            jsonObject.put("mobileNumber", user.getMobileNumber());
            jsonObject.put("emailId", user.getEmailId());
            jsonObject.put("password", user.getPassword());
            jsonObject.put("userType", user.getUserType());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}
