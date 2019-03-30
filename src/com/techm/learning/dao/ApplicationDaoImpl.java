package com.techm.learning.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.techm.learning.exception.LPException;
import com.techm.learning.model.LPFeedback;
import com.techm.learning.model.LPUser;

/**
 * @author:DollyShaw
 *
 * @contact:DS00337934@TECHMAHINDRA.COM
 */
@Repository("ApplicationDao")
public class ApplicationDaoImpl implements ApplicationDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.techm.learning.dao.ApplicationDao#findByUserName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public LPUser findByUserName(String username) {

		List<LPUser> users = new ArrayList<LPUser>();

		users = getSessionFactory().getCurrentSession().createQuery("from LPUser where username=?")
				.setParameter(0, username).list();

		/*
		 * Criteria criteria =
		 * getSessionFactory().getCurrentSession().createCriteria(LPUser.class);
		 * criteria.createAlias("userRole", "u");
		 * criteria.add(Restrictions.eq("u.username", username)); users =
		 * criteria.list();
		 */

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

//	/*
//	 * @SuppressWarnings("unchecked") public LPAuthentication
//	 * findUserAuthbyUsername(String username) {
//	 * 
//	 * Query query = getSessionFactory().getCurrentSession().
//	 * createQuery("from LPAuthentication where user.username=?")
//	 * .setParameter(0, username);
//	 * 
//	 * Criteria criteria =
//	 * getSessionFactory().getCurrentSession().createCriteria(LPAuthentication.
//	 * class); criteria.createAlias("lpUser", "u");
//	 * criteria.add(Restrictions.eq("u.username", username));
//	 * 
//	 * List<LPAuthentication> userAuthList = criteria.list(); if(null !=
//	 * userAuthList && !userAuthList.isEmpty()) return userAuthList.get(0); else
//	 * return null; }
//	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void captureFeedback(LPFeedback lPFeedback) {
		
		
		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		 
		 
		System.out.println("LLLLLLLL"+ user.getUsername());
		System.out.println("LLLLDDD"+user.getAuthorities());
		
		LPUser myUser=getUser(user.getUsername());
		lPFeedback.setUser(myUser);
//		
//		LPFeedback k=new LPFeedback();
//		k.setAssertiveness(5);
//		k.setManagement(8);
//		k.setOwnership(2);
//		k.setOverallFeedback("llll");
		
		Session ss=sessionFactory.openSession();
		try{
			
			System.out.println("*********");
			
			ss.save(lPFeedback);
			
		
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			ss.close();
		}
		
		
	}
	
	
	private LPUser getUser(String username){

		List<LPUser> users = new ArrayList<LPUser>();
Session s=sessionFactory.openSession();

		try{users = s.createQuery("from LPUser where username=?")
				.setParameter(0, username).list();
		}catch(HibernateException e){
			
		}
		finally{
			s.close();
		}
		
		return  users.get(0);
		
	}

	
}