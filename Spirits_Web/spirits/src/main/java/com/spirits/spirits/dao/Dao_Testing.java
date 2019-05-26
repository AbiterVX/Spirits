package com.spirits.spirits.dao;

import com.spirits.spirits.dao.Entity.TestingInformation;
import com.spirits.spirits.dao.Entity.TestingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
public interface Dao_Testing {

    @Select("select testing_id,illness_name,illness_type_name,testing_profile,posting_time,testing_number from \n" +
            "   (\n" +
            "       select *,ROW_NUMBER() over\n" +
            "       (\n" +
            "           order by \n" +
            "           testing_number desc\n" +
            "       ) row_index\n" +
            "       from t_testing\n" +
            "       where illness_type_id=#{illness_type}\n" +
            "   )\n" +
            "results,t_illness,t_illness_type\n" +
            "where results.row_index>#{page_index}\n" +
            "and results.row_index<=#{next_page_index}\n" +
            "and results.illness_id=t_illness.illness_id\n" +
            "and results.illness_type_id=t_illness_type.illness_type_id")
    List<TestingInformation> getTestingInformation(@Param("illness_type")int illness_type,
                                                   @Param("page_index")int page_index,
                                                   @Param("next_page_index")int next_page_index);

    @Select("select testing_id,illness_name,illness_type_name,testing_profile,posting_time,testing_number from \n" +
            "   (\n" +
            "       select *,ROW_NUMBER() over\n" +
            "       (\n" +
            "           order by \n" +
            "           testing_number desc\n" +
            "       ) row_index\n" +
            "       from t_testing\n" +
            "   )\n" +
            "results,t_illness,t_illness_type\n" +
            "where results.row_index>#{page_index}\n" +
            "and results.row_index<=#{next_page_index}\n" +
            "and results.illness_id=t_illness.illness_id\n" +
            "and results.illness_type_id=t_illness_type.illness_type_id")
    List<TestingInformation> getTestingInformation_All(@Param("page_index")int page_index,
                                                       @Param("next_page_index")int next_page_index);
    @Select("select count(*) \n" +
            "from t_testing \n" +
            "where illness_type_id=#{illness_type}")
    int getMaxPageIndex(@Param("illness_type")int illness_type);

    @Select("select count(*) \n" +
            "from t_testing")
    int getMaxPageIndex_All();

    @Select("insert into t_testing_record(testing_id,user_id,testing_result) \n" +
            "values(#{testing_id},#{user_id},#{testing_result})\n" +
            "update t_testing set testing_number+=1 where testing_id=#{testing_id}")
    void insertTestingResult(@Param("testing_id")int testing_id,
                             @Param("user_id")String user_id, @Param("testing_result")String testing_result);


    @Select("select testing_record_id,t_testing_record.testing_id,illness_name,illness_type_name,testing_profile,testing_result\n" +
            "from t_testing,t_testing_record,t_illness,t_illness_type\n" +
            "where t_testing_record.user_id=#{user_id} and t_testing_record.testing_id=t_testing.testing_id\n" +
            "and t_testing.illness_id=t_illness.illness_id and t_testing.illness_type_id=t_illness_type.illness_type_id")
    List<TestingRecord> getTestingRecordInformation(@Param("user_id")String user_id);


    @Select("delete from t_testing_record \n" +
            "where testing_record_id=#{testing_record_id}")
    void deleteTestingRecordInformation(@Param("testing_record_id")int testing_record_id);
}
