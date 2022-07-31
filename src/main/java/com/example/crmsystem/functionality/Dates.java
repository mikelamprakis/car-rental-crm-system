package com.example.crmsystem.functionality;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Dates {

	private Dates(){}

	public static final String JANUARY = "JANUARY";
	public static final String FEBRUARY = "FEBRUARY";
	public static final String MARCH = "MARCH";
	public static final String APRIL = "APRIL";
	public static final String MAY = "MAY";
	public static final String JUNE = "JUNE";
	public static final String JULY = "JULY";
	public static final String AUGUST = "AUGUST";
	public static final String SEPTEMBER = "SEPTEMBER";
	public static final String OCTOBER = "OCTOBER";
	public static final String NOVEMBER = "NOVEMBER";
	public static final String DECEMBER = "DECEMBER";
	
	
	public static ArrayList<StringBuilder> inDates(String fromDate, String toDate){
			ArrayList<StringBuilder> inputDates=  new ArrayList<>();
			String [] fromD = fromDate.split("/");
			String [] toD = toDate.split("/");
			int fromYear = Integer.parseInt(fromD[2]);
			int fromMonth = Integer.parseInt(fromD[1]);
			int toMonth = Integer.parseInt(toD[1]);
			String [] months = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
			String actualMonthFrom= months[fromMonth-1];
			String actualMonthTo= months[toMonth-1];
			int fromDay = Integer.parseInt(fromD[0]);
			int toDay = Integer.parseInt(toD[0]);
			int pinedMonth = fromMonth;
			LocalDate dateBefore = LocalDate.of(fromYear, Month.valueOf(actualMonthFrom), fromDay);
			LocalDate dateAfter = LocalDate.of(fromYear, Month.valueOf(actualMonthTo), toDay);
			long noOfDaysBetween;
			if (dateBefore.equals(dateAfter)) {
				noOfDaysBetween = 1;
			}else {
				noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
			}
			long allD = noOfDaysBetween;
			int index =1;
			while (index <= allD){
				for (int i=fromMonth; i <= toMonth; i++){
					YearMonth yearMonthObject = YearMonth.of(fromYear, i);
					int daysInMonth = yearMonthObject.lengthOfMonth();
				    if(i==fromMonth && i==toMonth) {
				    	for(int j=fromDay; j<=toDay; j++){
				    		StringBuilder d = new StringBuilder();
				    		d.append(j);
				    		StringBuilder m = new StringBuilder();
				    		m.append(i);
				    		StringBuilder date=  new StringBuilder();
				    		date.append(d + "/" + m + "/" + fromD[2]);
				    		index++;
				    		inputDates.add(date);	
				    	}
					}else if(i==fromMonth && i!=toMonth) {
						for(int j=fromDay; j<=daysInMonth; j++){
							StringBuilder d = new StringBuilder();
							d.append(j);
							StringBuilder m = new StringBuilder();
							m.append(i);
							StringBuilder date=  new StringBuilder();
							date.append(d + "/" + m + "/" + fromD[2]);
							index++;
							inputDates.add(date);
						}
					} else if(pinedMonth < i && i<toMonth) {
						fromDay = 1;
						pinedMonth++;
						for(int j=fromDay; j<=daysInMonth; j++){
							StringBuilder d = new StringBuilder();
							d.append(j);
							StringBuilder m = new StringBuilder();
							m.append(i);
							StringBuilder date=  new StringBuilder();
							date.append(d + "/" + m + "/" + fromD[2]);
							index++;
							inputDates.add(date);				
						} 	
					}else if(i==toMonth) {
						fromDay = 1;
						for(int j=fromDay; j<=toDay; j++){
							StringBuilder d = new StringBuilder();
							d.append(j);
							StringBuilder m = new StringBuilder();
							m.append(i);
							StringBuilder date=  new StringBuilder();
							date.append(d + "/" + m + "/" + fromD[2]);
							index++;
							inputDates.add(date);	
						}
					}
				}
			}
			return inputDates;
		}	
		
	
	public static int findDays(String fromDate, String toDate) {
		String [] fromD = fromDate.split("/");
		String [] toD = toDate.split("/");
		int fromYear = Integer.parseInt(fromD[2]);
		int toYear = Integer.parseInt(toD[2]);
		int fromMonth = Integer.parseInt(fromD[1]);
		int toMonth = Integer.parseInt(toD[1]);
		String [] months = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
		String actualMonthFrom= months[fromMonth-1];
		String actualMonthTo= months[toMonth-1];
		int fromDay = Integer.parseInt(fromD[0]);
		int toDay = Integer.parseInt(toD[0]);
		LocalDate dateBefore = LocalDate.of(fromYear, Month.valueOf(actualMonthFrom), fromDay);
		LocalDate dateAfter = LocalDate.of(fromYear, Month.valueOf(actualMonthTo), toDay);
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		@SuppressWarnings("deprecation")
		Long longDays = new Long(noOfDaysBetween);
		int intDays ;
		if (fromDay == toDay && fromMonth==toMonth && fromYear==toYear) {
			intDays = 1;
		}else {
			intDays = longDays.intValue();
		}
		return intDays;
	}
	
	
	public  static boolean checkValidDates(String fromDate, String toDate) {
		String [] fromD = fromDate.split("/");
		String [] toD = toDate.split("/");
		int fromYear = Integer.parseInt(fromD[2]);
		int toYear = Integer.parseInt(toD[2]);
		int fromMonth = Integer.parseInt(fromD[1]);
		int toMonth = Integer.parseInt(toD[1]);
		int fromDay = Integer.parseInt(fromD[0]);
		int toDay = Integer.parseInt(toD[0]);
		String [] months = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
		String actualMonthFrom= months[fromMonth-1];
		String actualMonthTo= months[toMonth-1];
		LocalDate dateBefore = LocalDate.of(fromYear, Month.valueOf(actualMonthFrom), fromDay);
		LocalDate dateAfter = LocalDate.of(toYear, Month.valueOf(actualMonthTo), toDay);
		return dateBefore.isBefore(dateAfter);
	}



	
	
	

}
