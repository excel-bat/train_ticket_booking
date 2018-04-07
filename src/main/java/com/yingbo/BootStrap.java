package com.yingbo; /**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.yingbo.business.Customer;
import com.yingbo.business.CustomerFactory;
import com.yingbo.model.FlightInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * @author shanyingbo
 * @version $Id BootStrap.java, v 0.1 2018-04-06 上午12:10 shanyingbo Exp $$
 */
public class BootStrap {

    public static List<FlightInfo> flightInfoPositiveList = Lists.newArrayList();
    public static List<FlightInfo> flightInfoNegativeList = Lists.newArrayList();
    private static Logger LOG = LoggerFactory.getLogger(BootStrap.class);

    /**
     * 初始化航班信息
     */
    static {
        //use try-with-resources
        try (Reader reader = new InputStreamReader(BootStrap.class.getResourceAsStream("/init.json"), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            //简洁 不使用匿名内部类
            Type collectionType = new TypeToken<Collection<FlightInfo>>() {
            }.getType();
            List<FlightInfo> flightInfos = gson.fromJson(reader, collectionType);
            flightInfos.forEach(flightInfo -> {
                if (FlightInfo.Type.Negative.equals(flightInfo.getType())) {
                    flightInfoNegativeList.add(flightInfo);
                } else {
                    flightInfoPositiveList.add(flightInfo);
                }
            });
        } catch (IOException e) {
            LOG.error("file open failed !");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请按如下格式输入：<CUSTOMER_TYPE>, <DEPARTING_DATE>, <RETURNING_DATE>");
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] customerInput = input.split(", ");

            try {
                if (ArrayUtils.isNotEmpty(customerInput) && customerInput.length < 4) {
                    LOG.info("输入的客户信息如下- CUSTOMER_TYPE:{},DEPARTING_DATE:{},RETURNING_DATE:{}", customerInput[0],
                            customerInput[1], customerInput[2]);
                    Customer customer = CustomerFactory.buildCustomer(customerInput[0], customerInput[1]
                            , customerInput[2]);
                    System.out.println(customer.queryFlightInfo());
                } else {
                    LOG.error("输入长度不合法！");
                }
            } catch (Throwable e) {
                LOG.error("请检查输入是否合法", e);
            }
        }
    }
}