package com.mchm.exceptions;

import com.mchm.dungeon.DungeonRoom;

public class InvalidRoomException extends RuntimeException {
    public InvalidRoomException(DungeonRoom room) {
        String message = "";
        message += "Room X: " + room.getX();
        message += "\nRoom Y: " + room.getY();
        message += "\nRoom Width: " + room.getWidth();
        message += "\nRoom Height: " + room.getHeight();
        message += "\nRoom Floor Type: " + room.getFloorType();
        super(message);
    }
}
