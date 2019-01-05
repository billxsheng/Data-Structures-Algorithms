//Bill Sheng
//20720680
//Assignment 1, Problem 2
//September 28, 2018
//This class is an object that can be instantiated to create Dates. The class also features a variety of private fields as well as accessor/mutator methods
//Input and Output: N/A because not concrete

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Date {	
	private static final String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	private int day;
	private int month;
	private int year;
	private int daysSince;
	private static final int[] daysInMonth = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
	
	//constructor which sets instance to today's date
	public Date() {
		//calls constructor with three parameters 
		this(1970, 1, 1);
		
		//Setting date now to type LocalDate variable
		LocalDate now = LocalDate.now();
		
		//Setting start date to type LocalDate variable
		LocalDate start = LocalDate.of(1970, 1, 1);
		
		//Getting days since between now and start date
		int daysSince = (int) ChronoUnit.DAYS.between(start, now);
		
		//runs passDays() for number of days between 1970/1/1 and today
		this.passDays(daysSince);
	}
	
	//runs the nextDay() function for the given number of days (numDays)
	public void passDays(int numDays) {
		for(int days = 0; days < numDays; days++) {
			this.nextDay();
		}
	}
	
	//constructor which sets specified date
	public Date(int year, int month, int day) {	
		//Setting day field
		this.day = day;
		
		//Setting month field
		this.month = month;
		
		//Setting year field
		this.year = year;	
		
		if(year < 1753) {
            throw new IllegalArgumentException("Year in date of " + this.toString() + " of value " + year + " is too low.");
		} else if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month in date of " + this.toString() + " of value " + month + " out of range");
		} else if (day < 1 || day > this.getDaysInMonth(month)) {
            throw new IllegalArgumentException("Day in date of " + this.toString() + " of value " + day + " out of range");
		}		
	}
	
	//Return day of instance
	public int getDay() {
		return this.day;
	}
	
	//Return month of instance
	public int getMonth() {
		return this.month;
	}
	
	//Return year of instance
	public int getYear() {
		return this.year;
	}
	
	//Return instance date in String format
	public String toString() {
		return this.year + "/" + this.month + "/" + this.day;
	}
	
	//returns boolean depending on whether or not instance is a leap year
	public boolean isLeapYear() {
		boolean isLeapYear;
		if(this.year % 4 == 0) {
			if(this.year % 400 != 0 && this.year % 100 == 0) {
				isLeapYear = false;
			} else {
				isLeapYear = true;
			}
		} else {
			isLeapYear = false;
		}
		return isLeapYear;
	}
	
	//mutator function which sets instance date to the next day
	public void nextDay() {
		if(this.month == 12 && this.day == this.getDaysInMonth(this.month)) {
			this.year++;
			this.month = 1;
			this.day = 1;
		} else if(this.day == this.getDaysInMonth(this.month)) {
			this.month++;
			this.day = 1;
		} else {
			this.day++;
		}
	}
	
	//method that gets the day of week index; by index I am referring to its location in the constant array specified at the top of the program
	public String getDayOfWeek() {
		Date startDate = new Date(1753, 1, 1);
		int dayOfWeekIndex = 0;
		while(!startDate.toString().equals(this.toString())) {
			if(dayOfWeekIndex == 6) {
				dayOfWeekIndex = 0;
			} else {
				dayOfWeekIndex++;
			}
			startDate.nextDay();
		}
		return daysOfWeek[dayOfWeekIndex];
	}
	
	//accessor method which takes in a month as its parameter and returns the days in the respective month
		public int getDaysInMonth(int month) {
			int numDays;
			if(month == 2 && this.isLeapYear()) {
				numDays = 29;
			} else if(month == 2 && !this.isLeapYear()) {
				numDays = 28;
			} else {
				numDays = daysInMonth[month - 1];
			}
			return numDays;
		}
}
