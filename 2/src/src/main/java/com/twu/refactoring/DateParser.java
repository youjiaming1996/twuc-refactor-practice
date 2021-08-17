package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;
        year = parseData("Year", 0, 4, 2000, 2012);
        month = parseData("Month", 5, 7, 1, 12);
        date = parseData("Date", 8, 10, 1, 31);
        if (dateAndTimeString.charAt(11) == 'Z') {
            hour = 0;
            minute = 0;
        } else {
            hour = parseData("Hour", 11, 13, 0, 23);
            minute = parseData("Minute", 14, 16, 0, 59);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(KNOWN_TIME_ZONES.get("UTC"));
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(year, calendar.get(Calendar.MONTH), date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }



    private int parseData(String dataName, int substringStart, int substringEnd, int min, int max){
            int data;
            int length = substringEnd - substringStart;
            try {
                String dataString = dateAndTimeString.substring(substringStart, substringEnd);
                data = Integer.parseInt(dataString);
            } catch (StringIndexOutOfBoundsException e) {
                throw new IllegalArgumentException(dataName + " string is less than " + length + " characters");
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(dataName + " is not an integer");
            }
            if (data < min || data > max)
                throw new IllegalArgumentException(dataName + " cannot be less than " + min + " or more than " + max);
            return data;
        }
    }
