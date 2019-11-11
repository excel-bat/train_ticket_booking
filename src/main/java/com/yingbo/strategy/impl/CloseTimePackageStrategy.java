/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */


package com.yingbo.strategy.impl;

import com.google.common.collect.Ordering;
import com.yingbo.BootStrap;
import com.yingbo.business.Customer;
import com.yingbo.model.FlightInfo;
import com.yingbo.strategy.PackageStragegy;
import com.yingbo.util.DateTimeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.joda.time.DateTime;

import java.util.Comparator;
import java.util.List;

/**
 * 接近时间的考虑
 *
 * @author shanyingbo
 * @version $Id CloseTimePackageStrategy.java, v 0.1 2018-04-13 上午10:24 shanyingbo Exp $$
 */
public class CloseTimePackageStrategy implements PackageStragegy {


  /**
   * @param customer customer
   * @return
   */
  @Override
  public String clac(Customer customer) {
    //正向航班
    String departNo = getCloseTimeFlightNo(customer.getDepartingDate(),
            BootStrap.flightInfoPositiveList, customer);
    //反向航班
    String returnNo = getCloseTimeFlightNo(customer.getReturningDate(),
            BootStrap.flightInfoNegativeList, customer);
    return departNo + "," + returnNo;
  }


  private String getCloseTimeFlightNo(String dates, List<FlightInfo> lists, Customer customer) {

    //比较日期接近当前日期的
    //回调customer 得到排序类
    List<FlightInfo> flightInfos = new Ordering<FlightInfo>() {
      @Override
      public int compare(FlightInfo o1, FlightInfo o2) {
        return DateTimeUtil.compareCloseTime(o1.getSched(), o2.getSched());
      }
    }.sortedCopy(lists);
    //取出第一个元素作为返回值
    FlightInfo f = CollectionUtils.get(flightInfos, 0);
    return f != null ? f.getFlightNo() : "";
  }


}