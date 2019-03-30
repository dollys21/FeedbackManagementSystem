package com.techm.learning.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.techm.learning.dao.ApplicationDao;
import com.techm.learning.model.LPUser;
import com.techm.learning.model.LPUserRole;
import com.techm.learning.util.UserRoleType;

/**
 * @author:DollyShaw
 *
 * @contact:DS00337934@TECHMAHINDRA.COM
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ApplicationDao applicationDao;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		LPUser lpUser = applicationDao.findByUserName(username);
		if (null != lpUser) {
			List<GrantedAuthority> authorities = buildUserAuthority(lpUser.getUserRole());
			return buildUserForAuthentication(lpUser, authorities);
		} else {
			return null;
		}

	}

	private User buildUserForAuthentication(LPUser lpUser, List<GrantedAuthority> authorities) {

		User user = new User(lpUser.getUsername(), lpUser.getPassword(), lpUser.isEnabled(), true, true, true,
				authorities);
		return user;
	}

	private List<GrantedAuthority> buildUserAuthority(Set<LPUserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (LPUserRole userRole : userRoles) {
			UserRoleType role = UserRoleType.valueOf(userRole.getRoleName());
			setAuths.add(new SimpleGrantedAuthority(role.toCompareString()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

	public ApplicationDao getApplicationDao() {
		return applicationDao;
	}

	public void setApplicationDao(ApplicationDao aApplicationDao) {
		this.applicationDao = aApplicationDao;
	}

}