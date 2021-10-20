package br.com.bycoders.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConverterUtils {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");

	public static LocalDate convertToLocalDate(String date) {
		return LocalDate.parse(date, DATE_FORMATTER);
	}

	public static LocalTime convertToLocalTime(String time) {
		return LocalTime.parse(time, TIME_FORMATTER);
	}
}
