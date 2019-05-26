package com.spirits.spirits.dao.Entity;

import java.sql.Timestamp;

public class ThemePostRecord {
    private Integer theme_post_id;
    private String user_id;
    private String theme_post_title;
    private String theme_post_profile;
    private Integer illness_id;
    private Integer illness_type_id;
    private String posting_time;
    private String update_time;

    public ThemePostRecord(Integer theme_post_id, String user_id, String theme_post_title, String theme_post_profile,
                           Integer illness_id, Integer illness_type_id, Timestamp posting_time, Timestamp update_time) {
        this.theme_post_id = theme_post_id;
        this.user_id = user_id;
        this.theme_post_title = theme_post_title;
        this.theme_post_profile = theme_post_profile;
        this.illness_id = illness_id;
        this.illness_type_id = illness_type_id;
        this.posting_time = posting_time.toString();
        this.update_time = update_time.toString();
    }

    //getter
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
    public Integer getIllness_id() {
        return illness_id;
    }
    public Integer getIllness_type_id() {
        return illness_type_id;
    }
    public String getPosting_time() {
        return posting_time;
    }
    public String getUpdate_time() {
        return update_time;
    }


    //tostring
    @Override
    public String toString() {
        return "ThemePostRecord{" +
                "theme_post_id=" + theme_post_id +
                ", user_id='" + user_id + '\'' +
                ", theme_post_title='" + theme_post_title + '\'' +
                ", theme_post_profile='" + theme_post_profile + '\'' +
                ", illness_id=" + illness_id +
                ", illness_type_id=" + illness_type_id +
                ", posting_time='" + posting_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
