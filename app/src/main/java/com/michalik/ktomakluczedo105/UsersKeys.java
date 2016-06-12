package com.michalik.ktomakluczedo105;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersKeys {

    @SerializedName("User")
    @Expose
    private String user;
    @SerializedName("Date")
    @Expose
    private String date;

    /**
     *
     * @return
     * The user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The User
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The Date
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return user+"\t"+date;
    }
}