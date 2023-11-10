//IUserRepository.java
package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vt.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

}//interface
