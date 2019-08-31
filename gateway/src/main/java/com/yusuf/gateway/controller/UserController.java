package com.yusuf.gateway.controller;

import com.yusuf.gateway.model.MongoUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class UserController {

    @GetMapping("/user")
    public ResponseEntity getSelf (@AuthenticationPrincipal MongoUserDetails mongoUserDetails){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", mongoUserDetails.getUsername());
        model.put("roles", mongoUserDetails.getAuthorities()
                .stream()
                .map(a -> a.getAuthority())
                .collect(toList())
        );
        return ok(model);
    }
}
