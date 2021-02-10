package org.homeboy.spring.controllers;

import io.swagger.annotations.*;
import org.homeboy.spring.Repository.UserRepository;
import org.homeboy.spring.domains.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author Tintin-Mask
 */
@Api(tags = "User Controller")
@RestController
public class HomeboyController {

    @Resource
    private UserRepository userRepository;

    @PostMapping("/user/save")
    @ApiOperation(value = "swagger post test.", notes = "save user info.")
    public User createUser(
            @ApiParam(value = "user name") @RequestParam final String name)
    {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
