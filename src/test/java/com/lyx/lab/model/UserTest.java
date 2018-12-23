package com.lyx.lab.model;

import com.lyx.lab.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        User user = new User();
        user.setId(1L);
        user.setName("XXX");
        user.setPassword("123456");
        userRepository.save(user);
    }
}