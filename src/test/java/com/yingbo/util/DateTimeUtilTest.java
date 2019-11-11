package com.yingbo.util;

import org.junit.Test;

import java.time.DateTimeException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateTimeUtilTest {

  /**
   * 周内
   */
  @Test
  public void shouldIsWeekDayTrue() {
    //given
    String departingDate = "20160412TUE";
    //when
    boolean res = DateTimeUtil.isWeekDay(departingDate);
    //then
    assertTrue(res);

  }

  /**
   * 周末
   */
  @Test
  public void shouldIsWeekDayFalse() {
    //given
    String departingDate = "20160416SAT";
    //when
    boolean res = DateTimeUtil.isWeekDay(departingDate);
    //then
    assertFalse(res);

  }

  /**
   * 日期和星期不相等
   */
  @Test(expected = DateTimeException.class)
  public void shouldIsWeekDayNotEquals() {
    //given
    String departingDate = "20160414TUE";
    //when
    boolean res = DateTimeUtil.isWeekDay(departingDate);
    //then
    assertTrue(res);
  }


  /**
   * 格式错误
   */
  @Test(expected = IllegalArgumentException.class)
  public void shouldIsWeekDayFormatError() {
    //given
    String departingDate = "2016d414TUP";
    //when
    boolean res = DateTimeUtil.isWeekDay(departingDate);
    //then
    assertTrue(res);
  }


  /**
   * Method: compareCloseTime(String sched, String sched1)
   */
  @Test
  public void testCompareCloseTime() {

    //when
    int c = DateTimeUtil.compareCloseTime("8:25", "23:10");
    //then
    assertTrue(c > 0);

  }
}