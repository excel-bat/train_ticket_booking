/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */

import business.Customer;
import business.CustomerFactory;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.FlightInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author shanyingbo
 * @version $Id BootStrap.java, v 0.1 2018-04-06 上午12:10 shanyingbo Exp $$
 */
public class BootStrap {

    static Map<String, FlightInfo> flightInfoPositiveMap = Maps.newHashMap();
    static Map<String, FlightInfo> flightInfoNegativeMap = Maps.newHashMap();

    private static Logger LOG = LoggerFactory.getLogger(BootStrap.class);


    public static void main(String[] args) {

        Customer customer = CustomerFactory.buildCustomer("REWARD", "20160410SUN"
                , "20160420WED");
        LOG.info(customer.queryFlightInfo());
    }

    /**
     * 初始化航班信息
     */
    static void init() {
        //use try-with-resources
        try (Reader reader = new InputStreamReader(BootStrap.class.getResourceAsStream("/init.json"), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            //简洁 不使用匿名内部类
            Type collectionType = new TypeToken<Collection<FlightInfo>>() {
            }.getType();
            List<FlightInfo> flightInfos = gson.fromJson(reader, collectionType);
            flightInfos.forEach(flightInfo -> {
                if (FlightInfo.Type.Negative.equals(flightInfo.getType())) {
                    flightInfoNegativeMap.put(flightInfo.getFlightNo(), flightInfo);
                } else {
                    flightInfoPositiveMap.put(flightInfo.getFlightNo(), flightInfo);
                }
            });
        } catch (IOException e) {
            LOG.error("file open failed !");
        }
    }
}