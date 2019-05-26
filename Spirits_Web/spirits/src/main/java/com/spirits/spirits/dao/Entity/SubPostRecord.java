package com.spirits.spirits.dao.Entity;


import java.sql.Timestamp;

public class SubPostRecord {
    private Integer theme_post_id;
    private String theme_post_title;
    private String illness_name;
    private String illness_type_name;
    private Integer sub_post_id;
    private String sub_post_content;
    private String posting_time;

    public SubPostRecord(Integer theme_post_id, String theme_post_title,
                         String illness_name, String illness_type_name,
                         Integer sub_post_id, String sub_post_content, Timestamp posting_time) {
        this.theme_post_id = theme_post_id;
        this.theme_post_title = theme_post_title;
        this.illness_name = illness_name;
        this.illness_type_name = illness_type_name;
        this.sub_post_id = sub_post_id;
        this.sub_post_content = sub_post_content;
        this.posting_time = posting_time.toString();
    }

    //getter
    public Integer getTheme_post_id() {
        return theme_post_id;
    }
    public String getTheme_post_title() {
        return theme_post_title;
    }
    public String getIllness_name() {
        return illness_name;
    }
    public String getIllness_type_name() {
        return illness_type_name;
    }
    public Integer getSub_post_id() {
        return sub_post_id;
    }
    public String getSub_post_content() {
        return sub_post_content;
    }
    public String getPosting_time() {
        return posting_time;
    }

    //toString
    @Override
    public String toString() {
        return "SubPostRecord{" +
                "theme_post_id=" + theme_post_id +
                ", theme_post_title='" + theme_post_title + '\'' +
                ", illness_name='" + illness_name + '\'' +
                ", illness_type_name='" + illness_type_name + '\'' +
                ", sub_post_id=" + sub_post_id +
                ", sub_post_content='" + sub_post_content + '\'' +
                ", posting_time='" + posting_time + '\'' +
                '}';
    }
}
