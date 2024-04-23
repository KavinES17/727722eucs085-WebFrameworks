package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u WHERE u.userId = ?1")
    User findByUserId(int userId);

    @Query(value = "SELECT u FROM User u WHERE u.userName=?1")
    User findByUserName(String userName);
}
