package com.lyx.riska.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/riska")
@Slf4j
public class RiskAController {

    @GetMapping("/{id}")
    public Boolean checkRiskItem(@PathVariable(value = "id") Long accId, @RequestParam Integer ms) {
        log.info("id<{}>, ms<{}>", accId, ms);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("id<{}> done", accId);
        return true;
    }

}
