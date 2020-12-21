package com.maartenmusic.day11;

import com.maartenmusic.day5.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class SeatingRoom {

    private List<List<SeatSpace>> seatSpaces;

    public SeatingRoom changeSeats() {
        List<List<SeatSpace>> newSeatSpaces = new ArrayList<>();

        // middle seats
        for (int i = 1; i < this.seatSpaces.size() -1; i++) {
            List<SeatSpace> newRow = new ArrayList<>();

            for (int j = 1; j < this.seatSpaces.get(i).size() -1; j++) {
                SeatSpace currentSeat = this.seatSpaces.get(i).get(j);

                if (currentSeat.isFloor()) {
                    newRow.add(currentSeat);
                    continue;
                }

                SeatSpace north = this.seatSpaces.get(i -1).get(j);
                SeatSpace northEast = this.seatSpaces.get(i -1).get(j +1);
                SeatSpace east = this.seatSpaces.get(i).get(j +1);
                SeatSpace southEast = this.seatSpaces.get(i +1).get(j +1);
                SeatSpace south = this.seatSpaces.get(i +1).get(j);
                SeatSpace southWest = this.seatSpaces.get(i +1).get(j -1);
                SeatSpace west = this.seatSpaces.get(i).get(j -1);
                SeatSpace northWest = this.seatSpaces.get(i -1).get(j -1);

                List<SeatSpace> allDirections = Arrays.asList(north, northEast, east,  southEast, south, southWest,
                        west, northWest);

                if (currentSeat.isEmpty()) {
                    if (allDirections.stream().noneMatch(SeatSpace::isOccupied)) {
                        newRow.add(new SeatSpace("#"));
                    }
                } else if (currentSeat.isOccupied()) {
                    if (allDirections.stream().filter(SeatSpace::isOccupied).count() >= 4) {
                        newRow.add(new SeatSpace("L"));
                    }
                } else {
                    SeatSpace copyOfCurrentSeat = new SeatSpace(".");
                    copyOfCurrentSeat.setState(currentSeat.getState());
                    newRow.add(copyOfCurrentSeat);
                }

            }

            newSeatSpaces.add(newRow);
        }

        // == Remember to add to list at right indexes==

        // top row middle seats

        // bottom row middle seats

        // left edge middle seats

        // right edge middle seats

        //corners

        return new SeatingRoom(newSeatSpaces);
    }
}
