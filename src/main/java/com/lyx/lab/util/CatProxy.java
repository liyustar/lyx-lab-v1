package com.lyx.lab.util;

import com.dianping.cat.Cat;
import org.springframework.stereotype.Component;

@Component
public class CatProxy {

    public void logMetricForCount(String name, int quantity) {
        Cat.logMetricForCount(name, quantity);
    }

}
