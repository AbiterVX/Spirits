package com.spirits.spirits.dao.Entity;

import java.sql.Timestamp;

public class Comment {
    private Integer sub_post_id;
    private Integer comment_id;
    private String user_id;
    private String comment_content;
    private String posting_time;
    public Comment(Integer sub_post_id, Integer comment_id, String user_id, String comment_content, Timestamp posting_time) {
        this.sub_post_id = sub_post_id;
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.comment_content = comment_content;
        this.posting_time = posting_time.toString();
    }

    // getter
    public Integer getSub_post_id() {
        return sub_post_id;
    }
    public Integer getComment_id() {
        return comment_id;
    }
    public String getUser_id() {
        return user_id;
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
        return "Comment{" +
                "sub_post_id=" + sub_post_id +
                ", comment_id=" + comment_id +
                ", user_id='" + user_id + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", posting_time='" + posting_time + '\'' +
                '}';
    }
}
