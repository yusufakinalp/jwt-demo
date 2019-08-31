package com.yusuf.gateway.repository;

import com.yusuf.gateway.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
}
