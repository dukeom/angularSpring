package com.example.angularStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.angularStudy.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

}
