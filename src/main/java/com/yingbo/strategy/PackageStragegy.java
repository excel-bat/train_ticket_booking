/**
 * Copyright (C) 2004-2018 All Rights Reserved.
 */

package com.yingbo.strategy;

import com.yingbo.business.Customer;

/**
 * 打包策略接口.
 *
 * @author shanyingbo
 * @version $Id PackageStragegy.java, v 0.1 2018-04-06 上午10:02 shanyingbo Exp $$
 */
public interface PackageStragegy {

  /**
   * 根据客户计算订票策略.
   *
   * @param customer customer
   * @return
   */
  String clac(Customer customer);


}