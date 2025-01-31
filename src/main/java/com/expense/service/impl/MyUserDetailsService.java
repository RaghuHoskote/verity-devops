package com.expense.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expense.entity.MyUserPrincipal;
import com.expense.entity.User;
import com.expense.entity.repository.UserRepository;
/*
 * User Authentication implementation
 */

@Service
public class MyUserDetailsService implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;

	
	//String username = "Raghu";
	
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new MyUserPrincipal(user);
	}
}