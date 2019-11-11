/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

package com.yingbo.model;

import com.yingbo.util.DateTimeUtil;

import java.util.Comparator;

/**
 * 航班基本信息.
 *
 * @author shanyingbo
 * @version $Id FlightInfo.java, v 0.1 2018-04-06 下午12:22 shanyingbo Exp $$
 */
public class FlightInfo  {

  public Double weekDaysReward;
  public Double weekDaysRegular;
  public Double weekendsRegular;
  public Double weekendsReward;
  private String flightNo;
  private String sched;
  private String fromAddr;
  private String toAddr;
  private Type type;

  public Double getWeekDaysReward() {
    return weekDaysReward;
  }

  public FlightInfo setWeekDaysReward(Double weekDaysReward) {
    this.weekDaysReward = weekDaysReward;
    return this;
  }

  public Double getWeekDaysRegular() {
    return weekDaysRegular;
  }

  public FlightInfo setWeekDaysRegular(Double weekDaysRegular) {
    this.weekDaysRegular = weekDaysRegular;
    return this;
  }

  public Double getWeekendsRegular() {
    return weekendsRegular;
  }

  public FlightInfo setWeekendsRegular(Double weekendsRegular) {
    this.weekendsRegular = weekendsRegular;
    return this;
  }

  public Double getWeekendsReward() {
    return weekendsReward;
  }

  public FlightInfo setWeekendsReward(Double weekendsReward) {
    this.weekendsReward = weekendsReward;
    return this;
  }

  public String getFlightNo() {
    return flightNo;
  }

  public void setFlightNo(String flightNo) {
    this.flightNo = flightNo;
  }

  public String getSched() {
    return sched;
  }

  public void setSched(String sched) {
    this.sched = sched;
  }

  public String getFromAddr() {
    return fromAddr;
  }

  public void setFromAddr(String fromAddr) {
    this.fromAddr = fromAddr;
  }

  public String getToAddr() {
    return toAddr;
  }

  public void setToAddr(String toAddr) {
    this.toAddr = toAddr;
  }

  public Type getType() {
    return type;
  }

  public FlightInfo setType(Type type) {
    this.type = type;
    return this;
  }

  @Override
  public String toString() {
    return "FlightInfo{" +
            "weekDaysReward=" + weekDaysReward +
            ", weekDaysRegular=" + weekDaysRegular +
            ", weekendsRegular=" + weekendsRegular +
            ", weekendsReward=" + weekendsReward +
            ", flightNo='" + flightNo + '\'' +
            ", sched='" + sched + '\'' +
            ", fromAddr='" + fromAddr + '\'' +
            ", toAddr='" + toAddr + '\'' +
            ", type=" + type +
            '}';
  }


  public enum Type {
    //正向航班
    Positive,
    //反向航班
    Negative
  }
}