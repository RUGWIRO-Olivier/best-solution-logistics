package com.bestSolutionCargo.repository;

import com.bestSolutionCargo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    @Query(value ="SELECT * from User WHERE role='ROLE_MANAGER'", nativeQuery = true)
    List<User> getManagers();
}
