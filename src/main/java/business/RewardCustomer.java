/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */
package business;

import strategy.impl.LowPricePackageStrategy;

/**
 * reward 客户.
 *
 * @author shanyingbo
 * @version $Id RewardCustomer.java, v 0.1 2018-04-06 上午11:40 shanyingbo Exp $$
 */
public class RewardCustomer extends Customer {

    @Override
    public String queryFlightInfo() {
        packageStragegy = new LowPricePackageStrategy();
        return packageStragegy.clac(this);
    }
}