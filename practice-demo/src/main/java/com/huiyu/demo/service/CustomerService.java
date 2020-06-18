package com.huiyu.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.huiyu.demo.domain.CustomerInfo;

@Service
public class CustomerService {
    /**
     * customerCode肯定能查到phone
     * [a1,a2,a3] -> [{a1,18000000001},{a2,18000000002},{a3,18000000003}]
     */
    public List<CustomerInfo> getCustomerCodeFromApi(List<String> customerCodeList) {
        long base = 13000000000L;
        List<CustomerInfo> result = new ArrayList<>();
        for (String customerCode : customerCodeList) {
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setCustomerCode(customerCode);
            customerInfo.setPhone(String.valueOf(base + new Random().nextInt(10000000)));
            result.add(customerInfo);
        }
        return result;
    }

    /* *//**
     * custoemrCode有可能查到phone(可以认为是从mysql数据库查)
     *//*
    public List<CustomerInfo> getCustomerCodeListFromMysql(List<String> customerCodeList) {
        long base = 13000000000L;
        List<CustomerInfo> result = new ArrayList<>();
        for (String customerCode : customerCodeList) {
            if (new Random().nextInt(100) > 90) {
                continue;
            }
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setCustomerCode(customerCode);
            customerInfo.setPhone(String.valueOf(base + new Random().nextInt(10000000)));
            result.add(customerInfo);
        }
        return result;
    }

    *//**
     * 将customerCode更新到mysql数据库
     *//*
    public void updateCustomerCode2Mysql(Map<String, String> cache) {
        //可以认为里面有代码, 方法一定能调用成功
    }*/
}
