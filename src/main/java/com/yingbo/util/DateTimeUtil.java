/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

package com.yingbo.util;

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

  public static final DateTimeFormatter FLIGHT_DATE_FORMAT
          = DateTimeFormat.forPattern("yyyyMMddEE").withLocale(Locale.US);

  public static final DateTimeFormatter FLIGHT_TIME_FORMAT = DateTimeFormat.forPattern("HH:mm");

  public static final String PATTERN = "yyyyMMdd";

  private static Logger LOG = LoggerFactory.getLogger(DateTimeUtil.class);

  /**
   * 是否是工作日.
   *
   * @param date date
   * @return
   */
  public static boolean isWeekDay(String date) {
    DateTime dt = FLIGHT_DATE_FORMAT.parseDateTime(date);
    if (!date.contains(dt.toString(PATTERN))) {
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


  /**
   * 比较哪个时间接近12：00PM.
   *
   * @param sched  sched
   * @param sched1 shec1
   * @return
   */
  public static int compareCloseTime(String sched, String sched1) {
    DateTime d1 = FLIGHT_TIME_FORMAT.parseDateTime(sched);
    DateTime d2 = FLIGHT_TIME_FORMAT.parseDateTime(sched1);
    return d2.minusHours(24).compareTo(d1.minusHours(24));
  }
}