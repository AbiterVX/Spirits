package com.spirits.spirits.service;


import com.spirits.spirits.dao.Entity.*;

import java.util.List;




public interface Service {
    // HomePage
    List<Illness> getAllIllnessInformation();
    List<Illness> getIllnessInformation(int illness_type);

    // User Sign
    String signUp(String user_name,String user_password);
    User signIn(String user_id, String user_password);

    // User Information
    UserInformation getUserInformation(String user_id);
    void updateUserInformation(String user_age, int user_sex, int user_province, int user_city,int user_area, String user_id, String user_name);
    void updateUserPassword( String user_id, String user_password);
    String getUserName(String user_id);
    // File
    String downloadFile(String file_name);
    void uploadFile(String file_name,String data);


    // Testing
    List<TestingInformation> getTestingInformation(int illness_type, int page_index);
    int getMaxPageIndex(int illness_type);
    List<Question> getTestingQuestions(String testing_id);
    String getTestingResult(String testing_id,int score);
    void insertTestingResult(int testing_id, String user_id,String testing_result);
    List<TestingRecord> getTestingRecordInformation(String user_id);
    void deleteTestingRecordInformation(int testing_record_id);

    // ThemePost
    List<ThemePost> getThemePostInformation(int illness_type, int page_index);
    int getThemePostMaxPageIndex(int illness_type);
    List<ThemePostRecord> getUserThemePostInformation(String user_id);
    void insertThemePost(String user_id, String theme_post_title,String theme_post_profile, int illness_id,int illness_type_id);
    void deleteThemePost(int theme_post_id);
    void updateThemePost(int theme_post_id, String theme_post_title,String theme_post_profile, int illness_id,int illness_type_id);

    // SubPost
    int getSubPostNumber(int theme_post_id);
    List<SubPost> getSubPostInformation(int theme_post_id, int page_index);
    void insertSubPost(int theme_post_id, String user_id, String sub_post_content);
    void deleteSubPost(int sub_post_id);
    List<SubPostRecord> getUserSubPostInformation(String user_id);


    // Comment
    void insertComment(int sub_post_id, String user_id, String comment_content);
    void deleteComment(int comment_id);
    int getCommentNumber(int sub_post_id);
    List<Comment> getCommentInformation(int sub_post_id);
    List<CommentRecord> getUserCommentInformation(String user_id);


    // Area
    String getAreaInformation();

    //FindDoctor
    List<DoctorInformation> getDoctorInformation();
    void updateDoctorQualification(String user_id,String real_name,String position,String telephone,String department);
    void insertDoctorQualification(String user_id,String real_name,String position,String telephone,String department);
    String getDoctorQualificationImage(String file_name);
    DoctorInformation getUserDoctorInformation(String user_id);
}
