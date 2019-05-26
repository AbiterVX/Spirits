package com.spirits.spirits.controller;

import com.spirits.spirits.dao.Entity.Illness;
import com.spirits.spirits.dao.Entity.User;
import com.spirits.spirits.dao.Entity.UserInformation;
import com.spirits.spirits.service.Service;
import com.spirits.spirits.service.Service_Implement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


@Controller
public class Controller_User {
    @Autowired
    Service service_implement;

    // 1.访问登录界面
    @RequestMapping(value="/SignIn",method = RequestMethod.GET)
    public String get_SignIn(){
        return "html/SignIn.html";
    }

    // 2.登录
    @ResponseBody
    @RequestMapping(value = "/SignIn/request", method = RequestMethod.POST)
    public Map<String, String> post_SignIn(@RequestBody Map<String, String> map){
        //System.out.println(map);
        String id=map.get("id");
        String password=map.get("password");

        User user=service_implement.signIn(id,password);
        Map<String, String> result=new HashMap<>();
        result.put("user_id",user.getUser_id());
        result.put("user_name",user.getUser_name());
        result.put("user_password",user.getUser_password());
        result.put("user_level",String.valueOf(user.getUser_level()));
        return result;
    }

    // 3.访问注册界面
    @RequestMapping(value="/SignUp",method = RequestMethod.GET)
    public String get_SignUp(){
        return "html/SignUp.html";
    }

    // 4.注册
    @ResponseBody
    @RequestMapping(value = "/SignUp/request", method = RequestMethod.POST)
    public Map<String, String> post_SignUp(@RequestBody Map<String, String> map){
        String user_name=map.get("user_name");
        String password=map.get("password");
        String id=service_implement.signUp(user_name,password);
        Map<String, String> result=new HashMap<>();
        result.put("user_id",id);
        return result;
    }

    // 5.访问个人空间界面
    @RequestMapping(value="/MySpace",method = RequestMethod.GET)
    public String get_MySpace(){
        return "html/MySpace.html";
    }

    // 6.得到用户个人信息
    @ResponseBody
    @RequestMapping(value = "/MySpace/request", method = RequestMethod.POST)
    public Map<String, String> post_MySpace(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        //System.out.println(user_id);
        UserInformation userInformation=service_implement.getUserInformation(user_id);
        Map<String, String> result=new HashMap<>();
        result.put("user_name",userInformation.getUser_name());
        result.put("user_sex",String.valueOf(userInformation.getSex()));
        result.put("user_age",String.valueOf(userInformation.getAge()));
        result.put("user_province",String.valueOf(userInformation.getProvince()));
        result.put("user_city",String.valueOf(userInformation.getCity()));
        result.put("user_area",String.valueOf(userInformation.getArea()));
        result.put("user_type",String.valueOf(userInformation.getUser_type()));
        return result;
    }

    // 7.修改用户个人信息
    @ResponseBody
    @RequestMapping(value = "/MySpace/post_updateUserInformation", method = RequestMethod.POST)
    public Map<String, String> post_updateUserInformation(@RequestBody Map<String, String> map){

        String user_age=map.get("user_age");
        int user_sex=Integer.valueOf(map.get("user_sex"));
        int user_province=Integer.valueOf(map.get("user_province"));
        int user_city=Integer.valueOf(map.get("user_city"));
        int user_area=Integer.valueOf(map.get("user_area"));
        String user_id=map.get("user_id");
        String user_name=map.get("user_name");

        service_implement.updateUserInformation(user_age,user_sex,user_province,user_city,user_area,user_id,user_name);

        //UserInformation userInformation=service_implement.getUserInformation(user_id);
        Map<String, String> result=new HashMap<>();
        result.put("result","1");
        return result;
    }

    // 8.修改用户密码
    @ResponseBody
    @RequestMapping(value = "/MySpace/updateUserPassword", method = RequestMethod.POST)
    public void post_updateUserPassword(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        String user_password=map.get("user_password");
        //System.out.println(map);
        service_implement.updateUserPassword(user_id,user_password);
        //return "1";
    }

    // 9.得到用户名
    @ResponseBody
    @RequestMapping(value = "/MySpace/getUserName", method = RequestMethod.POST)
    public Map<String, String> getUserName(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        //System.out.println(user_id);
        String user_name=service_implement.getUserName(user_id);
        Map<String, String> result=new Hashtable<>();
        result.put("user_name",user_name);
        //System.out.println(user_name);
        return result;
    }

    //  21.获得文件
    @ResponseBody
    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    public String post_downloadFile(@RequestBody String file_name){
        String data=service_implement.downloadFile(file_name);
        //System.out.println(file_name);
        data="{\"data\":\""+data+"\"}";
        //System.out.println(data);
        return data;
    }

    //  22.上传文件
    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String post_uploadFile(@RequestBody Map<String, String> map){
        String file_name=map.get("file_name");
        String uploadFile=map.get("data");
        //System.out.println(file_name);
        //System.out.println(uploadFile);
        service_implement.uploadFile(file_name,uploadFile);
        return "1";
    }



}
