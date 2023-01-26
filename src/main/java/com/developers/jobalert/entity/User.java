package com.developers.jobalert.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "JOB_ALERT_ID")
	private String jobAlertId;
	@Column(name = "FULL_NAME")
	private String fullName;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "MOBILE_NUMBER")
	private Long mobileNumber;
	@Column(name = "WORK_STATUS")
	private String workStaus;
	@Column(name = "RESUME")
	private String resume;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	@Column(name = "STATUS")
	private String status="ACTIVE";
	@Column(name = "ISLOCKED")
	private boolean isLocked;
	
}
