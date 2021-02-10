package org.homeboy.spring.controllers;

import org.homeboy.spring.repository.UserRepository;
import org.homeboy.spring.domains.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author Tintin-Mask
 */
@RestController
public class HomeboyController {

    @Resource
    private UserRepository userRepository;

    @PostMapping("/user/save")
    public User createUser(@RequestParam final String name)
    {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
