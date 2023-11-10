//ICommentRepository.java
package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vt.entity.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Integer>{

}//interface
