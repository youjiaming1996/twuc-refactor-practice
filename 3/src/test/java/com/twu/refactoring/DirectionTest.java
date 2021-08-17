package com.twu.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {

    private NorthDirection north;
    private EastDirection east;

    @BeforeEach
    public void setUp()  {
        north = new NorthDirection();
        east = new EastDirection();
    }

    @Test
    public void shouldTurnEastWhenTurnRightFromNorth() {
        Direction east = north.turnRight();
        assertThat(east, is(new Direction('E')));
    }

    @Test
    public void shouldTurnWestWhenTurnLeftFromNorth() {
        Direction west = north.turnLeft();
        assertThat(west, is(new Direction('W')));
    }

    @Test
    public void shouldTurnNorthWhenTurnLeftFromEast() {
        Direction north = east.turnLeft();
        assertThat(north, is(new Direction('N')));
    }
}
