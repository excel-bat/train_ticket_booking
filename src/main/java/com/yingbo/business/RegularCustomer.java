/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

package com.yingbo.business;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.yingbo.model.FlightInfo;
import com.yingbo.strategy.impl.LowPricePackageStrategy;
import com.yingbo.util.DateTimeUtil;

/**
 * regular 客户.
 *
 * @author shanyingbo
 * @version $Id RegularCustomer.java, v 0.1 2018-04-06 上午11:41 shanyingbo Exp $$
 */
public class RegularCustomer extends Customer {


  @Override
  public String queryFlightInfo() {
    packageStragegy = new LowPricePackageStrategy();
    return packageStragegy.clac(this);
  }

  @Override
  public Ordering<FlightInfo> generateOrder(String dates) {
    if (DateTimeUtil.isWeekDay(dates)) {
      return Ordering.natural().nullsLast().onResultOf(new Function<FlightInfo, Double>() {
        public Double apply(FlightInfo foo) {
          return foo.weekDaysRegular;
        }
      });
    } else {
      return Ordering.natural().nullsLast().onResultOf(new Function<FlightInfo, Double>() {
        public Double apply(FlightInfo foo) {
          return foo.weekendsRegular;
        }
      });

    }

  }
}