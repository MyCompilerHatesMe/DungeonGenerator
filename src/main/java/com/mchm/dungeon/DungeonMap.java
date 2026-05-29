package com.mchm.dungeon;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
public class DungeonMap {

    private final int MAX_WIDTH, MAX_HEIGHT;
    private TileType[][] map;

    private boolean roomsPopulated;
    private ArrayList<DungeonRoom> rooms;

    public DungeonMap(int MAX_WIDTH, int MAX_HEIGHT) {
        this.MAX_HEIGHT = MAX_HEIGHT;
        this.MAX_WIDTH = MAX_WIDTH;
        map = new TileType[MAX_WIDTH][MAX_HEIGHT];
    }

    public void locateRooms() {
        //TODO: this should find all the rooms in the map and populate rooms if not already populated
        if (roomsPopulated) return;
    }

    public String toString() {
        return "[" +
                Arrays.deepToString(map)
                        .replaceAll("\\[\\[|]]", "")
                        .replace("], [", "]\n[")
                + "]";
    }
}
