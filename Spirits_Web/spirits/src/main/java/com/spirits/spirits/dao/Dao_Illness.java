package com.spirits.spirits.dao;

import com.spirits.spirits.dao.Entity.Illness;
import com.spirits.spirits.dao.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Dao_Illness {
    @Select("select t_illness.illness_name,t_illness_type.illness_type_name,t_illness_information.illness_profile \n" +
            "from t_illness_information\n" +
            "left JOIN t_illness ON t_illness_information.illness_id=t_illness.illness_id\n" +
            "left Join t_illness_type on t_illness_information.illness_type_id=t_illness_type.illness_type_id\n")
    List<Illness> getAllIllnessInformation();


    @Select("select t_illness.illness_name,t_illness_type.illness_type_name,t_illness_information.illness_profile \n" +
            "from t_illness_information\n" +
            "left JOIN t_illness ON t_illness_information.illness_id=t_illness.illness_id\n" +
            "left Join t_illness_type on t_illness_information.illness_type_id=t_illness_type.illness_type_id\n" +
            "where t_illness_information.illness_type_id=#{illness_type}")
    List<Illness> getIllnessInformation(@Param("illness_type") int illness_type);

}
