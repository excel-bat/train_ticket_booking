/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

package strategy.impl;

import business.Customer;
import strategy.PackageStragegy;

/**
 * 最低价打包策略.
 *
 * @author shanyingbo
 * @version $Id LowPricePackageStrategy.java, v 0.1 2018-04-06 上午11:13 shanyingbo Exp $$
 */
public class LowPricePackageStrategy implements PackageStragegy {


    /**
     * 计算最低价
     *
     * @param customer
     * @return
     */
    @Override
    public String clac(Customer customer) {

        //根据用户类型先排序
        return null;
    }
}