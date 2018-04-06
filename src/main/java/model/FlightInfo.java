/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */
package model;

import java.math.BigDecimal;

/**
 * 航班基本信息
 *
 * @author shanyingbo
 * @version $Id FlightInfo.java, v 0.1 2018-04-06 下午12:22 shanyingbo Exp $$
 */
public class FlightInfo {

    private String flightNo;
    ;
    private String sched;
    private String fromAddr;
    private String toAddr;
    private Type type;
    private BigDecimal weekDaysReward;
    private BigDecimal weekDaysRegular;
    private BigDecimal weekendsRegular;
    private BigDecimal weekendsReward;

    public BigDecimal getWeekDaysReward() {
        return weekDaysReward;
    }

    public FlightInfo setWeekDaysReward(BigDecimal weekDaysReward) {
        this.weekDaysReward = weekDaysReward;
        return this;
    }

    public BigDecimal getWeekDaysRegular() {
        return weekDaysRegular;
    }

    public FlightInfo setWeekDaysRegular(BigDecimal weekDaysRegular) {
        this.weekDaysRegular = weekDaysRegular;
        return this;
    }

    public BigDecimal getWeekendsRegular() {
        return weekendsRegular;
    }

    public FlightInfo setWeekendsRegular(BigDecimal weekendsRegular) {
        this.weekendsRegular = weekendsRegular;
        return this;
    }

    public BigDecimal getWeekendsReward() {
        return weekendsReward;
    }

    public FlightInfo setWeekendsReward(BigDecimal weekendsReward) {
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
                "flightNo='" + flightNo + '\'' +
                ", sched='" + sched + '\'' +
                ", fromAddr='" + fromAddr + '\'' +
                ", toAddr='" + toAddr + '\'' +
                ", weekDaysReward=" + weekDaysReward +
                ", weekDaysRegular=" + weekDaysRegular +
                ", weekendsRegular=" + weekendsRegular +
                ", weekendsReward=" + weekendsReward +
                '}';
    }

    public enum Type {Positive, Negative}
}