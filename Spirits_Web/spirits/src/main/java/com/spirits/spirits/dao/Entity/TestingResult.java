package com.spirits.spirits.dao.Entity;

public class TestingResult {
    private int start;
    private int end;
    private String diagnosis;

    public TestingResult(int start, int end, String diagnosis) {
        this.start = start;
        this.end = end;
        this.diagnosis = diagnosis;
    }

    // getter
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    public String getDiagnosis() {
        return diagnosis;
    }

    // tostring
    @Override
    public String toString() {
        return "TestingResult{" +
                "start=" + start +
                ", end=" + end +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
