package com.spirits.spirits.dao.Entity;

public class Illness {
    private String illness_name;
    private String illness_type_name;
    private String illness_profile;
    public Illness(){

    }
    public Illness(Illness illness){
        this.illness_name = illness.illness_name;
        this.illness_type_name = illness.illness_type_name;
        this.illness_profile = illness.illness_profile;
    }
    public Illness(String illness_name, String illness_type_name, String illness_profile) {
        this.illness_name = illness_name;
        this.illness_type_name = illness_type_name;
        this.illness_profile = illness_profile;
    }
    // getter
    public String getIllness_name() {
        return illness_name;
    }
    public String getIllness_type_name() {
        return illness_type_name;
    }
    public String getIllness_profile() {
        return illness_profile;
    }

    // setter


    public void setIllness_name(String illness_name) {
        this.illness_name = illness_name;
    }

    public void setIllness_type_name(String illness_type_name) {
        this.illness_type_name = illness_type_name;
    }

    public void setIllness_profile(String illness_profile) {
        this.illness_profile = illness_profile;
    }

    // tostring
    @Override
    public String toString() {
        return "Illness{" +
                "illness_name='" + illness_name + '\'' +
                ", illness_type_name='" + illness_type_name + '\'' +
                ", illness_profile='" + illness_profile + '\'' +
                '}';
    }
}
