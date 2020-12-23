package com.maartenmusic.day11;

import com.maartenmusic.util.Coordinates;
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

    public String flattenSeats() {
    StringBuilder stringOfSeats = new StringBuilder();

        for(SeatSpace seatSpace : seatSpaces.values())

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

    SeatSpace firstSeatFoundInDirection(Coordinates coordinates, int x, int y) {
        SeatSpace foundSeat = this.seatSpaces.get(coordinates.move(x, y));
        if(foundSeat == null) {
            return new SeatSpace();
        }
        if(foundSeat.isOccupied() || foundSeat.isEmpty()) {
            return foundSeat;
        }

            return firstSeatFoundInDirection(coordinates.move(x, y), x, y);
    }

    public SeatingRoomMap changeSeatsPart2() {
        Map<Coordinates, SeatSpace> newSeatSpaces = new TreeMap<>();

        for(Coordinates coordinates : this.seatSpaces.keySet()) {
            int[][] moves = {{0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}};

            List<SeatSpace> visibleSeatSpaces = Arrays.stream(moves)
                    .map(move -> firstSeatFoundInDirection(coordinates, move[0], move[1]))
                    .collect(Collectors.toList());

            if(isCoordinatesEmpty(coordinates)) {
                if (visibleSeatSpaces.stream().noneMatch(SeatSpace::isOccupied)) {
                    newSeatSpaces.put(coordinates, new SeatSpace("#"));
                    continue;
                }
            }

            else if(isCoordinatesOccupied(coordinates)) {
                if (visibleSeatSpaces.stream().filter(SeatSpace::isOccupied).count() >= 5) {
                    newSeatSpaces.put(coordinates, new SeatSpace("L"));
                    continue;
                }
            }

            newSeatSpaces.put(coordinates, getSeatSpaceCopy(coordinates));
        }

        return new SeatingRoomMap(newSeatSpaces);
    }

    public SeatingRoomMap changeSeatsPart1() {
        Map<Coordinates, SeatSpace> newSeatSpaces = new TreeMap<>();

        for(Coordinates coordinates : this.seatSpaces.keySet()) {

            int[][] moves = {{0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}};

            List<SeatSpace> allDirections = Arrays.stream(moves)
                    .map(move -> this.seatSpaces.get(coordinates.move(move[0], move[1])))
                    .collect(Collectors.toList());

            allDirections =  allDirections.stream().filter(Objects::nonNull).collect(Collectors.toList());;

            if(isCoordinatesEmpty(coordinates)) {
                if (allDirections.stream().noneMatch(SeatSpace::isOccupied)) {
                    newSeatSpaces.put(coordinates, new SeatSpace("#"));
                } else {
                    newSeatSpaces.put(coordinates, getSeatSpaceCopy(coordinates));
                }
            }

            else if(isCoordinatesOccupied(coordinates)) {
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
