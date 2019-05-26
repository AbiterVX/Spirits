package com.spirits.spirits.dao.Entity;

public class TestingRecord {
    private int testing_record_id;
    private int testing_id;
    private String illness_name;
    private String illness_type_name;
    private String testing_profile;
    private String testing_result;

    public TestingRecord(Integer testing_record_id, Integer testing_id, String illness_name, String illness_type_name, String testing_profile, String testing_result) {
        this.testing_record_id = testing_record_id;
        this.testing_id = testing_id;
        this.illness_name = illness_name;
        this.illness_type_name = illness_type_name;
        this.testing_profile = testing_profile;
        this.testing_result = testing_result;
    }

    // getter
    public int getTesting_record_id() {
        return testing_record_id;
    }
    public int getTesting_id() {
        return testing_id;
    }
    public String getIllness_name() {
        return illness_name;
    }
    public String getIllness_type_name() {
        return illness_type_name;
    }
    public String getTesting_profile() {
        return testing_profile;
    }
    public String getTesting_result() {
        return testing_result;
    }

    // toString
    @Override
    public String toString() {
        return "TestingRecord{" +
                "testing_record_id=" + testing_record_id +
                ", testing_id=" + testing_id +
                ", illness_name='" + illness_name + '\'' +
                ", illness_type_name='" + illness_type_name + '\'' +
                ", testing_profile='" + testing_profile + '\'' +
                ", testing_result='" + testing_result + '\'' +
                '}';
    }
}
