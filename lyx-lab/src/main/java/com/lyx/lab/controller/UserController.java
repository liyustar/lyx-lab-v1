package com.lyx.lab.controller;

import com.lyx.lab.annotation.TrackTime;
import com.lyx.lab.constants.CatMetricConst;
import com.lyx.lab.model.User;
import com.lyx.lab.repository.UserRepository;
import com.lyx.lab.util.CatProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Log4j2
@Api("Swagger UserController 相关的 API")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CatProxy catProxy;

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        log.info("id<{}>", userId);
        catProxy.logMetricForCount(CatMetricConst.USER_QUERY_COUNT, 1);
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User:" + "id=" + userId));
    }

    @PostMapping()
    public User createUser(@Valid @RequestBody User user) {
        log.info("user<{}>", user);
        return userRepository.save(user);
    }

    @TrackTime
    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
