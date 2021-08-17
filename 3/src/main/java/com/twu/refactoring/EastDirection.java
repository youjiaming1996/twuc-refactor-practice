package com.twu.refactoring;

public class EastDirection extends Direction{
    public EastDirection() {
        super('E');
    }

    public Direction turnRight () {
        return new Direction('N');
    }
    public Direction turnLeft () {
        return new Direction('N');
    }
}
