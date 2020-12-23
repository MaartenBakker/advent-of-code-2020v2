package com.maartenmusic.day11;

import com.maartenmusic.day3.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class SeatingRoomMapTest {

    @Test
    void flattenSeats() {
        Map<Coordinates, SeatSpace> seatSpaces = new TreeMap<>();
        seatSpaces.put(new Coordinates(0,1), new SeatSpace("."));
        seatSpaces.put(new Coordinates(2,0), new SeatSpace("#"));
        seatSpaces.put(new Coordinates(2,1), new SeatSpace("L"));

        SeatingRoom seatingRoomMap = new SeatingRoomMap(seatSpaces);

        assertEquals("#.L", seatingRoomMap.flattenSeats());
    }
}