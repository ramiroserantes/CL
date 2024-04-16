package com.daarthy.modules;

import com.daarthy.types.JobEnum;

import java.util.EnumMap;
import java.util.Map;

public class ModsImpl implements Mods{

    private final Map<JobEnum, Float> expValues = new EnumMap<>(JobEnum.class);
    private final Map<JobEnum, Float> coinsValues = new EnumMap<>(JobEnum.class);

    @Override
    public void addExpMod(String jobName, Float value, Float previousValue) {
        JobEnum job = JobEnum.valueOf(jobName.toUpperCase());
        expValues.put(job, expValues.getOrDefault(job, 0F) + (value - previousValue));
    }
    @Override
    public void addCoinsMod(String jobName, Float value, Float previousValue) {
        JobEnum job = JobEnum.valueOf(jobName.toUpperCase());
        coinsValues.put(job, coinsValues.getOrDefault(job, 0F) + (value - previousValue));
    }
    @Override
    public Float getExpMod(String jobName) {
        return calculateMod(jobName, expValues);
    }
    @Override
    public Float getCoinsMod(String jobName) {
        return calculateMod(jobName, coinsValues);
    }

    private Float calculateMod(String jobName, Map<JobEnum, Float> values) {
        JobEnum job = JobEnum.valueOf(jobName.toUpperCase());
        float totalMod = values.getOrDefault(JobEnum.ALL, 0F) + values.getOrDefault(job, 0F);
        if (isMilitaryJob(job)) {
            totalMod += values.getOrDefault(JobEnum.MILITARY, 0F);
        } else if (isEconomyJob(job)) {
            totalMod += values.getOrDefault(JobEnum.ECONOMY, 0F);
        } else if (isDevelopmentJob(job)) {
            totalMod += values.getOrDefault(JobEnum.DEVELOPMENT, 0F);
        }
        return totalMod;
    }

    private boolean isMilitaryJob(JobEnum job) {
        return job == JobEnum.HUNTER || job == JobEnum.RUNESMITH;
    }

    private boolean isEconomyJob(JobEnum job) {
        return job == JobEnum.BUILDER || job == JobEnum.FARMER || job == JobEnum.FISHERMAN;
    }

    private boolean isDevelopmentJob(JobEnum job) {
        return job == JobEnum.MINER || job == JobEnum.DIGGER || job == JobEnum.WOODCUTTER;
    }
}
