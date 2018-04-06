/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */
package business;

import strategy.impl.LowPricePackageStrategy;

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
}