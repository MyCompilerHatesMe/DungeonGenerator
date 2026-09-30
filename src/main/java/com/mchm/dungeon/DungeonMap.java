package com.mchm.dungeon;

import com.mchm.exceptions.InvalidRoomException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        rooms = new ArrayList<>();
    }

    public void addRoom(DungeonRoom room) throws InvalidRoomException {
        if (!isRoomValid(room))
            throw new InvalidRoomException(room);

        rooms.add(room);
        for (int i = 0; i < room.getWidth(); i++) {
            for (int j = 0; j < room.getHeight(); j++) {
                map[j+room.getY()][i+room.getX()] = room.getFloorType();
            }
        }
    }

    private boolean isRoomValid(DungeonRoom room) {
        boolean greaterBounds = (room.getX() + room.getWidth()) > MAX_WIDTH ||
                (room.getY() + room.getHeight()) > MAX_HEIGHT;

        boolean lesserBounds = (room.getX() < 0 || room.getY() < 0);

        return !greaterBounds && !lesserBounds;
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

    public String stringifyRooms() {
        return rooms.stream().map(DungeonRoom::toString).collect(Collectors.joining("\n"));
    }
}
