package com.example.boking.repository;

import com.example.boking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    @Query("""
            select u from User u
            where u.email = :username
            """)
    Optional<User> findByEmail(String email);

    Optional<User> findByKeycloakId(String keycloakId);

}


