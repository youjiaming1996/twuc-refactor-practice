package com.twu.refactoring;

import java.util.Arrays;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return Arrays.stream(numbers).filter(num -> num %2== 0).toArray().length;
    }

    public int countOdd() {
        return numbers.length - countEven();
    }

    public int countPositive() {
        return Arrays.stream(numbers).filter(num -> num >= 0).toArray().length;
    }

    public int countNegative() {

        return Arrays.stream(numbers).filter(num -> num <0).toArray().length;
    }
}
