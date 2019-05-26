package com.spirits.spirits;

import com.spirits.spirits.dao.Entity.Illness;
import com.spirits.spirits.dao.Entity.User;
import com.spirits.spirits.dao.Entity.UserInformation;
import com.spirits.spirits.service.Service_Implement;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiritsApplicationTests {
    @Autowired
    Service_Implement service_implement;

    @Test
    public void serviceHomePage(){
        System.out.println("测试：serviceHomePage");
        //查询全部疾病信息
        Assert.assertEquals(12,service_implement.getAllIllnessInformation().size());
        //查询部分疾病信息
        Assert.assertEquals(3,service_implement.getIllnessInformation(1).size());
        Assert.assertEquals(3,service_implement.getIllnessInformation(2).size());
        Assert.assertEquals(3,service_implement.getIllnessInformation(3).size());
        Assert.assertEquals(3,service_implement.getIllnessInformation(4).size());
        System.out.println("测试结束：serviceHomePage");
    }
    @Test
    public void serviceUser(){
        System.out.println("测试：serviceUser");
        // 注册
        //service_implement.signUp("VX","123");

        //登录
        Assert.assertEquals(new User("1","AbiterVX","123",10).toString(),
                            service_implement.signIn("1","123").toString());
        Assert.assertEquals(null,
                            service_implement.signIn("1","111"));
        Assert.assertEquals(null,
                            service_implement.signIn("11","1234"));

        //信息
        Assert.assertEquals(new UserInformation("1","AbiterVX",2,0,0,2,1,1).toString(),
                            service_implement.getUserInformation("1").toString());

        //更新用户信息
        //更新用户密码
        //得到用户名
        Assert.assertEquals("AbiterVX",service_implement.getUserName("1"));

        System.out.println("测试结束：serviceUser");
    }
    @Test
    public void serviceFile(){
        //下载文件
        //上传文件
    }
    @Test
    public void serviceTesting(){
        System.out.println("测试：serviceTesting");
        //得到题目信息
        Assert.assertEquals("心理疾病测试题目，来自于瑞文网",service_implement.getTestingInformation(0,1).get(0).getTesting_profile());
        //得到题目页数
        Assert.assertEquals(2,service_implement.getMaxPageIndex(0));
        Assert.assertEquals(1,service_implement.getMaxPageIndex(1));
        //得到题目结果
        //插入自检记录
        //得到自检记录
        //删除自检记录
        System.out.println("测试结束：serviceTesting");
    }
    @Test
    public void serviceFindDoctor(){
        System.out.println("测试：serviceFindDoctor");
        //得到医生信息
        //更新医生认证信息
        //插入医生认证信息
        //得到医生认证图片
        //得到医生用户信息
        System.out.println("测试结束：serviceFindDoctor");
    }
    @Test
    public void serviceCommunity(){
        System.out.println("测试：serviceCommunity");
        //得到主题帖信息
        //得到主题帖页数
        Assert.assertEquals(2,service_implement.getThemePostMaxPageIndex(0));
        //得到用户主题帖记录
        //插入主题帖
        //删除主题帖
        //更新主题帖

        //得到子贴页数
        Assert.assertEquals(2,service_implement.getSubPostNumber(3));
        //得到子贴信息
        //插入子贴
        //删除子贴
        //得到用户子贴记录

        //插入评论
        //删除评论
        //得到评论数
        Assert.assertEquals(3,service_implement.getCommentNumber(4));
        //得到评论信息
        //得到评论记录
        System.out.println("测试结束：serviceCommunity");
    }
    @Test
    public void area(){
        //得到用户地区信息
    }
    @Test
    public void Doctor(){

    }
}
