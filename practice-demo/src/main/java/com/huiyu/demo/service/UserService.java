package com.huiyu.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiyu.demo.consts.DemoConsts;
import com.huiyu.demo.domain.CustomerInfo;
import com.huiyu.demo.domain.User;

/**
 * 需求: 完善groupUser和groupUserAndFillPhone方法
 */
@Service
public class UserService {

    @Autowired
    private CustomerService customerService;

    /**
     * 按照年龄分组, 30岁以下为"青年组", 30岁以上为"中年组", 过滤掉已删除(deleted=true)或不可用(enabled=false)用户
     */
    public Map<String, List<User>> groupUser(List<User> userList) {
        Map<String, List<User>> map = new HashMap<>();
        List<User> youngUser = new ArrayList<>(); // 青年组集合
        List<User> oldUser = new ArrayList<>(); // 中年组集合
        
        for (User user : userList) {
            Integer age = user.getAge();
            if (!user.getDeleted() && user.getEnabled()) { // 如果未删除并且用户可用
                if (age < 30) { // 年龄小于30
                    youngUser.add(user);
                } else {
                    oldUser.add(user);
                }
            }
        }

        map.put(DemoConsts.youthGroup, youngUser);// 青年组
        map.put(DemoConsts.oldGroup, oldUser);// 中年组

        return map;
    }

    /**
     * 按照年龄分组, 30岁以下为"青年组", 30岁以上为"中年组", 过滤掉已删除或不可用用户，并填充号码
     * 号码从CustomerService.getCustomerCodeFromApi 获取
     */
    public Map<String, List<User>> groupUserAndFillPhone(List<User> userList) {
        List<String> customerCodeList = new ArrayList<>();// 客户编号集合

        for (User user : userList) {
            String customerCode = user.getCustomerCode();
            customerCodeList.add(customerCode);// 获取用户中的客户编号并加入集合中
        }

        List<CustomerInfo> customerCodeFromApi = customerService.getCustomerCodeFromApi(customerCodeList);

        for (CustomerInfo customerInfo : customerCodeFromApi) {
            for (User user : userList) {
                String customerCodeByUser = user.getCustomerCode();// User用户的客户编号
                String customerCodeByCustomerInfo = customerInfo.getCustomerCode();// CustomerInfo客户信息中的客户编号
                if (Objects.equals(customerCodeByUser, customerCodeByCustomerInfo)) {
                    String phone = customerInfo.getPhone();
                    user.setPhone(phone);
                }
            }
        }

        Map<String, List<User>> groupUser = groupUser(userList);

        return groupUser;
    }
}
