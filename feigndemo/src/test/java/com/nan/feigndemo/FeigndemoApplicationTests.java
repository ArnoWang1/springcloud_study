package com.nan.feigndemo;

import com.nan.feigndemo.client.HelloServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FeigndemoApplication.class})
public class FeigndemoApplicationTests {

    @Autowired
    private HelloServiceClient helloService;

    @Test
    public void testHello() {
        String result = helloService.hello("王金楠");
        System.err.println(result);
    }

}
