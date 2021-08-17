package com.twu.refactoring;

public class NorthDirection extends Direction{
    public NorthDirection() {
        super('N');
    }

    public Direction turnRight () {
        return new Direction('E');
    }
    public Direction turnLeft () {
        return new Direction('W');
    }
}
