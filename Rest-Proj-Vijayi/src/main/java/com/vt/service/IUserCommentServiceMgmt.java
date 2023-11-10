//IUserCommentServiceMgmt.java
package com.vt.service;

import java.util.List;
import com.vt.entity.User;

public interface IUserCommentServiceMgmt {
	
	//this method will allow us to add new comments from user class 
	public String saveUserComment(User user);
	
	//this method will allow us to view all the user comments
	public List getAllUserCommentsWithUserId(String comment_to);
	

}//interface
