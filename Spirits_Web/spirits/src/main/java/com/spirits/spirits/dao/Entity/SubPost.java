package com.spirits.spirits.dao.Entity;

import java.sql.Timestamp;

public class SubPost {
    private Integer theme_post_id;
    private Integer sub_post_id;
    private String user_id;
    private String sub_post_content;
    private String posting_time;
    private Long row_index;
    public SubPost(Integer theme_post_id, Integer sub_post_id, String user_id, String sub_post_content, Timestamp posting_time,Long row_index) {
        this.theme_post_id = theme_post_id;
        this.sub_post_id = sub_post_id;
        this.user_id = user_id;
        this.sub_post_content = sub_post_content;
        this.posting_time = posting_time.toString();
        this.row_index=row_index;
    }

    // getter
    public Integer getTheme_post_id() {
        return theme_post_id;
    }
    public Integer getSub_post_id() {
        return sub_post_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getSub_post_content() {
        return sub_post_content;
    }
    public String getPosting_time() {
        return posting_time;
    }
    public Long getRow_index() {
        return row_index;
    }
    // tostring

    @Override
    public String toString() {
        return "SubPost{" +
                "theme_post_id=" + theme_post_id +
                ", sub_post_id=" + sub_post_id +
                ", user_id='" + user_id + '\'' +
                ", sub_post_content='" + sub_post_content + '\'' +
                ", posting_time='" + posting_time + '\'' +
                ", row_index=" + row_index +
                '}';
    }
}
