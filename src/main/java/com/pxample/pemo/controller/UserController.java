package com.pxample.pemo.controller;

import com.pxample.pemo.pojo.model.User;
import com.pxample.pemo.pojo.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {


    @MessageMapping("/user")
    @SendTo("/ppdouble-broker/user") // the client will subscribe /ppdouble-broker/user
    public UserResponse getUser(User user) {
        return new UserResponse("Hello, " + user.getName());
    }
}
