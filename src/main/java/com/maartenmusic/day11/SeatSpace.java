package com.maartenmusic.day11;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SeatSpace {
    private State state;

    public SeatSpace() {
        this.state = this.state = State.FLOOR;;
    }

    public SeatSpace(String stateString) {
        switch (stateString) {

            case "L":
                this.state = State.EMPTY;
                break;
            case "#":
                this.state = State.OCCUPIED;
                break;
            default:
                this.state = State.FLOOR;
        }
    }

    public boolean isEmpty() {
        return this.state == State.EMPTY;
    }

    public boolean isOccupied() {
        return this.state == State.OCCUPIED;
    }

    public boolean isFloor() {
        return this.state == State.FLOOR;
    }

    public enum State {
        FLOOR,
        EMPTY,
        OCCUPIED
    }
}
