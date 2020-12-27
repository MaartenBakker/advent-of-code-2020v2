package com.maartenmusic.day11;

import com.maartenmusic.util.Coordinates;
import com.maartenmusic.util.TxtFileReaders;
import org.junit.jupiter.api.Test;

import java.io.File;
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

    @Test
    void firstSeat() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput2.txt");
        SeatingRoomMap seatingRoomMap = TxtFileReaders.toSeatingRoomMap(txtFile);

        SeatSpace foundSeat = seatingRoomMap.firstSeatFoundInDirection(new Coordinates(0,0), -1, 0);
        System.out.println(foundSeat);
    }

    @Test
    void changeSeatsPart2() {
        File txtFile = new File("src/test/java/com/maartenmusic/day11/testInput2.txt");
        SeatingRoomMap seatingRoomMap = TxtFileReaders.toSeatingRoomMap(txtFile);

        SeatingRoomMap newSeatingRoom = seatingRoomMap.changeSeatsPart2();
    }
}