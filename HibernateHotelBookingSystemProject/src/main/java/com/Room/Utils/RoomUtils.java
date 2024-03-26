package com.Room.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RoomUtils {

	private static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static String DATE_FORMAT = "yyyy-MM-dd";

	private static String EMPTY_SPACE = " ";

	public static LocalDateTime convertStringToDate(String date, String time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		LocalDateTime formattedDate = LocalDateTime.parse(date + EMPTY_SPACE + time, formatter);
		return formattedDate;
	}

	public static int getBookingHours(LocalDateTime checkinTime, LocalDateTime checkoutTime) {
		// Period duration = Period.(checkinTime, checkoutTime);
		long chUnit = ChronoUnit.HOURS.between(checkinTime, checkoutTime);
		return (int) chUnit;
	}

	public static String getCurrentDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		String currentDate = formatter.format(LocalDate.now());
		return currentDate;
	}

}
