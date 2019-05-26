package com.spirits.spirits.dao;

import com.spirits.spirits.dao.Entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Dao_Community {
    // 主题帖
    @Select("select theme_post_id,user_id,theme_post_title,theme_post_profile,\n" +
            "   illness_name,illness_type_name,posting_time,update_time from \n" +
            "   (\n" +
            "   select *,ROW_NUMBER() over\n" +
            "   (\n" +
            "       order by \n" +
            "       update_time desc\n" +
            "   ) row_index\n" +
            "   from t_theme_post\n" +
            "   where illness_type_id=#{illness_type}\n" +
            "   )\n" +
            "results,t_illness,t_illness_type\n" +
            "where results.row_index>#{page_index}\n" +
            "and results.row_index<=#{next_page_index}\n" +
            "and results.illness_id=t_illness.illness_id\n" +
            "and results.illness_type_id=t_illness_type.illness_type_id")
    List<ThemePost> getThemePostInformation(@Param("illness_type")int illness_type,
                                            @Param("page_index")int page_index, @Param("next_page_index")int next_page_index);

    @Select("select theme_post_id,user_id,theme_post_title,theme_post_profile,\n" +
            "   illness_name,illness_type_name,posting_time,update_time from \n" +
            "   (\n" +
            "   select *,ROW_NUMBER() over\n" +
            "   (\n" +
            "       order by \n" +
            "       update_time desc\n" +
            "   ) row_index\n" +
            "   from t_theme_post\n" +
            "   )\n" +
            "results,t_illness,t_illness_type\n" +
            "where results.row_index>#{page_index}\n" +
            "and results.row_index<=#{next_page_index}\n" +
            "and results.illness_id=t_illness.illness_id\n" +
            "and results.illness_type_id=t_illness_type.illness_type_id")
    List<ThemePost> getThemePostInformation_All(@Param("page_index")int page_index, @Param("next_page_index")int next_page_index);

    @Select("select count(*) from t_theme_post\n" +
            "where illness_type_id=#{illness_type}")
    int getThemePostMaxPageIndex(@Param("illness_type")int illness_type);

    @Select("select count(*) " +
            "from t_theme_post")
    int getThemePostMaxPageIndex_All();

    @Select("select * from t_theme_post " +
            "where user_id=#{user_id}")
    List<ThemePostRecord> getUserThemePostInformation(@Param("user_id") String user_id);

    @Select("Insert into t_theme_post(user_id,theme_post_title,theme_post_profile,\n" +
            "                         illness_id,illness_type_id,posting_time,update_time) \n" +
            "values(#{user_id},#{theme_post_title},#{theme_post_profile},#{illness_id},#{illness_type_id},GETDATE(),GETDATE())")
    void insertThemePost(@Param("user_id") String user_id,
                         @Param("theme_post_title") String theme_post_title,@Param("theme_post_profile") String theme_post_profile,
                         @Param("illness_id") int illness_id,@Param("illness_type_id") int illness_type_id);

    @Select("delete from t_theme_post " +
            "where theme_post_id=#{theme_post_id}")
    void deleteThemePost(@Param("theme_post_id") int theme_post_id);


    @Select("update t_theme_post set theme_post_title=#{theme_post_title},theme_post_profile=#{theme_post_profile}," +
            "illness_id=#{illness_id},illness_type_id=#{illness_type_id} \n" +
            "where theme_post_id=#{theme_post_id}")
    void updateThemePost(@Param("theme_post_id") int theme_post_id,
                         @Param("theme_post_title") String theme_post_title,@Param("theme_post_profile") String theme_post_profile,
                         @Param("illness_id") int illness_id,@Param("illness_type_id") int illness_type_id);



    //子贴
    @Select("select count(*) from t_sub_post " +
            "where theme_post_id=#{theme_post_id}")
    int getSubPostNumber(@Param("theme_post_id") int theme_post_id);

    @Select("select theme_post_id,sub_post_id,user_id,sub_post_content,posting_time,row_index from \n" +
            "(\n" +
            "select *,ROW_NUMBER() over\n" +
            "(\n" +
            "order by \n" +
            "posting_time asc\n" +
            ") row_index\n" +
            "from t_sub_post\n" +
            "where theme_post_id=#{theme_post_id}\n" +
            ")\n" +
            "results\n" +
            "where results.row_index>#{page_index}\n" +
            "and results.row_index<=#{next_page_index}")
    List<SubPost> getSubPostInformation(@Param("theme_post_id")int theme_post_id,
                                        @Param("page_index")int page_index, @Param("next_page_index")int next_page_index);

    @Select("declare @date DateTime=GETDATE()\n" +
            "Insert into t_sub_post(theme_post_id,user_id,sub_post_content,posting_time) \n" +
            "values(#{theme_post_id},#{user_id},#{sub_post_content},@date)\n" +
            "update t_theme_post set update_time=@date\n" +
            "where theme_post_id=#{theme_post_id}")
    void insertSubPost(@Param("theme_post_id")int theme_post_id,
                       @Param("user_id") String user_id,
                       @Param("sub_post_content") String sub_post_content);

    @Select("delete from t_sub_post " +
            "where sub_post_id=#{sub_post_id}")
    void deleteSubPost(@Param("sub_post_id") int sub_post_id);

    @Select("select t_sub_post.theme_post_id,t_theme_post.theme_post_title,\n" +
            "\t   illness_name,illness_type_name,\n" +
            "\t   sub_post_id,sub_post_content,t_sub_post.posting_time \n" +
            "from t_sub_post,t_theme_post,t_illness,t_illness_type\n" +
            "where t_sub_post.user_id=#{user_id}\n" +
            "and t_sub_post.theme_post_id=t_theme_post.theme_post_id\n" +
            "and t_theme_post.illness_id=t_illness.illness_id\n" +
            "and t_theme_post.illness_type_id=t_illness_type.illness_type_id")
    List<SubPostRecord> getUserSubPostInformation(@Param("user_id") String user_id);



    //评论
    @Select("Insert into t_comment(sub_post_id,user_id,comment_content,posting_time) \n" +
            "values(#{sub_post_id},#{user_id},#{comment_content},GETDATE())")
    void insertComment(@Param("sub_post_id") int sub_post_id,
                       @Param("user_id") String user_id,
                       @Param("comment_content") String comment_content);

    @Select("delete from t_comment " +
            "where comment_id=#{comment_id}")
    void deleteComment(@Param("comment_id") int comment_id);

    @Select("select count(*) from t_comment " +
            "where sub_post_id=#{sub_post_id} ")
    int getCommentNumber(@Param("sub_post_id") int sub_post_id);

    @Select("select sub_post_id,comment_id,user_id,comment_content,posting_time \n" +
            "from t_comment\n" +
            "where sub_post_id=#{sub_post_id}")
    List<Comment> getCommentInformation(@Param("sub_post_id") int sub_post_id);

    @Select("select theme_post_title,\n" +
            "illness_name,illness_type_name,\n" +
            "comment_id,comment_content,t_comment.posting_time\n" +
            "from t_comment,t_sub_post,t_theme_post,t_illness,t_illness_type\n" +
            "where t_comment.user_id=#{user_id}\n" +
            "and t_comment.sub_post_id=t_sub_post.sub_post_id\n" +
            "and t_sub_post.theme_post_id=t_theme_post.theme_post_id\n" +
            "and t_theme_post.illness_id=t_illness.illness_id\n" +
            "and t_theme_post.illness_type_id=t_illness_type.illness_type_id")
    List<CommentRecord> getUserCommentInformation(@Param("user_id") String user_id);


}
