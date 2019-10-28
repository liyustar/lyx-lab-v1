package com.lyx.demystify.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Description HelloControllerTest
 * @Author liyuxing
 * @Date 2019-10-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest // 影响数据库使用
@AutoConfigureMockMvc   // 影响数据库使用
@Slf4j
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        log.info("result<{}>", result.getResponse().getContentAsString());
    }
}