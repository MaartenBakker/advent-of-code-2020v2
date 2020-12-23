package com.maartenmusic.day11;

import com.maartenmusic.day3.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class SeatingRoomMap implements SeatingRoom {
    private final Map<Coordinates, SeatSpace> seatSpaces;

    public SeatingRoomMap(Map<Coordinates, SeatSpace> seatSpaces) {
        this.seatSpaces = Collections.unmodifiableMap(seatSpaces);
    }

    public boolean isCoordinatesEmpty(Coordinates coordinates) {
        return seatSpaces.get(coordinates).isEmpty();
    }

    public boolean isCoordinatesOccupied(Coordinates coordinates) {
        return seatSpaces.get(coordinates).isOccupied();
    }

    public boolean isCoordinatesFloor(Coordinates coordinates) {
        return seatSpaces.get(coordinates).isFloor();
    }


    public String flattenSeats() {
    StringBuilder stringOfSeats = new StringBuilder();

        for(SeatSpace seatSpace :seatSpaces.values())

        {
            if (seatSpace.isOccupied()) {
                stringOfSeats.append("#");
            } else if (seatSpace.isEmpty()) {
                stringOfSeats.append(("L"));
            } else {
                stringOfSeats.append(".");
            }
        }

        return stringOfSeats.toString();
    }

    public SeatingRoomMap changeSeats() {
        Map<Coordinates, SeatSpace> newSeatSpaces = new TreeMap<>();

        for(Coordinates coordinates : this.seatSpaces.keySet()) {

            List<SeatSpace> allDirections = Arrays.asList(this.seatSpaces.get(coordinates.goNorth()),
                    this.seatSpaces.get(coordinates.goNorthEast()),
                    this.seatSpaces.get(coordinates.goEast()),
                    this.seatSpaces.get(coordinates.goSouthEast()),
                    this.seatSpaces.get(coordinates.goSouth()),
                    this.seatSpaces.get(coordinates.goSouthWest()),
                    this.seatSpaces.get(coordinates.goWest()),
                    this.seatSpaces.get(coordinates.goNorthWest()));

            allDirections =  allDirections.stream().filter(Objects::nonNull).collect(Collectors.toList());;

            if(isCoordinatesEmpty(coordinates)) {
                if (allDirections.stream().noneMatch(SeatSpace::isOccupied)) {
                    newSeatSpaces.put(coordinates, new SeatSpace("#"));
                } else {
                    newSeatSpaces.put(coordinates, getSeatSpaceCopy(coordinates));
                }
            } else if(isCoordinatesOccupied(coordinates)) {
                if (allDirections.stream().filter(SeatSpace::isOccupied).count() >= 4) {
                    newSeatSpaces.put(coordinates, new SeatSpace("L"));
                } else {
                    newSeatSpaces.put(coordinates, getSeatSpaceCopy(coordinates));
                }
            }
        }

        return new SeatingRoomMap(newSeatSpaces);

    }

    private SeatSpace getSeatSpaceCopy(Coordinates coordinates) {
        SeatSpace copyOfCurrentSeat = new SeatSpace(".");
        copyOfCurrentSeat.setState(this.seatSpaces.get(coordinates).getState());
        return copyOfCurrentSeat;
    }
}
