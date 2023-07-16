package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLoginOrEmail(String login, String email);
}
