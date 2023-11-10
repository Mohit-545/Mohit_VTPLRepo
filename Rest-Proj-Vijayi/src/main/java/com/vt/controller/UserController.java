//UserController.java
package com.vt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vt.entity.Comment;
import com.vt.entity.User;
import com.vt.service.UserCommentServiceImplMgmt;

@RestController
@RequestMapping("/userApi")
public class UserController {
	@Autowired
	private UserCommentServiceImplMgmt service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addComments(@RequestBody User user){
		try {
			String msg = service.saveUserComment(user);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}//try
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	
	
	@GetMapping("/get/{comment_to}")
	public ResponseEntity<?> getComments(@PathVariable String comment_to){
		try {
			List list = service.getAllUserCommentsWithUserId(comment_to);
			return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
		}//try
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	

}//class
