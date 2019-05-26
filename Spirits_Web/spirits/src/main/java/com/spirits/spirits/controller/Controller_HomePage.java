package com.spirits.spirits.controller;


import com.spirits.spirits.dao.Entity.Illness;
import com.spirits.spirits.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;


@Controller
public class Controller_HomePage {
    @Autowired
    Service service_implement;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String get_HomePage(){
        return "html/HomePage.html";
    }
    @RequestMapping(value="/HomePage",method = RequestMethod.GET)
    public String get_HomePage2(){
        return "html/HomePage.html";
    }

    @ResponseBody
    @RequestMapping(value = "/getIllnessInformation", method = RequestMethod.POST)
    public Map<String,String> post_getIllnessInformation(@RequestBody Map<String, Integer> map){
        int illness_type=map.get("illness_type");
        List<Illness> illnesses;
        if(illness_type==0){
            illnesses=service_implement.getAllIllnessInformation();
        }
        else{
            illnesses=service_implement.getIllnessInformation(illness_type);
        }
        Map<String,String> result=new Hashtable<>();
        result.put("number",String.valueOf(illnesses.size()));
        for(int i=0;i<illnesses.size();i++){
            result.put("profile_"+String.valueOf(i),illnesses.get(i).getIllness_profile());
            result.put("name_"+String.valueOf(i),illnesses.get(i).getIllness_name());
            result.put("type_"+String.valueOf(i),illnesses.get(i).getIllness_type_name());
        }
        //System.out.println(result);
        return result;
    }


}
