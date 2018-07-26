package com.youtube.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.demo.persistence.UserEntity;
import com.youtube.demo.persistencia.repositorio.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	protected UserRepository userRepository;

	@Override
	public UserEntity save(UserEntity userEntity) {
		return this.userRepository.save(userEntity);
	}
}
