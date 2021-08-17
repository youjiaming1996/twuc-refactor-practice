package com.twu.refactoring;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

        @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Direction direction1 = (Direction) obj;

        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
