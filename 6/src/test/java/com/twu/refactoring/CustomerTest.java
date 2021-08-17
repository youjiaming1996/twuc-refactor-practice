package com.twu.refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Customer customer = new Customer("tom");

    @Test
    void should_return_statement_given_no_rentals() {
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", statement);
    }

    @Test
    void should_return_statement_when_rent_regular_movie() {
        customer.addRental(new Rental(new RegularMovie("Green Book"), 1));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tGreen Book\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    void should_return_statement_when_rent_regular_movie_for_more_than_2_days() {
        customer.addRental(new Rental(new RegularMovie("Green Book"), 3));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tGreen Book\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    void should_return_statement_when_rent_new_release_movie_for_more_than_1_day() {
        customer.addRental(new Rental(new NewReleaseMovie("Toy Story"), 3));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tToy Story\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    void should_return_statement_when_rent_new_release_movie_for_1_day() {
        customer.addRental(new Rental(new NewReleaseMovie("Toy Story"), 1));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    void should_return_statement_when_rent_children_movie_for_1_day() {
        customer.addRental(new Rental(new ChildrenMovie("Over the Hedge"), 1));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tOver the Hedge\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    void should_return_statement_when_rent_children_movie_for_more_than_3_days() {
        customer.addRental(new Rental(new ChildrenMovie("Over the Hedge"), 5));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tOver the Hedge\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    void should_return_statement_when_rent_multiple_movies() {
        customer.addRental(new Rental(new ChildrenMovie("Over the Hedge"), 5));
        customer.addRental(new Rental(new NewReleaseMovie("Toy Story"), 3));
        customer.addRental(new Rental(new RegularMovie("Green Book"), 3));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tOver the Hedge\t4.5\n" +
                "\tToy Story\t9.0\n" +
                "\tGreen Book\t3.5\n" +
                "Amount owed is 17.0\n" +
                "You earned 4 frequent renter points", statement);
    }

    @Test
    public void should_return_statement_when_rent_new_release_movie_for_5_day() {
        customer.addRental(new Rental(new NewReleaseMovie("Toy Story"), 5));
        String statement = customer.statement();
        assertEquals("Rental Record for tom\n" +
                "\tToy Story\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 0 frequent renter points", statement);
    }

}
