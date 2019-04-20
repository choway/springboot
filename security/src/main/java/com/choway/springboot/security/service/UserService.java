package com.choway.springboot.security.service;

import com.choway.springboot.security.model.User;

public interface UserService {

	User findByUsername(String username);

}
