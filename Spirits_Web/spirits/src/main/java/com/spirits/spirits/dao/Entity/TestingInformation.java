package com.spirits.spirits.dao.Entity;

import java.sql.Timestamp;

public class TestingInformation {
    private int testing_id;
    private String illness_name;
    private String illness_type_name;
    private String testing_profile;
    private String posting_time;
    private int testing_number;

    public TestingInformation(Integer testing_id, String illness_name, String illness_type_name, String testing_profile, Timestamp posting_time, Integer testing_number) {
            this.testing_id = testing_id;
        this.illness_name = illness_name;
        this.illness_type_name = illness_type_name;
        this.testing_profile = testing_profile;
        this.posting_time = posting_time.toString();
        this.testing_number = testing_number;
    }

    // getter
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
    public String getPosting_time() {
        return posting_time;
    }
    public int getTesting_number() {
        return testing_number;
    }

    // tostring

    @Override
    public String toString() {
        return "TestingInformation{" +
                "testing_id=" + testing_id +
                ", illness_name='" + illness_name + '\'' +
                ", illness_type_name='" + illness_type_name + '\'' +
                ", testing_profile='" + testing_profile + '\'' +
                ", posting_time='" + posting_time + '\'' +
                ", testing_number=" + testing_number +
                '}';
    }
}
