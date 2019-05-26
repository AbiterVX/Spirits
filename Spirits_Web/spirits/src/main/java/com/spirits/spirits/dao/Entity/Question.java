package com.spirits.spirits.dao.Entity;

import java.util.ArrayList;

public class Question {
    private String description;
    private ArrayList<String> options;
    private ArrayList<String> scores;

    public Question() {
        options=new ArrayList<String>();
        scores=new ArrayList<String>();
    }

    // setter
    public void setDescription(String description) {
        this.description = description;
    }
    public void setScores(String option,Integer option_score) {
        options.add(option);
        scores.add(String.valueOf(option_score));
    }


    // getter
    public String getDescription() {
        return description;
    }
    public ArrayList<String> getOptions() {
        return options;
    }
    public ArrayList<String> getScores() {
        return scores;
    }

    // toString
    @Override
    public String toString() {
        return "Question{" +
                "description='" + description + '\'' +
                ", options=" + options +
                ", scores=" + scores +
                '}';
    }
}
