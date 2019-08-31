package com.yusuf.gateway.controller;


import com.yusuf.gateway.model.Role;
import com.yusuf.gateway.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/add-role")
    public ResponseEntity saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(roleRepository.save(role));
    }

    @GetMapping("/roles")
    public ResponseEntity getAllRoles() {
        return ResponseEntity.ok().body(roleRepository.findAll());
    }

}
