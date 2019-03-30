package com.techm.learning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author:DollyShaw
 *
 * @contact:DS00337934@TECHMAHINDRA.COM
 */
@Entity
@Table(name = "lp_users")
public class LPUser implements Serializable{
	
	private static final long serialVersionUID = 1134370660137895733L;

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;
	
	@Column(name = "password", nullable = false, length = 60)
	private String password;
	
	@Column(name="email_id",nullable = false, length = 150)
	private String emailId;
	
	@Column(name="contact_number",nullable = false)
	private Integer contactNumber;

	@Column(name = "is_active", nullable = false)
	private boolean enabled;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<LPUserRole> userRole = new HashSet<LPUserRole>();
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<LPUserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<LPUserRole> userRole) {
		this.userRole = userRole;
	}

}
