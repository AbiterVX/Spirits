package com.spirits.spirits.dao.Entity;

import java.sql.Timestamp;

public class CommentRecord {
    private String theme_post_title;
    private String illness_name;
    private String illness_type_name;
    private int comment_id;
    private String comment_content;
    private String posting_time;

    public CommentRecord(String theme_post_title,
                         String illness_name, String illness_type_name,
                         Integer comment_id, String comment_content, Timestamp posting_time) {
        this.theme_post_title = theme_post_title;
        this.illness_name = illness_name;
        this.illness_type_name = illness_type_name;
        this.comment_id = comment_id;
        this.comment_content = comment_content;
        this.posting_time = posting_time.toString();
    }

    // getter
    public String getTheme_post_title() {
        return theme_post_title;
    }
    public String getIllness_name() {
        return illness_name;
    }
    public String getIllness_type_name() {
        return illness_type_name;
    }
    public int getComment_id() {
        return comment_id;
    }
    public String getComment_content() {
        return comment_content;
    }
    public String getPosting_time() {
        return posting_time;
    }

    // tostring
    @Override
    public String toString() {
        return "CommentRecord{" +
                "theme_post_title='" + theme_post_title + '\'' +
                ", illness_name='" + illness_name + '\'' +
                ", illness_type_name='" + illness_type_name + '\'' +
                ", comment_id=" + comment_id +
                ", comment_content='" + comment_content + '\'' +
                ", posting_time='" + posting_time + '\'' +
                '}';
    }
}
