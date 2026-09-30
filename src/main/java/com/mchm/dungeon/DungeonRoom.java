package com.mchm.dungeon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DungeonRoom {
    private final int x, y, width, height, centreX, centreY;
    private final TileType floorType;
    // floor tile type is assumed as TileType.FLOOR
    // idk if i'll add more floor types
    // x, y are bottom left corner coordinates

    public DungeonRoom(int x, int y, int width, int height, TileType floorType) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height= height;
        this.centreX = x + width/2;
        this.centreY = y + height/2;
        this.floorType = floorType;
    }

    public static boolean doRoomsOverlap(DungeonRoom room1, DungeonRoom room2) {
        return  (room1.getX() < room2.getX() + room2.getWidth()) &&
                (room1.getX() + room1.getWidth() > room2.getX()) &&
                (room1.getY() < room2.getY() + room2.getHeight()) &&
                (room1.getY() + room1.getHeight() > room2.getY());
    }

    @Override
    public String toString() {
        String out = "{";
        out += "\n\tWIDTH: " + width;
        out += "\n\tHEIGHT: " + height;
        out += "\n\tX: " + x;
        out += "\n\tY: " + y;
        out += "\n}";
        return out;
    }
}
