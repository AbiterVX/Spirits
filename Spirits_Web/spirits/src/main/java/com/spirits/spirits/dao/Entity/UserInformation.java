package com.spirits.spirits.dao.Entity;

public class UserInformation {
    private String user_id;
    private String user_name;
    private int user_type;
    private int age;
    private int sex;
    private int province;
    private int city;
    private int area;

    public UserInformation(String user_id, String user_name, Integer user_type, Integer age, Integer sex, Integer province, Integer city, Integer area) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_type = user_type;
        this.age = age;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.area = area;
    }

    // getter
    public String getUser_id() {
        return user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public int getUser_type() {
        return user_type;
    }
    public int getAge() {
        return age;
    }
    public int getSex() {
        return sex;
    }
    public int getProvince() {
        return province;
    }
    public int getCity() {
        return city;
    }
    public int getArea() {
        return area;
    }

    // tostring
    @Override
    public String toString() {
        return "UserInformation{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_type=" + user_type +
                ", age=" + age +
                ", sex=" + sex +
                ", province=" + province +
                ", city=" + city +
                ", area=" + area +
                '}';
    }
}
