package com.mchm.dungeon;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DungeonGenerator {
    private final int roomMinHeight, roomMaxHeight, roomMinWidth, roomMaxWidth;

    public DungeonMap generateRandom(DungeonMap map, int roomCount){
        //TODO: actual logic
        return map;
    }

    //TODO: generateCellularAutomata
    //TODO: generateSimplexNoise
    //TODO: generateBSP

}
