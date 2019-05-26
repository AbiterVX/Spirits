package com.spirits.spirits.dao;


import com.spirits.spirits.dao.Entity.DoctorInformation;
import com.spirits.spirits.dao.Entity.User;
import com.spirits.spirits.dao.Entity.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
public interface Dao_User {
    // user
    @Select("Declare @u_id varchar(20)\n" +
            "exec p_getId  @current_ID=@u_id output\n" +
            "Insert into t_user values(@u_id,#{user_name},#{user_password},1)\n" +
            "Insert into t_user_information values(@u_id,0,0,0,0,0,0)\n"+
            "select @u_id")
    String signUp(@Param("user_name") String user_name, @Param("user_password") String user_password);

    @Select("select *\n" +
            "from t_user\n" +
            "where user_id=#{user_id} and user_password=#{user_password}")
    User signIn(@Param("user_id") String user_id, @Param("user_password") String user_password);

    @Select("select *\n" +
            "from t_user")
    List<User> getUsers();


    @Select("select t_user.user_id,user_name,user_type,age,sex,province,city,area\n" +
            " from t_user,t_user_information\n" +
            " where t_user.user_id=#{user_id} and t_user.user_id=t_user_information.user_id  \n" +
            " COLLATE Chinese_PRC_CI_AI_WS")
    UserInformation getUserInformation(@Param("user_id") String user_id);


    @Select("update t_user_information \n" +
            "set age=#{user_age},\n" +
            "sex=#{user_sex},\n" +
            "province=#{user_province},\n" +
            "city=#{user_city},\n" +
            "area=#{user_area}\n"+
            "where user_id=#{user_id}\n"+
            "update t_user\n" +
            "set user_name=#{user_name} where user_id=#{user_id}")
    void updateUserInformation(@Param("user_age") String user_age,
                               @Param("user_sex") int user_sex,
                               @Param("user_province") int user_province,
                               @Param("user_city") int user_city,
                               @Param("user_area") int user_area,
                               @Param("user_id") String user_id,
                               @Param("user_name") String user_name);

    @Select("update t_user\n" +
            "set user_password=#{user_password}\n" +
            "where user_id=#{user_id}")
    void updateUserPassword(@Param("user_id") String user_id, @Param("user_password") String user_password);

    @Select("select user_name from t_user where user_id=#{user_id}")
    String getUserName(@Param("user_id") String user_id);


    // user information
    /*





    // Administrators
    DoctorInformation[] getQualifiedDoctors(@Param("page_index") int page_index);
    DoctorInformation[] getUnQualifiedDoctors(@Param("page_index") int page_index);
*/
    // community bbs
}
