package com.mchm.dungeon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DungeonRoom {
    private final int x, y, width, height, centreX, centreY;
    // floor tile type is assumed as TileType.FLOOR
    // idk if i'll add more floor types

    public DungeonRoom(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height= height;
        this.centreX = (x+width)/2;
        this.centreY = (y+height)/2;
    }
}
