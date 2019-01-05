package com.company;

import teacher.Date;

//Bill Sheng
//Assignment 1, Problem 1
//September 21, 2018
//DateClient program is a QA tool to test the teacher.Date file
//Input and Output: N/A because not concrete

public class bxsheng_DateClient {
    public static final int[][] testDates = {{}, {1999, 1, 1}, {1752, 1, 1}, {3000, 12, 31}, {1999, -1, -1}, {1999, 13, 30}, {1999, 10, 34 }, {2004, 2, 28}};

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the teacher.Date QA program.");
        System.out.println();
        System.out.println("This program outputs an array of dates declared in the constant above and parses the dates through a variety of methods that can be found in the teacher.Date class.");
        System.out.println();
        System.out.println("New object is created first to test the constructor method and the instance is passed down in order to test the instance methods.");
        System.out.println();
        System.out.println("To test another date, simply add it to in the two-dimensional testDates array in the following format: {year, month, day}.");
        System.out.println();
        runTest();
    }

    public static void runTest() {
        for (int dateCounter = 0; dateCounter < testDates.length; dateCounter++) {
            if (testDates[dateCounter].length == 0) {
                dateTest();
            } else if(testDates[dateCounter].length < 3 || testDates[dateCounter].length > 3 ) {
                throw new IllegalArgumentException("3 int values needed per array value. Array with index " + dateCounter + " currently has " + testDates[dateCounter].length + " argument(s).");
            } else {
                dateTest(testDates[dateCounter][0], testDates[dateCounter][1], testDates[dateCounter][2]);
            }
        }
    }

    public static void dateTest(int year, int month, int day) {
        System.out.println("Running date contructor test method with year " + year + ", month " + month + ", day " + day + ".");
        try {
            Date testDate = new Date(year, month, day);
            getDayTest(testDate);
            getMonthTest(testDate);
            getYearTest(testDate);
            getDayOfWeekTest(testDate);
            isLeapYearTest(testDate);
            toStringTest(testDate);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static void dateTest() {
        System.out.println("Running test method for today's date.");
        try {
            Date date = new Date();
            System.out.println("Today's date is " + date + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getDayTest(Date testDate) {
        try {
            testDate.getDay();
            System.out.println("Running getDayTest method for " + testDate + " and recieved day of: " + testDate.getDay() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getMonthTest(Date testDate) {
        try {
            testDate.getMonth();
            System.out.println("Running getMonthTest method for " + testDate + " and recieved month of: " + testDate.getMonth() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getYearTest(Date testDate) {
        try {
            testDate.getYear();
            System.out.println("Running getYearTest method for " + testDate + " and recieved year of: " + testDate.getYear() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getDayOfWeekTest(Date testDate) {
        try {
            testDate.getDayOfWeek();
            System.out.println("Running getDayOfWeekTest method for " + testDate + " and recieved week day of: " + testDate.getDayOfWeek() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void isLeapYearTest(Date testDate) {
        System.out.println("Running isLeapYearTest method for " + testDate + ".");
        try {
            testDate.isLeapYear();
            System.out.println("Running isLeapYearTest method for " + testDate + " and recieved leap year: " + testDate.isLeapYear() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void toStringTest(Date testDate) {
        try {
            testDate.toString();
            System.out.println("Running toStringTest method for " + testDate + " and recieved string date of: " + testDate.toString() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
