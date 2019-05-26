package com.spirits.spirits.controller;

import com.spirits.spirits.dao.Entity.Question;
import com.spirits.spirits.dao.Entity.TestingInformation;
import com.spirits.spirits.dao.Entity.TestingRecord;
import com.spirits.spirits.dao.Entity.TestingResult;
import com.spirits.spirits.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
public class Controller_Testing {
    @Autowired
    Service service_implement;

    // 1.自检界面
    @RequestMapping(value="/Testing",method = RequestMethod.GET)
    public String get_Testing(){
        return "html/Testing.html";
    }

    // 2.答题界面
    @RequestMapping(value="/DoTest",method = RequestMethod.GET)
    public String get_DoTest(){
        return "html/DoTest.html";
    }


    // 3.自检界面选择题目
    @ResponseBody
    @RequestMapping(value = "/Testing/getTestingInformation", method = RequestMethod.POST)
    public List<TestingInformation> post_getTestingInformation(@RequestBody Map<String, Integer> map){
        int illness_type=map.get("illness_type");
        int page_index=map.get("page_index");
        List<TestingInformation> testing_information = service_implement.getTestingInformation(illness_type, page_index);
        //System.out.println(testing_information);
        //Map<String,String> result=new Hashtable<>();
        return testing_information;
    }

    @ResponseBody
    @RequestMapping(value = "/Testing/getMaxPageIndex", method = RequestMethod.POST)
    public int post_getMaxPageIndex(@RequestBody Map<String, Integer> map){
        int illness_type=map.get("illness_type");
        return service_implement.getMaxPageIndex(illness_type);
    }

    // 4.获取具体自检题目
    @ResponseBody
    @RequestMapping(value = "/Testing/getTestingQuestions", method = RequestMethod.POST)
    public List<Question> post_getTestingQuestions(@RequestBody Map<String, Integer> map){
        String testing_id=String.valueOf(map.get("testing_id"));
        return service_implement.getTestingQuestions(testing_id);
    }

    // 5.获取题目结果
    @ResponseBody
    @RequestMapping(value = "/Testing/getTestingResult", method = RequestMethod.POST)
    public Map<String, String> post_getTestingResult(@RequestBody Map<String, String> map){
        int testing_id=Integer.valueOf(map.get("testing_id"));
        int score=Integer.valueOf(map.get("score"));
        String user_id=map.get("user_id");
        String testing_result=service_implement.getTestingResult(String.valueOf(testing_id),score);
        service_implement.insertTestingResult(testing_id,user_id,testing_result);
        Map<String, String> result=new HashMap<>();
        result.put("diagnosis",testing_result);
        return result;
    }


    // 5.获取测试记录信息
    @ResponseBody
    @RequestMapping(value = "/Testing/getTestingRecordInformation", method = RequestMethod.POST)
    public List<TestingRecord> post_getTestingRecordInformation(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        return service_implement.getTestingRecordInformation(user_id);
    }

    // 6.删除测试记录信息
    @ResponseBody
    @RequestMapping(value = "/Testing/deleteTestingRecordInformation", method = RequestMethod.POST)
    public void post_deleteTestingRecordInformation(@RequestBody Map<String, Integer> map){
        int user_id=map.get("testing_record_id");
        service_implement.deleteTestingRecordInformation(user_id);
    }


}
