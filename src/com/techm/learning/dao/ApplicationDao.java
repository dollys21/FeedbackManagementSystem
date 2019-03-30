package com.techm.learning.dao;

import org.springframework.stereotype.Repository;

import com.techm.learning.exception.LPException;
import com.techm.learning.model.LPFeedback;
import com.techm.learning.model.LPUser;

@Repository
public interface ApplicationDao {

	LPUser findByUserName(String username);

	void captureFeedback(LPFeedback lPFeedback);
	

	
}