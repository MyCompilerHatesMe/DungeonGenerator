package com.mchm;

import com.mchm.dungeon.DungeonGenerator;
import com.mchm.dungeon.DungeonMap;

public class Main {
    public static void main(String[] args) {
        DungeonMap map = new DungeonMap(32, 32);
        DungeonGenerator dg = new DungeonGenerator(2, 6, 2, 6);
        map = dg.generateRandom(map, 10);

        System.out.println(map);
    }
}