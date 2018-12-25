package com.lyx.lab.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyx.lab.model.User;
import com.lyx.lab.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(UserController.class)
//@AutoConfigureMockMvc
@Log4j2
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserById() throws Exception {
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
        user.setId(3L);
        user.setName("orange");
        user.setPassword("ORANGE");

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