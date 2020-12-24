package com.gagan.server.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gagan.server.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    // add custom queries here
}
