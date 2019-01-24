package com.lyx.lab.util;

import com.lyx.lab.constants.CatMetricConst;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatProxyTest {

    @Autowired
    private CatProxy catProxy;

    @Test
    public void logMetricForCount() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            catProxy.logMetricForCount(CatMetricConst.USER_QUERY_COUNT, 1);
            Thread.sleep(1000);
        }
    }
}