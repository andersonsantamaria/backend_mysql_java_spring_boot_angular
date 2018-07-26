package com.youtube.demo.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.demo.persistence.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@SuppressWarnings("unchecked")
	UserEntity save(UserEntity userEntity);
}
