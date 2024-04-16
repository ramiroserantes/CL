package com.daarthy.modules;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;


public class ModsImplTest {

    private Mods mods;

    @Before
    public void setUp() {
        mods = new ModsImpl();
    }

    @Test
    public void testAddExpMod() {
        mods.addExpMod("builder", 10.0f, 0.0f);
        assertEquals(10.0f, mods.getExpMod("builder"), 0.0);
    }

    @Test
    public void testAddCoinsMod() {
        mods.addCoinsMod("miner", 20.0f, 0.0f);
        assertEquals(20.0f, mods.getCoinsMod("miner"), 0.0);
    }

    @Test
    public void testGetExpModMilitary() {
        mods.addExpMod("hunter", 30.0f, 0.0f);
        assertEquals(30.0f, mods.getExpMod("hunter"), 0.0);
    }

    @Test
    public void testGetCoinsModEconomy() {
        mods.addCoinsMod("fisherman", 40.0f, 0.0f);
        assertEquals(40.0f, mods.getCoinsMod("fisherman"), 0.0);
    }

    @Test
    public void testGetExpModGeneric() {
        mods.addExpMod("farmer", 50.0f, 0.0f);
        assertEquals(50.0f, mods.getExpMod("farmer"), 0.0);
    }

    @Test
    public void testGetCoinsModGeneric() {
        mods.addCoinsMod("woodcutter", 60.0f, 0.0f);
        assertEquals(60.0f, mods.getCoinsMod("woodcutter"), 0.0);
    }

    @Test
    public void testGetExpModAll() {
        mods.addExpMod("runesmith", 70.0f, 0.0f);
        assertEquals(70.0f, mods.getExpMod("runesmith"), 0.0);
    }

    @Test
    public void testGetCoinsModAll() {
        mods.addCoinsMod("digger", 80.0f, 0.0f);
        assertEquals(80.0f, mods.getCoinsMod("digger"), 0.0);
    }

    @Test
    public void testGetExpModMultipleMilitary() {
        mods.addExpMod("hunter", 30.0f, 0.0f);
        mods.addExpMod("military", 50.0f, 0.0f);
        assertEquals(80.0f, mods.getExpMod("hunter"), 0.0);
    }

    @Test
    public void testGetCoinsModMultipleEconomy() {
        mods.addCoinsMod("fisherman", 40.0f, 0.0f);
        mods.addCoinsMod("fisherman", 50.0f, 0.0f);
        mods.addCoinsMod("fisherman", 70.0f, 50.0f);
        mods.addCoinsMod("fisherman", 20.0f, 40.0f);
        mods.addCoinsMod("economy", 10.0f, 0.0f);
        assertEquals(100.0f, mods.getCoinsMod("fisherman"), 0.0);
    }

    @Test
    public void testGetExpModMultipleGeneric() {
        mods.addExpMod("farmer", 40.0f, 0.0f);
        mods.addExpMod("economy", 20.0f, 0.0f);
        assertEquals(60.0f, mods.getExpMod("farmer"), 0.0);
    }

    @Test
    public void testGetCoinsModMultipleGeneric() {
        mods.addCoinsMod("builder", 20.0f, 0.0f);
        mods.addCoinsMod("economy", 50.0f, 0.0f);
        assertEquals(70.0f, mods.getCoinsMod("builder"), 0.0);
    }

    @Test
    public void testGetExpModWithAllAndMilitary() {
        mods.addExpMod("all", 30.0f, 0.0f);
        mods.addExpMod("hunter", 50.0f, 0.0f);
        assertEquals(80.0f, mods.getExpMod("hunter"), 0.0);
    }

    @Test
    public void testGetCoinsModWithAllAndEconomy() {
        mods.addCoinsMod("all", 40.0f, 0.0f);
        mods.addCoinsMod("fisherman", 60.0f, 0.0f);
        assertEquals(100.0f, mods.getCoinsMod("fisherman"), 0.0);
    }
}

