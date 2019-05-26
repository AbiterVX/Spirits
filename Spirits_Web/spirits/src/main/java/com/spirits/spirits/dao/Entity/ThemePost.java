package com.spirits.spirits.dao.Entity;

import java.sql.Timestamp;

public class ThemePost {
    private Integer theme_post_id;
    private String user_id;
    private String theme_post_title;
    private String theme_post_profile;
    private String illness_name;
    private String illness_type_name;
    private String posting_time;
    private String update_time;

    public ThemePost(Integer theme_post_id, String user_id,
                     String theme_post_title, String theme_post_profile,
                     String illness_name, String illness_type_name,
                     Timestamp posting_time, Timestamp update_time) {
        this.theme_post_id = theme_post_id;
        this.user_id = user_id;
        this.theme_post_title = theme_post_title;
        this.theme_post_profile = theme_post_profile;
        this.illness_name = illness_name;
        this.illness_type_name = illness_type_name;
        this.posting_time = posting_time.toString();
        this.update_time = update_time.toString();
    }


    // getter
    public Integer getTheme_post_id() {
        return theme_post_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getTheme_post_title() {
        return theme_post_title;
    }
    public String getTheme_post_profile() {
        return theme_post_profile;
    }
    public String getIllness_name() {
        return illness_name;
    }
    public String getIllness_type_name() {
        return illness_type_name;
    }
    public String getPosting_time() {
        return posting_time;
    }
    public String getUpdate_time() {
        return update_time;
    }


    // toString
    @Override
    public String toString() {
        return "ThemePost{" +
                "theme_post_id=" + theme_post_id +
                ", user_id='" + user_id + '\'' +
                ", theme_post_title='" + theme_post_title + '\'' +
                ", theme_post_profile='" + theme_post_profile + '\'' +
                ", illness_name='" + illness_name + '\'' +
                ", illness_type_name='" + illness_type_name + '\'' +
                ", posting_time='" + posting_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}

