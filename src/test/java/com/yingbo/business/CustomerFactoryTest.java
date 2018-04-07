package com.yingbo.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerFactoryTest {

  @Test
  public void shouldBuildCustomer() {

    Customer customer = CustomerFactory.buildCustomer("REWARD", "20150503WEN", "20180630MON");
    assertTrue(customer instanceof RewardCustomer);
  }

  @Test
  public void shouldGenerateClazzName() {
    String customerType = "REWARD";
    String rewardCustomer = CustomerFactory.generateClazzName(customerType);
    assertEquals("com.yingbo.business.RewardCustomer", rewardCustomer);
  }
}