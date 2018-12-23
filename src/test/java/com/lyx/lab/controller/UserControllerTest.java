package com.lyx.lab.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Log4j2
public class UserControllerTest {

    @MockBean
    private MockMvc mockMvc;

    @Test
    public void getUserById() throws Exception {
        MvcResult result = this.mockMvc.perform(get("users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
//                .andExpect(content().string(containsString("Hello World")));
        log.info("user<{}>", result.getResponse().getContentAsString());
    }

    @Test
    public void createUser() {
    }
}