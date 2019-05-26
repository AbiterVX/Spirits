package com.spirits.spirits.dao;


import com.spirits.spirits.dao.Entity.DoctorInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Dao_Doctor {

    @Select("update t_doctor_information \n" +
            "set real_name=#{real_name},position=#{position},telephone=#{telephone},department=#{department},qualification_state=0\n" +
            "where user_id=#{user_id}")
    void updateDoctorQualification(@Param("user_id") String user_id, @Param("real_name") String real_name,
                                   @Param("position") String position, @Param("telephone") String telephone, @Param("department") String department);

    @Select("insert into t_doctor_information " +
            "values(#{user_id},#{real_name},#{position},#{telephone},#{department},0)")
    void insertDoctorQualification(@Param("user_id") String user_id, @Param("real_name") String real_name,
                                   @Param("position") String position, @Param("telephone") String telephone, @Param("department") String department);

    @Select("select t_doctor_information.*,province,city,area \n" +
            "from t_doctor_information,t_user_information\n" +
            "where qualification_state=1\n" +
            "and t_doctor_information.user_id=t_user_information.user_id\n" +
            "Collate SQL_Latin1_General_CP1_CI_AS")
    List<DoctorInformation> getDoctorInformation();

    @Select("select t_doctor_information.*,province,city,area \n" +
            "from t_doctor_information,t_user_information\n" +
            "where t_doctor_information.user_id=#{user_id} \n" +
            "and t_doctor_information.user_id=t_user_information.user_id\n" +
            "Collate SQL_Latin1_General_CP1_CI_AS")
    DoctorInformation getUserDoctorInformation(@Param("user_id") String user_id);
}





