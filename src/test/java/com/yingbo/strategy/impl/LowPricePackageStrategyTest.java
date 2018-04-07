package com.yingbo.strategy.impl;

import com.yingbo.BootStrap;
import com.yingbo.business.RewardCustomer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowPricePackageStrategyTest {


    @Test
    public void shouldGetLowPriceFlightNo() {
        //given
        LowPricePackageStrategy lowPricePackageStrategy = new LowPricePackageStrategy();
        //when
        String flightNo = lowPricePackageStrategy.getLowPriceFlightNo("20160410SUN", BootStrap.flightInfoPositiveList, new RewardCustomer().setCustomerType("REWARD"));
        //then
        assertEquals("GD8732", flightNo);

    }

}