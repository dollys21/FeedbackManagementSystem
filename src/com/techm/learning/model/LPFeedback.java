package com.techm.learning.model;



import javax.persistence.*;

@Entity
@Table(name="lp_feedback")
public class LPFeedback {
	
	@Id
	@Column(name="feedback_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private LPUser user;
	
	@Column(name="ownership",nullable=true,length=250)
	private Integer ownership;
	
	@Column(name="ownership_comment",nullable=true,length=250)
	private String ownershipComment;
	
	@Column(name="assertiveness",nullable=true,length=250)
	private Integer assertiveness;
	
	@Column(name="assertiveness_comment",nullable=true,length=250)
	private String assertivenessComment;
	
	@Column(name="management",nullable=true,length=250)
	private Integer management;
	
	@Column(name="management_comment",nullable=true,length=250)
	private String managementComment;
	
	@Column(name="overall_feedback",nullable=true,length=500)
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

	@Override
	public String toString() {
		return "LPFeedback [feedbackId=" + feedbackId + "\n"  +  ", ownership=" + ownership
				+ ", ownershipComment=" + ownershipComment + "\n" +   ", assertiveness=" + assertiveness
				+ ", assertivenessComment=" + assertivenessComment +  "\n" +  ", management=" + management
				+ ", managementComment=" + managementComment + "\n" +   ", overallFeedback=" + overallFeedback + "]";
	}
	
	
	
	

}
