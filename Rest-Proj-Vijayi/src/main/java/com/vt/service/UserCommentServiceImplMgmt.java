//UserCommentServiceImplMgmt.java
package com.vt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.entity.Comment;
import com.vt.entity.User;
import com.vt.repository.ICommentRepository;
import com.vt.repository.IUserRepository;

@Service
public class UserCommentServiceImplMgmt implements IUserCommentServiceMgmt {
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private ICommentRepository commentRepo;

	@Override
	public String saveUserComment(User user) {
		//saving the input User object to the database by using pre-defined method save(-)
		userRepo.save(user);
		//returning the confirmation comment to the end-user
		return "Comment added successfully....!!!!!";
	}//method
	
	@Override
	public List getAllUserCommentsWithUserId(String comment_to) {
		//creating empty arrayList object
		List<Comment> listCom = new ArrayList<Comment>();
		//getting all the user objects from the db and storing in Iterable type collection
		Iterable<User> it = userRepo.findAll();
		//iterating the collection to get each user object 
		it.forEach(user->{
			//logic for matching input comment_to with each User object and getting the User id
			if(user.getComment_to().equals(comment_to)){
				int user_id = user.getUserId();  // getting each user obj user id
				//passing user id to method to get single user object and holding the obj in the Optional object to avoid NPE
				Optional<User> opt = userRepo.findById(user_id);
				if(opt.isPresent()) {
					//getting User object after satisfying if condition
					User u = opt.get();
					//getting the respective Comment object from the User object recieved
					List<Comment> list = u.getComment();
					//iterating the list of Comment object
					list.forEach(com->{
						//new Comment object created with required args constructor
						Comment c = new Comment(com.getComment_id(), com.getMessage(), com.getComment_date_time(),
													new User(com.getUserInfo().getUserId(), com.getUserInfo().getComment_from(), com.getUserInfo().getComment_to()));
						//adding the modified each new Comment object to the list collections per iteration
						listCom.add(c);
					});						
				}//if
			}//if
		});
		//returning the list of new Comment object as required for the output results
		return listCom;
	}//method
	
	
	

}//class
