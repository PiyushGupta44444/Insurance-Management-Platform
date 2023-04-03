package com.insurancePolicy.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.insurancePolicy.Model.User;
import com.insurancePolicy.Repository.UserRepository;
import com.insurancePolicy.Security.CustomUserDetail;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username");
		}
		CustomUserDetail customUserDetail = new CustomUserDetail(user);
		return customUserDetail;
	}

}
