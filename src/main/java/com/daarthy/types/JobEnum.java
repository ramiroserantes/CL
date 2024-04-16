package com.daarthy.types;

import java.util.ArrayList;
import java.util.List;

public enum JobEnum {

    BUILDER("Builder"),
    DIGGER("Digger"),
    FISHERMAN("FisherMan"),
    HUNTER("Hunter"),
    MINER("Miner"),
    WOODCUTTER("WoodCutter"),
    RUNESMITH("RuneSmith"),
    FARMER("Farmer"),

    ECONOMY("Economy"),
    DEVELOPMENT("Development"),
    MILITARY("Military"),
    ALL("All");

    private String jobName;

    JobEnum(String jobName) {
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }

    public static List<String> getAllJobNames() {

        List<String> jobNames = new ArrayList<>();
        for (JobEnum jobEnum : JobEnum.values()) {
            if (jobEnum != ALL && jobEnum != ECONOMY
                    && jobEnum != MILITARY
                    && jobEnum != DEVELOPMENT) {
                jobNames.add(jobEnum.getJobName());
            }
        }
        return jobNames;
    }


}
