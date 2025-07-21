package com.arpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpo.models.User;



public interface IUserRepository extends JpaRepository<User, Long> {

}
