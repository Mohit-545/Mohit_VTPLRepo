//User.java
package com.vt.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VIJAYI_REST_USER_TABLE")
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer userId;

	@Column(length = 20)
	@Nonnull
	private String comment_from;

	@Column(length = 20)
	@Nonnull
	private String comment_to;
	
	@OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private List<Comment> comment;
	
	
	public User(Integer userId, String comment_from, String comment_to) {
		this.userId = userId;
		this.comment_from = comment_from;
		this.comment_to = comment_to;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", comment_from=" + comment_from + ", comment_to=" + comment_to + "]";
	}
	
	

}//class
