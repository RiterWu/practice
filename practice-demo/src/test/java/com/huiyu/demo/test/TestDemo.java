package com.huiyu.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huiyu.demo.domain.User;
import com.huiyu.demo.service.CustomerService;
import com.huiyu.demo.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
class TestDemo {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CustomerService customerService;
    
    @Test
    void test() {
       List<User> userList = new ArrayList<>();
       
       for (int i = 0; i < 10; i++) {
           User user = new User();
           user.setEnabled((int)(Math.random()*2)==1 ? true:false);
           user.setDeleted((int)(Math.random()*2)==1 ? true:false);
           user.setAge((int)(Math.random()*50));
           user.setCustomerCode(String.valueOf(new Random().nextInt(100000)));
           userList.add(user);
       }
       
       for (User user : userList) {
           System.out.println(user);
       }
       
       System.out.println("-----------------------------------------------------------");
       Map<String, List<User>> groupUser = userService.groupUser(userList);
       
       for (Map.Entry<String, List<User>> entry : groupUser.entrySet()) {
           System.out.println("key = " + entry.getKey()+" ,values = "+ entry.getValue());
       }
       System.out.println("-----------------------------------------------------------");
       Map<String, List<User>> groupUserAndFillPhone = userService.groupUserAndFillPhone(userList);
       for (Map.Entry<String, List<User>> entry : groupUserAndFillPhone.entrySet()) {
           System.out.println("key = " + entry.getKey()+" ,values = "+ entry.getValue());
       }
       
    }
    
}
