package sastruts.exam.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	/**
	 * 現在の日付をjava.sql.Date型で返します。
	 * @return
	 */
	public static java.sql.Date getCurrentSqlDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new java.sql.Date(cal.getTimeInMillis());
	}
	
}
