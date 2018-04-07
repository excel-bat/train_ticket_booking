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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;


/**
 * 最低价打包策略.
 *
 * @author shanyingbo
 * @version $Id LowPricePackageStrategy.java, v 0.1 2018-04-06 上午11:13 shanyingbo Exp $$
 */
public class LowPricePackageStrategy implements PackageStragegy {

  private static Logger LOG = LoggerFactory.getLogger(LowPricePackageStrategy.class);

  /**
   * 计算最低价.
   *
   * @param customer customer
   * @return
   */
  @Override
  public String clac(Customer customer) {

    //正向航班
    String departNo = getLowPriceFlightNo(customer.getDepartingDate(),
            BootStrap.flightInfoPositiveList, customer);
    //反向航班
    String returnNo = getLowPriceFlightNo(customer.getReturningDate(),
            BootStrap.flightInfoNegativeList, customer);
    return departNo + "," + returnNo;
  }

  /**
   * 获取低价的航班号.
   *
   * @param dates    dates
   * @param list     list
   * @param customer customer
   * @return
   */
  public String getLowPriceFlightNo(String dates, List<FlightInfo> list, Customer customer) {

    if (CollectionUtils.isEmpty(list)) {
      LOG.error("filght info list is empty");
      return "";
    }
    //回调customer 得到排序类
    Ordering<FlightInfo> ordering = customer.generateOrder(dates);
    List<FlightInfo> flightInfos = ordering.compound(new Comparator<FlightInfo>() {
      @Override
      public int compare(FlightInfo o1, FlightInfo o2) {
        return DateTimeUtil.compareCloseTime(o1.getSched(), o2.getSched());
      }
    }).sortedCopy(list);

    //取出第一个元素作为返回值
    FlightInfo f = CollectionUtils.get(flightInfos, 0);
    return f != null ? f.getFlightNo() : "";
  }
}