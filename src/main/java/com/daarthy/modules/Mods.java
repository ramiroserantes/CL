package com.daarthy.modules;

public interface Mods {

    void addExpMod(String jobName, Float value, Float previousValue);

    void addCoinsMod(String jobName, Float value, Float previousValue);

    Float getExpMod(String jobName);

    Float getCoinsMod(String jobName);

}
