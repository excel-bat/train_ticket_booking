/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */
package com.yingbo.business;

import com.google.common.collect.Ordering;
import com.yingbo.model.FlightInfo;
import com.yingbo.strategy.PackageStragegy;
import com.yingbo.strategy.impl.DefaultPackageStrategy;

/**
 * @author shanyingbo
 * @version $Id Customer.java, v 0.1 2018-04-06 上午10:38 shanyingbo Exp $$
 */
public class Customer {

    /**
     * 出发日期
     */
    String departingDate;

    /**
     * 回来日期
     */
    String returningDate;

    /**
     * 打包方案
     */
    PackageStragegy packageStragegy;

    String customerType;

    public Customer() {
    }

    public String getCustomerType() {
        return customerType;
    }

    public Customer setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getDepartingDate() {
        return departingDate;
    }

    public Customer setDepartingDate(String departingDate) {
        this.departingDate = departingDate;
        return this;
    }

    public String getReturningDate() {
        return returningDate;
    }

    public Customer setReturningDate(String returningDate) {
        this.returningDate = returningDate;
        return this;
    }

    public PackageStragegy getPackageStragegy() {
        return packageStragegy;
    }

    public Customer setPackageStragegy(PackageStragegy packageStragegy) {
        this.packageStragegy = packageStragegy;
        return this;
    }

    /**
     * 使用默认策略
     *
     * @return
     */
    public String queryFlightInfo() {
        packageStragegy = new DefaultPackageStrategy();
        return packageStragegy.clac(this);
    }

    public Ordering<FlightInfo> generateOrder(String dates) {
        return null;
    }

}