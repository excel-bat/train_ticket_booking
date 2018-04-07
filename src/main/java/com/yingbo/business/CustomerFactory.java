/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

package com.yingbo.business;

import com.google.common.base.CaseFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 客户工厂类.
 *
 * @author shanyingbo
 * @version $Id CustomerFactory.java, v 0.1 2018-04-06 上午11:40 shanyingbo Exp $$
 */
public final class CustomerFactory {

  private static Logger LOG = LoggerFactory.getLogger(CustomerFactory.class);

  public CustomerFactory() {

  }

  /**
   * 构造Customer.
   *
   * @param customerType   customerType
   * @param departingDate  departingDate
   * @param returnningDate returnningDate
   * @return
   */
  public static Customer buildCustomer(String customerType,
                                       String departingDate, String returnningDate) {

    Customer customer = new Customer();

    try {
      Class<?> customerClass = Thread.currentThread()
              .getContextClassLoader().loadClass(generateClazzName(customerType));
      customer = (Customer) customerClass.newInstance();
      customer.setDepartingDate(departingDate)
              .setReturningDate(returnningDate).setCustomerType(customerType);

    } catch (ClassNotFoundException e) {
      LOG.error("unknow customer type!");
    } catch (IllegalAccessException e) {
      LOG.error("unknow IllegalAccessException type!");
    } catch (InstantiationException e) {
      LOG.error("unknow InstantiationException type!");
    }
    return customer;
  }

  /**
   * 生成类文件名.
   *
   * @param customerType customerType
   * @return
   */
  public static String generateClazzName(String customerType) {
    //这里用到CaseFormat，把方法名转换成驼峰标示（当然这里也可以自己动手去处理字符串）
    return CustomerFactory.class.getPackage().getName() + "."
            + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, customerType) + "Customer";
  }

}
