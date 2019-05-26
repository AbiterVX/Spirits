package com.spirits.spirits.service;

import com.spirits.spirits.dao.*;
import com.spirits.spirits.dao.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class Service_Implement implements com.spirits.spirits.service.Service {
    //private final String data_file_path="G:/GitRepository/data/";
    private final String data_file_path="/AbiterVX_APP/Spirits/data/";

    private final String file_encoding = "GB2312";

    //  DAO
    @Autowired
    private Dao_User dao_User;
    @Autowired
    private Dao_Illness dao_Illness;
    @Autowired
    private Dao_Testing dao_testing;
    @Autowired
    private Dao_Community dao_community;
    @Autowired
    private Dao_Doctor dao_doctor;

    // 登录与注册
    @Override
    public String signUp(String user_name, String user_password) {
        return dao_User.signUp(user_name,user_password);
    }
    @Override
    public User signIn(String user_id, String user_password) {
        return dao_User.signIn(user_id,user_password);
    }

    // 上传与下载文件
    public String downloadFile(String file_name){
        File file = new File(data_file_path+file_name);
        if(!file.exists()){
            return "";
        }
        Long file_length = file.length();
        byte[] content = new byte[file_length.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(content);
            in.close();
            String result=new String(content, file_encoding);
            return result;
        } catch (Exception e) {
            System.out.println("Wrong! : downloadFile ");
            //e.printStackTrace();
            return "";
        }
    }
    public void uploadFile(String file_name,String data){
        try {
            File file = new File(data_file_path+file_name);
            file.createNewFile();
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter((file)));
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Wrong! : uploadFile ");
        }
    }

    // 疾病信息
    @Override
    public List<Illness> getAllIllnessInformation() {
        List<Illness> result=dao_Illness.getAllIllnessInformation();
        for(int i=0;i<result.size();i++){
            result.get(i).setIllness_profile(downloadFile(result.get(i).getIllness_profile()));
        }
        return result;
    }
    @Override
    public List<Illness> getIllnessInformation(int illness_type) {
        List<Illness> result=dao_Illness.getIllnessInformation(illness_type);
        for(int i=0;i<result.size();i++){
            result.get(i).setIllness_profile(downloadFile(result.get(i).getIllness_profile()));
        }
        return result;
    }

    // 用户信息
    @Override
    public UserInformation getUserInformation(String user_id) {
        UserInformation userInformation=dao_User.getUserInformation(user_id);
        return userInformation;
    }
    @Override
    public void updateUserInformation(String user_age, int user_sex, int user_province, int user_city,int user_area, String user_id, String user_name) {
        dao_User.updateUserInformation(user_age,user_sex,user_province,user_city,user_area,user_id,user_name);
    }
    @Override
    public void updateUserPassword(String user_id, String user_password) {
        dao_User.updateUserPassword(user_id,user_password);
    }
    @Override
    public String getUserName(String user_id) {
        return dao_User.getUserName(user_id);
    }


    // 答题信息
    private final int each_page_count=5;
    @Override
    public List<TestingInformation> getTestingInformation(int illness_type, int page_index) {
        int start_row=(page_index-1)*each_page_count;
        int end_row=page_index*each_page_count;
        if(illness_type==0){
            return dao_testing.getTestingInformation_All(start_row,end_row);
        }
        else{
            return dao_testing.getTestingInformation(illness_type,start_row,end_row);
        }
    }
    @Override
    public int getMaxPageIndex(int illness_type) {
        int row_count,index_count;
        if(illness_type==0){
            row_count= dao_testing.getMaxPageIndex_All();
        }
        else{
            row_count=dao_testing.getMaxPageIndex(illness_type);
        }

        if(row_count%each_page_count==0){
            index_count=row_count/each_page_count;
        }
        else{
            index_count=row_count/each_page_count+1;
        }
        System.out.println(index_count);
        return index_count;
    }



    // 具体题目
    @Override
    public List<Question> getTestingQuestions(String testing_id){
        //System.out.println(data_file_path+"testing/"+testing_id+"_questions.txt");
        File file = new File(data_file_path+"testing/"+testing_id+"_questions.txt");
        List<Question> result=new ArrayList<Question>();
        if(!file.exists()){
            return result;
        }
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), file_encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            Question new_question=null;
            String eachline = null;
            while(true){
                eachline=bufferedReader.readLine();
                if(eachline==null){
                    break;
                }
                //System.out.println();
                if(65<=eachline.charAt(0) && eachline.charAt(0)<=90){
                    String[] option=eachline.split(" ");
                    new_question.setScores(option[0],Integer.valueOf(option[1]));
                }
                else{
                    if(new_question!=null){
                        result.add(new_question);
                    }
                    new_question=new Question();
                    new_question.setDescription(eachline);
                }
            }

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Wrong! : getTestingQuestions ");
        }
        return result;
    }
    @Override
    public String getTestingResult(String testing_id,int score) {
        File file = new File(data_file_path+"testing/"+testing_id+"_result.txt");
        String result="";
        if(!file.exists()){
            return result;
        }
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), file_encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String eachline = null;
            int start_score=0;
            int end_score;
            while(true){
                eachline=bufferedReader.readLine();
                if(eachline==null){
                    break;
                }
                String[] option=eachline.split(" ");
                if(start_score<score && score<=Integer.valueOf(option[0])){
                    result=option[1];
                    break;
                }
                else{
                    start_score=Integer.valueOf(option[0]);
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Wrong! : getTestingResult ");
        }
        return result;
    }
    @Override
    public void insertTestingResult(int testing_id, String user_id, String testing_result) {
        dao_testing.insertTestingResult(testing_id,user_id,testing_result);
    }
    @Override
    public List<TestingRecord> getTestingRecordInformation(String user_id) {
        return dao_testing.getTestingRecordInformation(user_id);
    }
    @Override
    public void deleteTestingRecordInformation(int testing_record_id) {
        dao_testing.deleteTestingRecordInformation(testing_record_id);
    }


    // 主题帖信息
    private final int each_page_count_ThemePost=5;
    @Override
    public List<ThemePost> getThemePostInformation(int illness_type, int page_index) {
        int start_row=(page_index-1)*each_page_count_ThemePost;
        int end_row=page_index*each_page_count_ThemePost;
        if(illness_type==0){
            return dao_community.getThemePostInformation_All(start_row,end_row);
        }
        else{
            return dao_community.getThemePostInformation(illness_type,start_row,end_row);
        }
    }
    @Override
    public int getThemePostMaxPageIndex(int illness_type) {
        int row_count,index_count;
        if(illness_type==0){
            row_count= dao_community.getThemePostMaxPageIndex_All();
        }
        else{
            row_count=dao_community.getThemePostMaxPageIndex(illness_type);
        }

        if(row_count%each_page_count_ThemePost==0){
            index_count=row_count/each_page_count_ThemePost;
        }
        else{
            index_count=row_count/each_page_count_ThemePost+1;
        }
        //System.out.println(index_count);
        return index_count;
    }
    @Override
    public List<ThemePostRecord> getUserThemePostInformation(String user_id) {
        List<ThemePostRecord> result=dao_community.getUserThemePostInformation(user_id);
        //System.out.println(result);
        return result;
    }
    @Override
    public void insertThemePost(String user_id, String theme_post_title, String theme_post_profile, int illness_id, int illness_type_id) {
        dao_community.insertThemePost(user_id,theme_post_title,theme_post_profile,illness_id,illness_type_id);
    }
    @Override
    public void deleteThemePost(int theme_post_id) {
        dao_community.deleteThemePost(theme_post_id);
    }
    @Override
    public void updateThemePost(int theme_post_id, String theme_post_title, String theme_post_profile, int illness_id, int illness_type_id) {
        dao_community.updateThemePost(theme_post_id,theme_post_title,theme_post_profile,illness_id,illness_type_id);
    }


    // 子贴信息
    private final int each_page_count_SubPost=5;
    @Override
    public int getSubPostNumber(int theme_post_id) {
        int row_count=dao_community.getSubPostNumber(theme_post_id);
        int index_count=row_count/each_page_count_SubPost+1;
        return index_count;
    }
    @Override
    public List<SubPost> getSubPostInformation(int theme_post_id, int page_index) {
        int start_row=(page_index-1)*each_page_count_ThemePost;
        int end_row=page_index*each_page_count_ThemePost;
        return dao_community.getSubPostInformation(theme_post_id,start_row,end_row);
    }
    @Override
    public void insertSubPost(int theme_post_id, String user_id, String sub_post_content) {
        dao_community.insertSubPost(theme_post_id,user_id,sub_post_content);
    }
    @Override
    public void deleteSubPost(int sub_post_id) {
        dao_community.deleteSubPost(sub_post_id);
    }
    @Override
    public List<SubPostRecord> getUserSubPostInformation(String user_id) {
        return dao_community.getUserSubPostInformation(user_id);
    }


    //评论
    @Override
    public void insertComment(int sub_post_id, String user_id, String comment_content) {
        dao_community.insertComment(sub_post_id,user_id,comment_content);
    }
    @Override
    public void deleteComment(int comment_id) {
        dao_community.deleteComment(comment_id);
    }
    @Override
    public int getCommentNumber(int sub_post_id) {
        return dao_community.getCommentNumber(sub_post_id);
    }
    @Override
    public List<Comment> getCommentInformation(int sub_post_id) {
        return dao_community.getCommentInformation(sub_post_id);
    }
    @Override
    public List<CommentRecord> getUserCommentInformation(String user_id) {
        return dao_community.getUserCommentInformation(user_id);
    }



    // area
    @Override
    public String getAreaInformation() {
        return downloadFile("area/area_data.txt");
    }


    // find doctor
    @Override
    public List<DoctorInformation> getDoctorInformation() {
        return dao_doctor.getDoctorInformation();
    }
    @Override
    public void updateDoctorQualification(String user_id, String real_name, String position, String telephone, String department) {
        dao_doctor.updateDoctorQualification(user_id,real_name,position,telephone,department);
    }
    @Override
    public void insertDoctorQualification(String user_id, String real_name, String position, String telephone, String department) {
        dao_doctor.insertDoctorQualification(user_id,real_name,position,telephone,department);
    }
    @Override
    public String getDoctorQualificationImage(String file_name) {
        return downloadFile("doctor_qualification/"+file_name);
    }

    @Override
    public DoctorInformation getUserDoctorInformation(String user_id) {
        return dao_doctor.getUserDoctorInformation(user_id);
    }


}
