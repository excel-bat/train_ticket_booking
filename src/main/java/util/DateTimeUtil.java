/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

package util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.util.Locale;


/**
 * 单例日期处理类.
 *
 * @author shanyingbo
 * @version $Id DateTimeUtil.java, v 0.1 2018-04-06 下午12:47 shanyingbo Exp $$
 */
public class DateTimeUtil {

    public static final DateTimeFormatter FLIGHT_DATE_FORMAT =
            DateTimeFormat.forPattern("yyyyMMddEE").withLocale(Locale.US);
    public static final String pattern = "yyyyMMdd";
    private static Logger LOG = LoggerFactory.getLogger(DateTimeUtil.class);

    /**
     * 是否是工作日.
     *
     * @param date
     * @return
     */
    public static boolean isWeekDay(String date) {
        DateTime dt = FLIGHT_DATE_FORMAT.parseDateTime(date);
        if (!date.contains(dt.toString(pattern))) {
            LOG.error("date time not equals weekday!");
            throw new DateTimeException("date time not equals weekday!");
        }

        DayOfWeek day = DayOfWeek.of(dt.getDayOfWeek());
        if (DayOfWeek.SUNDAY.equals(day) || DayOfWeek.SATURDAY.equals(day)) {
            return false;
        } else {
            return true;
        }
    }


}