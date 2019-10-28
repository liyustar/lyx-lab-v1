package com.lyx.demystify.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description HelloService
 * @Author liyuxing
 * @Date 2019-09-20
 */
@Service
@Slf4j
public class HelloService {

    public static final String REST_URL_PREFIX = "http://localhost:8082";

    @Autowired
    private RestTemplate restTemplate;

    public String hello() {
        return "hello";
    }

}
