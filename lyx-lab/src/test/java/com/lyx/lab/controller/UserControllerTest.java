package com.lyx.lab.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyx.lab.model.User;
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
//@WebMvcTest(UserController.class) // 需要MockBean Repository，不影响数据库
@Log4j2
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean  // 需要MockBean Repository，不影响数据库
//    private UserRepository userRepository;

    @Test
    public void getUserById() throws Exception {
        User user = new User();
        user.getName();
        MvcResult result = this.mockMvc.perform(get("/users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
//                .andExpect(content().string(containsString("Hello World")));
        log.info("user<{}>", result.getResponse().getContentAsString());
    }

    @Test
    public void createUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("apple");
        user.setPassword("APPLE");

        MvcResult result = this.mockMvc
                .perform(
                        post("/users")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(JSONObject.toJSONString(user))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
//                .andExpect(content().string(containsString("Hello World")));
        log.info("user<{}>", result.getResponse().getContentAsString());
    }
}