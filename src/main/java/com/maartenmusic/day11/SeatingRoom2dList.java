package com.maartenmusic.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SeatingRoom2dList implements SeatingRoom{

    private List<List<SeatSpace>> seatSpaces;

    public String flattenSeats() {
        StringBuilder stringOfSeats = new StringBuilder();

        for (List<SeatSpace> list : seatSpaces ) {
            for (SeatSpace seatSpace : list) {
                if (seatSpace.isOccupied()) {
                    stringOfSeats.append("#");
                } else if (seatSpace.isEmpty()) {
                    stringOfSeats.append(("L"));
                } else {
                    stringOfSeats.append(".");
                }
            }
        }

        return stringOfSeats.toString();
    }


    public SeatingRoom2dList changeSeats() {
        List<List<SeatSpace>> newSeatSpaces = new ArrayList<>();
        int columnSize = this.seatSpaces.size();

        for (int i = 0; i < columnSize; i++) {
            List<SeatSpace> newRow = new ArrayList<>();
            int rowSize = this.seatSpaces.get(i).size();

            for (int j = 0; j < rowSize; j++) {
                SeatSpace currentSeat = this.seatSpaces.get(i).get(j);

                if (currentSeat.isFloor()) {
                    newRow.add(new SeatSpace());
                    continue;
                }

                SeatSpace northWest = null;
                SeatSpace north = null;
                SeatSpace northEast = null;

                SeatSpace southWest = null;
                SeatSpace south = null;
                SeatSpace southEast = null;

                SeatSpace west = null;
                SeatSpace east = null;

                if (i - 1 < 0) {
                    northWest = new SeatSpace();
                    north = new SeatSpace();
                    northEast = new SeatSpace();
                }

                if (i + 1 == columnSize) {
                    southWest = new SeatSpace();
                    south = new SeatSpace();
                    southEast = new SeatSpace();
                }

                if (j -1 < 0) {
                    northWest = new SeatSpace();
                    west = new SeatSpace();
                    southWest = new SeatSpace();
                }

                if (j +1 == rowSize) {
                    northEast = new SeatSpace();
                    east = new SeatSpace();
                    southEast = new SeatSpace();
                }

                if (north == null) {
                    north =  this.seatSpaces.get(i - 1).get(j);
                }

                if (northEast == null) {
                    northEast = this.seatSpaces.get(i - 1).get(j + 1);
                }

                if (east == null) {
                    east = this.seatSpaces.get(i).get(j + 1);
                }

                if (southEast == null) {
                    southEast = this.seatSpaces.get(i + 1).get(j + 1);
                }

                if (south == null) {
                    south = this.seatSpaces.get(i + 1).get(j);
                }

                if (southWest == null) {
                    southWest = this.seatSpaces.get(i + 1).get(j - 1);
                }

                if (west == null) {
                    west = this.seatSpaces.get(i).get(j - 1);
                }

                if (northWest == null) {
                    northWest = this.seatSpaces.get(i - 1).get(j - 1);
                }

                List<SeatSpace> allDirections = Arrays.asList(north, northEast, east, southEast, south, southWest,
                        west, northWest);

                if (currentSeat.isEmpty()) {
                    if (allDirections.stream().noneMatch(SeatSpace::isOccupied)) {
                        newRow.add(new SeatSpace("#"));
                    } else {
                        SeatSpace copyOfCurrentSeat = new SeatSpace(".");
                        copyOfCurrentSeat.setState(currentSeat.getState());
                        newRow.add(copyOfCurrentSeat);
                    }
                } else if (currentSeat.isOccupied()) {
                    if (allDirections.stream().filter(SeatSpace::isOccupied).count() >= 4) {
                        newRow.add(new SeatSpace("L"));
                    } else {
                        SeatSpace copyOfCurrentSeat = new SeatSpace(".");
                        copyOfCurrentSeat.setState(currentSeat.getState());
                        newRow.add(copyOfCurrentSeat);
                    }
                }

            }
                newSeatSpaces.add(newRow);
            }

        return new SeatingRoom2dList(newSeatSpaces);
    }
}
