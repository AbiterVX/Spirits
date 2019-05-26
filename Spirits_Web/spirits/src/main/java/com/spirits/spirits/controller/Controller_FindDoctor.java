package com.spirits.spirits.controller;

import com.spirits.spirits.dao.Entity.DoctorInformation;
import com.spirits.spirits.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class Controller_FindDoctor {
    @Autowired
    Service service_implement;


    @RequestMapping(value="/FindDoctor",method = RequestMethod.GET)
    public String get_HomePage(){
        return "html/FindDoctor.html";
    }

    @RequestMapping(value="/DoctorQualification",method = RequestMethod.GET)
    public String get_DoctorQualification(){
        return "html/DoctorQualification.html";
    }



    // 1.选择地区
    @ResponseBody
    @RequestMapping(value = "/FindDoctor/getAreaInformation", method = RequestMethod.POST)
    public String post_getAreaInformation(@RequestBody Map<String, String> map){
        return service_implement.getAreaInformation();
    }

    // 2.getDoctorInformation
    @ResponseBody
    @RequestMapping(value = "/FindDoctor/getDoctorInformation", method = RequestMethod.POST)
    public List<DoctorInformation> post_getDoctorInformation(@RequestBody Map<String, String> map){
        return service_implement.getDoctorInformation();
    }

    // 3.updateDoctorQualification
    @ResponseBody
    @RequestMapping(value = "/FindDoctor/updateDoctorQualification", method = RequestMethod.POST)
    public void post_updateDoctorQualification(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        String real_name=map.get("real_name");
        String position=map.get("position");
        String telephone=map.get("telephone");
        String department=map.get("department");
        service_implement.updateDoctorQualification(user_id,real_name,position,telephone,department);
    }

    // 4.insertDoctorQualification
    @ResponseBody
    @RequestMapping(value = "/FindDoctor/insertDoctorQualification", method = RequestMethod.POST)
    public void post_insertDoctorQualification(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        String real_name=map.get("real_name");
        String position=map.get("position");
        String telephone=map.get("telephone");
        String department=map.get("department");
        service_implement.insertDoctorQualification(user_id,real_name,position,telephone,department);
    }

    @ResponseBody
    @RequestMapping(value = "/FindDoctor/getDoctorQualificationImage", method = RequestMethod.POST)
    public String post_getDoctorQualificationImage(@RequestBody Map<String, String> map){
        String file_name=map.get("file_name");
        String result=service_implement.getDoctorQualificationImage(file_name);
        //System.out.println("！！！！："+result);
        result="{\"data\":\""+result+"\"}";
        return result;
    }

    // 5. getUserDoctorInformation
    @ResponseBody
    @RequestMapping(value = "/FindDoctor/getUserDoctorInformation", method = RequestMethod.POST)
    public DoctorInformation getUserDoctorInformation(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        return service_implement.getUserDoctorInformation(user_id);
    }

}
