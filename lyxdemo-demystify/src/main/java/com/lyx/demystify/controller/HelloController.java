package com.lyx.demystify.controller;

import com.lyx.demystify.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
@Slf4j
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping
    public String hello() {
        return helloService.hello();
    }

}
