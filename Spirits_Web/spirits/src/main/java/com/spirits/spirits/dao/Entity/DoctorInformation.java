package com.spirits.spirits.dao.Entity;

public class DoctorInformation {
    private String user_id;
    private String real_name;
    private String position;
    private String telephone;
    private String department;
    private int qualification_state;

    private int province;
    private int city;
    private int area;

    public DoctorInformation(String user_id, String real_name,
                             String position, String telephone, String department,
                             Integer qualification_state,
                             Integer province, Integer city, Integer area) {
        this.user_id = user_id;
        this.real_name = real_name;
        this.position = position;
        this.telephone = telephone;
        this.department = department;
        this.qualification_state = qualification_state;
        this.province = province;
        this.city = city;
        this.area = area;
    }

    // getter
    public String getUser_id() {
        return user_id;
    }
    public String getReal_name() {
        return real_name;
    }
    public String getPosition() {
        return position;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getDepartment() {
        return department;
    }
    public int getQualification_state() {
        return qualification_state;
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
        return "DoctorInformation{" +
                "user_id='" + user_id + '\'' +
                ", real_name='" + real_name + '\'' +
                ", position='" + position + '\'' +
                ", telephone='" + telephone + '\'' +
                ", department='" + department + '\'' +
                ", qualification_state=" + qualification_state +
                ", province=" + province +
                ", city=" + city +
                ", area=" + area +
                '}';
    }



}
