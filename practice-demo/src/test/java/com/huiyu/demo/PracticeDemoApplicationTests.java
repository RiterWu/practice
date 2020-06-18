package com.huiyu.demo;

import com.huiyu.demo.domain.CustomerInfo;
import com.huiyu.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class PracticeDemoApplicationTests {

    @Resource
    private CustomerService customerService;

    @Test
    void contextLoads() {
        List<CustomerInfo> list = customerService.getCustomerCodeFromApi(Arrays.asList("abc", "123"));
        log.info("list:{}", list);
    }

}
