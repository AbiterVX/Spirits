package com.spirits.spirits.dao.Entity;

public class User {
    private String user_id;
    private String user_name;
    private String user_password;
    private int user_level;


    public User(String user_id, String user_name, String user_password, Integer user_level) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_level = user_level;
    }

    // getter
    public String getUser_id() {
        return user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getUser_password() {
        return user_password;
    }
    public int getUser_level() {
        return user_level;
    }



    // to String

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_level=" + user_level +
                '}';
    }
}
