package com.yingbo.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerFactoryTest {

    @Test
    public void buildCustomer() {
    }

    @Test
    public void generateClazzName() {
        String customerType = "REWARD";
        String rewardCustomer = CustomerFactory.generateClazzName(customerType);
        assertEquals(rewardCustomer, "RewardCustomer");
    }
}