package com.choway.springboot.security.jwt.util;

import java.util.Calendar;
import java.util.Date;


public class DateTimeUtil {

	/**
	 * 传入一个日期，获取相差后的时间，
	 * 相差单位可以是年、月、日、时、分、秒
	 */
	public static Date getDiffDate(Date date, int field, int diff) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if (Calendar.YEAR == field)
			calendar.add(Calendar.YEAR, diff);
		if (Calendar.MONTH == field)
			calendar.add(Calendar.MONTH, diff);
		if (Calendar.DAY_OF_YEAR == field)
			calendar.add(Calendar.DAY_OF_YEAR, diff);
		if (Calendar.HOUR_OF_DAY == field)
			calendar.add(Calendar.HOUR_OF_DAY, diff);
		if (Calendar.MINUTE == field)
			calendar.add(Calendar.MINUTE, diff);
		if (Calendar.SECOND == field)
			calendar.add(Calendar.SECOND, diff);
		if (Calendar.MILLISECOND == field)
			calendar.add(Calendar.MILLISECOND, diff);

		return calendar.getTime();
	}


	public static boolean compare(Date date1, Date date2) {
		if (date1.getTime() > date2.getTime())
			return true;
		return false;
	}

}
