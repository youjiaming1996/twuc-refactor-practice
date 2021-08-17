package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {

        double totalCost;

        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
        if(taxi.isAirConditioned()) {
            totalCost = getTotalCost(FIXED_CHARGE,
                    totalKms,
                    peakTimeMultiple,
                    PRE_RATE_CHANGE_AC_RATE,
                    POST_RATE_CHANGE_AC_RATE);
        } else {
            totalCost = getTotalCost(FIXED_CHARGE,
                    totalKms,
                    peakTimeMultiple,
                    PRE_RATE_CHANGE_NON_AC_RATE,
                    POST_RATE_CHANGE_NON_AC_RATE);
        }

        return totalCost * (1 + SALES_TAX_RATE);
    }

    private double getTotalCost(double totalCost, int totalKms, double peakTimeMultiple,int PRE_RATE_CHANGE_AC_RATE, int POST_RATE_CHANGE_AC_RATE ) {
        return totalCost + Math.min(RATE_CHANGE_DISTANCE, totalKms)
                * PRE_RATE_CHANGE_AC_RATE
                * peakTimeMultiple
                + Math.max(0, totalKms - RATE_CHANGE_DISTANCE)
                * POST_RATE_CHANGE_AC_RATE
                * peakTimeMultiple;
    }
}
