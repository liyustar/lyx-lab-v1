package com.lyx.lab.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyx.lab.model.Account;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest // 影响数据库使用
@AutoConfigureMockMvc   // 影响数据库使用
//@WebMvcTest(AccountController.class) // 需要MockBean Repository，不影响数据库
@Log4j2
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean  // 需要MockBean Repository，不影响数据库
//    private AccountRepository accountRepository;

    @Test
    public void getAccountById() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/accounts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
//                .andExpect(content().string(containsString("Hello World")));
        log.info("account<{}>", result.getResponse().getContentAsString());
    }

    @Test
    public void createAccount() throws Exception {
        Account account = new Account();
        account.setId(1L);
        account.setAccCode("acc001");
        account.setAccType("1");

        MvcResult result = this.mockMvc
                .perform(
                        post("/accounts")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(JSONObject.toJSONString(account))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
//                .andExpect(content().string(containsString("Hello World")));
        log.info("account<{}>", result.getResponse().getContentAsString());
    }
}