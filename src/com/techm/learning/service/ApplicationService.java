package com.techm.learning.service;

import com.techm.learning.exception.LPException;
import com.techm.learning.model.LPFeedback;

public interface ApplicationService {

	void captureFeedback(LPFeedback lPFeedback) throws LPException;

}
