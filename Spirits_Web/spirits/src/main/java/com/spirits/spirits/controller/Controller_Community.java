package com.spirits.spirits.controller;

import com.spirits.spirits.dao.Entity.*;
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
public class Controller_Community {
    @Autowired
    Service service_implement;

    @RequestMapping(value="/Community",method = RequestMethod.GET)
    public String get_HomePage(){
        return "html/Community.html";
    }
    @RequestMapping(value="Post",method = RequestMethod.GET)
    public String get_Post(){
        return "html/Post.html";
    }


    // 主题帖
    @ResponseBody
    @RequestMapping(value = "/Community/getThemePostInformation", method = RequestMethod.POST)
    public List<ThemePost> post_getThemePostInformation(@RequestBody Map<String, Integer> map){
        int illness_type=map.get("illness_type");
        int page_index=map.get("page_index");
        List<ThemePost> themePostInformation=service_implement.getThemePostInformation(illness_type,page_index);
        //System.out.println(themePostInformation);
        return themePostInformation;
    }

    @ResponseBody
    @RequestMapping(value = "/Community/getThemePostMaxPageIndex", method = RequestMethod.POST)
    public int post_getThemePostMaxPageIndex(@RequestBody Map<String, Integer> map){
        int illness_type=map.get("illness_type");
        return service_implement.getThemePostMaxPageIndex(illness_type);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/insertThemePost", method = RequestMethod.POST)
    public void post_insertThemePost(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        String theme_post_title=map.get("theme_post_title");
        String theme_post_profile=map.get("theme_post_profile");
        int illness_id=Integer.valueOf(map.get("illness_id"));
        int illness_type_id=Integer.valueOf(map.get("illness_type_id"));
        service_implement.insertThemePost(user_id,theme_post_title,theme_post_profile,illness_id,illness_type_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/deleteThemePost", method = RequestMethod.POST)
    public void post_deleteThemePost(@RequestBody Map<String, Integer> map){
        int theme_post_id=map.get("theme_post_id");
        service_implement.deleteThemePost(theme_post_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/updateThemePost", method = RequestMethod.POST)
    public void post_updateThemePost(@RequestBody Map<String, String> map){
        //System.out.println(map);
        int theme_post_id=Integer.valueOf(map.get("theme_post_id"));
        String theme_post_title=map.get("theme_post_title");
        String theme_post_profile=map.get("theme_post_profile");
        int illness_id=Integer.valueOf(map.get("illness_id"));
        int illness_type_id=Integer.valueOf(map.get("illness_type_id"));
        service_implement.updateThemePost(theme_post_id,theme_post_title,theme_post_profile,illness_id,illness_type_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/getUserThemePostInformation", method = RequestMethod.POST)
    public List<ThemePostRecord> post_getUserThemePostInformation(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        return service_implement.getUserThemePostInformation(user_id);
    }



    //子贴
    @ResponseBody
    @RequestMapping(value = "/Community/getSubPostNumber", method = RequestMethod.POST)
    public int post_getSubPostNumber(@RequestBody Map<String, Integer> map){
        int theme_post_id=map.get("theme_post_id");
        return service_implement.getSubPostNumber(theme_post_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/getSubPostInformation", method = RequestMethod.POST)
    public List<SubPost> post_getSubPostInformation(@RequestBody Map<String, Integer> map){
        int theme_post_id=map.get("theme_post_id");
        int page_index=map.get("page_index");
        return service_implement.getSubPostInformation(theme_post_id,page_index);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/insertSubPost", method = RequestMethod.POST)
    public void post_insertSubPost(@RequestBody Map<String, String> map){
        int theme_post_id=Integer.valueOf(map.get("theme_post_id"));
        String user_id=map.get("user_id");
        String sub_post_content=map.get("sub_post_content");
        service_implement.insertSubPost(theme_post_id,user_id,sub_post_content);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/deleteSubPost", method = RequestMethod.POST)
    public void post_deleteSubPost(@RequestBody Map<String, Integer> map){
        Integer sub_post_id=map.get("sub_post_id");
        service_implement.deleteSubPost(sub_post_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/getUserSubPostInformation", method = RequestMethod.POST)
    public List<SubPostRecord> post_getUserSubPostInformation(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        return service_implement.getUserSubPostInformation(user_id);
    }

    //评论
    @ResponseBody
    @RequestMapping(value = "/Community/insertComment", method = RequestMethod.POST)
    public void post_insertComment(@RequestBody Map<String, String> map){
        int sub_post_id=Integer.valueOf(map.get("sub_post_id"));
        String user_id=map.get("user_id");
        String comment_content=map.get("comment_content");
        service_implement.insertComment(sub_post_id,user_id,comment_content);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/deleteComment", method = RequestMethod.POST)
    public void post_deleteComment(@RequestBody Map<String, Integer> map){
        int comment_id=map.get("comment_id");
        service_implement.deleteComment(comment_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/getCommentNumber", method = RequestMethod.POST)
    public int post_getCommentNumber(@RequestBody Map<String, Integer> map){
        int sub_post_id=map.get("sub_post_id");
        return service_implement.getCommentNumber(sub_post_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/getCommentInformation", method = RequestMethod.POST)
    public List<Comment> post_getCommentInformation(@RequestBody Map<String, Integer> map){
        int sub_post_id=map.get("sub_post_id");
        return service_implement.getCommentInformation(sub_post_id);
    }

    @ResponseBody
    @RequestMapping(value = "/Community/getUserCommentInformation", method = RequestMethod.POST)
    public List<CommentRecord> post_getUserCommentInformation(@RequestBody Map<String, String> map){
        String user_id=map.get("user_id");
        return service_implement.getUserCommentInformation(user_id);
    }





}
