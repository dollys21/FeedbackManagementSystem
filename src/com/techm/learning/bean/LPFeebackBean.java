package com.techm.learning.bean;

import com.techm.learning.model.LPUser;

public class LPFeebackBean {

	private Integer feedbackId;
	
	private LPUser user;

	private Integer ownership;

	private String ownershipComment;

	private Integer assertiveness;

	private String assertivenessComment;

	private Integer management;

	private String managementComment;

	private String overallFeedback;

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public LPUser getUser() {
		return user;
	}

	public void setUser(LPUser user) {
		this.user = user;
	}

	public Integer getOwnership() {
		return ownership;
	}

	public void setOwnership(Integer ownership) {
		this.ownership = ownership;
	}

	public String getOwnershipComment() {
		return ownershipComment;
	}

	public void setOwnershipComment(String ownershipComment) {
		this.ownershipComment = ownershipComment;
	}

	public Integer getAssertiveness() {
		return assertiveness;
	}

	public void setAssertiveness(Integer assertiveness) {
		this.assertiveness = assertiveness;
	}

	public String getAssertivenessComment() {
		return assertivenessComment;
	}

	public void setAssertivenessComment(String assertivenessComment) {
		this.assertivenessComment = assertivenessComment;
	}

	public Integer getManagement() {
		return management;
	}

	public void setManagement(Integer management) {
		this.management = management;
	}

	public String getManagementComment() {
		return managementComment;
	}

	public void setManagementComment(String managementComment) {
		this.managementComment = managementComment;
	}

	public String getOverallFeedback() {
		return overallFeedback;
	}

	public void setOverallFeedback(String overallFeedback) {
		this.overallFeedback = overallFeedback;
	}

}
