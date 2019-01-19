package com.lyx.lab.controller;

import com.lyx.lab.model.User;
import com.lyx.lab.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Log4j2
@Api("Swagger UserController 相关的 API")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
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
