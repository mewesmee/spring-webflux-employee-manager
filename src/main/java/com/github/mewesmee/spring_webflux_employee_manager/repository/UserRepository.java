package com.github.mewesmee.spring_webflux_employee_manager.repository;

import com.github.mewesmee.spring_webflux_employee_manager.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
