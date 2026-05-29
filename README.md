# DungeonGenerator

A Java library for procedural 2D dungeon generation. Built as a learning/experimentation project, exploring different generation algorithms on a flat integer tile grid.

---

## Overview

We represent a dungeon as a 2D `TileType[][]` grid where each cell holds a tile type value (floor, wall, void, door). Rooms are tracked as discrete objects with position and dimension metadata. The library is designed to be algorithm-agnostic — the same `DungeonMap` structure is produced regardless of which generation strategy you use.

---

## Project Structure

```
com.mchm/
|-dungeon/
    |- TileType.java         # Enum of tile values: FLOOR, WALL, VOID, DOOR
    |-DungeonRoom.java       # Represents a single room (position, dimensions, centre)
    |- DungeonMap.java       # The map grid + room list; output of all generators
    |-DungeonGenerator.java  # Entry point for generation algorithms
|-Main.java                  # Primarily for testing, though proper tests will be added
```

---

## Core Concepts

### Tile Types

Tiles are stored as integers in the grid. The `TileType` enum defines what each value means:

| Tile    | Description                              |
|---------|------------------------------------------|
| `FLOOR` | Walkable space inside a room             |
| `WALL`  | Boundary tile surrounding a room         |
| `VOID`  | Empty/uncarved space (default)           |
| `DOOR`  | Connection point between rooms/corridors |

### DungeonMap

The map is a fixed-size `TileType[MAX_WIDTH][MAX_HEIGHT]` grid. It also holds a list of `DungeonRoom` objects once `locateRooms()` has been called, though the list maybe populated immediately depending on generation algorithm used.

```java
DungeonMap map = new DungeonMap(80, 50);
```

### DungeonRoom

A room is defined by its top-left corner `(x, y)`, its `width` and `height`, and its computed centre point `(centreX, centreY)`. The centre is useful for corridor generation.

```java
DungeonRoom room = new DungeonRoom(5, 3, 10, 8);
// room.getCentreX() → 10, room.getCentreY() → 7
```

### DungeonGenerator

Takes room size constraints at construction and exposes generation methods that each accept a `DungeonMap` and return it populated.

```java
DungeonGenerator dg = new DungeonGenerator(
    4, 10,  // min/max room height
    4, 12   // min/max room width
);

DungeonMap map = dg.generateRandom(new DungeonMap(80, 50), 15);
```

---

## Generation Algorithms

| Algorithm                       | Method                       | Status  |
|---------------------------------|------------------------------|---------|
| Random room placement           | `generateRandom()`           | planned |
| Cellular Automata               | `generateCellularAutomata()` | planned |
| Simplex Noise                   | `generateSimplexNoise()`     | planned |
| BSP (Binary Space Partitioning) | `generateBSP()`              | planned |

---

## TODO's

- [ ] Random room placement
- [ ] Cellular Automata
- [ ] Simplex Noise
- [ ] BSP 
- [ ] locateRooms
- [ ] Unit Testing

---

## Dependencies

- [Lombok](https://projectlombok.org/) — used for `@Getter`, `@Setter`, `@AllArgsConstructor` to reduce boilerplate.

---

## Notes & Caveats

- `DungeonRoom.centreX` / `centreY` are computed as `x + width / 2` using integer division, may cause issues with small rooms.