package com.lyx.lab.controller;

import com.lyx.lab.model.User;
import com.lyx.lab.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        log.info("id<{}>", userId);
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User:" + "id=" + userId));
    }

    @PostMapping()
    public User createUser(@Valid @RequestBody User user) {
        log.info("user<{}>", user);
        return userRepository.save(user);
    }

}
