//Comment.java
package com.vt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VIJAYI_REST_COMMENT_TABLE")
public class Comment {
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "COMMNET_SEQ1", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer comment_id;
	
	@Column(length = 50)
	private String message;
	
	@Column
	private LocalDateTime comment_date_time = LocalDateTime.now();
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private User userInfo;

	
	/*public Comment(Integer comment_id, String message, LocalDateTime comment_Date_Time) {
		this.comment_id=comment_id;
		this.message=message;
		this.comment_date_time=comment_Date_Time;
	}//constructor
	*/	
}//class
