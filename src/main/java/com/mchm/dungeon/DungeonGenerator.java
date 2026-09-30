package com.mchm.dungeon;

import com.mchm.exceptions.InvalidRoomException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class DungeonGenerator {
    private final int roomMinHeight, roomMaxHeight, roomMinWidth, roomMaxWidth;

    private Random r = new Random();

    public DungeonMap generateRandom(DungeonMap map, int roomCount){
        boolean retryRoom = false;

        for (int i = 0; i < roomCount; i++){
            DungeonRoom newRoom;
            do {
                retryRoom = false;
                newRoom = generateRandomRoom(map.getMAX_WIDTH(), map.getMAX_HEIGHT());

                for (DungeonRoom room : map.getRooms()) {
                    if (DungeonRoom.doRoomsOverlap(room, newRoom)) {
                        retryRoom = true;
                        break;
                    }
                }
            } while (retryRoom);

            map.addRoom(newRoom);
        }

        return map;
    }

    private DungeonRoom generateRandomRoom(int mapMaxWidth, int mapMaxHeight) {
        int x = r.nextInt(mapMaxWidth - roomMaxWidth);
        int y = r.nextInt(mapMaxHeight - roomMaxHeight);
        int width = r.nextInt(roomMinWidth, roomMaxHeight);
        int height = r.nextInt(roomMinHeight, roomMaxHeight);

        return new DungeonRoom(x, y, width, height, TileType.FLOOR);

    }

    //TODO: generateCellularAutomata
    //TODO: generateSimplexNoise
    //TODO: generateBSP

}
