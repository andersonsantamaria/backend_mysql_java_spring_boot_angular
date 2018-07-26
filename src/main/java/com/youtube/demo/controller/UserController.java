package com.youtube.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.persistence.UserEntity;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.RestResponse;

@RestController
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	protected ObjectMapper objectMapper;
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
		this.objectMapper = new ObjectMapper();
		UserEntity userEntity = this.objectMapper.readValue(userJson, UserEntity.class);
		
		if(!this.validate(userEntity)){
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios no están diligenciados");
		}
		else{
			this.userService.save(userEntity);
			return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
		}
	}
	
	private boolean validate(UserEntity userEntity){
		boolean isValid = true;
		
		if(userEntity.getFirstName() == null){
			isValid = false;
		}
		
		if(userEntity.getFirstSurname() == null){
			isValid = false;
		}
		
		if(userEntity.getAddress() == null){
			isValid = false;
		}
		
		return isValid;
	}
}
