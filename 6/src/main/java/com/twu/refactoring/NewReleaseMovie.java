package com.twu.refactoring;

public class NewReleaseMovie extends Movie {
    NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1 &&daysRented<5) return 2;
        if (daysRented >=5) return 0;
        return 1;
    }
}
