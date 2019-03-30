package com.techm.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.learning.dao.ApplicationDao;
import com.techm.learning.exception.LPException;
import com.techm.learning.model.LPFeedback;

/**
 * @author:DollyShaw
 *
 * @contact:DS00337934@TECHMAHINDRA.COM
 */

@Service
public class ApplicationServiceImpl implements ApplicationService{
	

	@Autowired
	private ApplicationDao applicationDao;
	
/*	@Autowired
	private FeedbackDao feedbackDao;*/
	
	/* (non-Javadoc)
	 * @see com.techm.learning.service.ApplicationService#captureFeedback(com.techm.learning.model.LPFeedback)
	 */
	@Override
	@Transactional
	public void captureFeedback(LPFeedback lPFeedback)throws LPException  {
		//feedbackDao.captureFeedback(lPFeedback);
		applicationDao.captureFeedback(lPFeedback);
		
		
	}
	

}
