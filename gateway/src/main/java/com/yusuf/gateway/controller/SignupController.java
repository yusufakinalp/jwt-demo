package com.yusuf.gateway.controller;

import com.yusuf.gateway.model.User;
import com.yusuf.gateway.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignupController {


    @Autowired
    private ILoginService iLoginService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<User> signup(@RequestBody User user) {

        return ResponseEntity.ok().body(iLoginService.saveUser(user));
    }
}
