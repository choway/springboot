package com.choway.springboot.security.service;

import com.choway.springboot.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		if (null == user)
			throw new UsernameNotFoundException("用户名不存在！");

		AuthUserDetails userDetails = new AuthUserDetails(user.getUsername(), user.getPassword(), user.isEnable());

		return userDetails;
	}

}
