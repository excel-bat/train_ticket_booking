/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

package strategy.impl;

import business.Customer;
import strategy.PackageStragegy;

/**
 * 默认策略.
 *
 * @author shanyingbo
 * @version $Id DefaultPackageStrategy.java, v 0.1 2018-04-06 上午11:14 shanyingbo Exp.
 */
public class DefaultPackageStrategy implements PackageStragegy {

    @Override
    public String clac(Customer customer) {
        throw new UnsupportedOperationException("default package strategy is not support!");
    }
}