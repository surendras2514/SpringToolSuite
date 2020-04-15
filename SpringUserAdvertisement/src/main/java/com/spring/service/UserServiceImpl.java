package com.spring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.UserEntity;
import com.spring.json.User;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.UserUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		UserEntity userEntity = 
				userRepository.save(UserUtils.convertUserToUserEntity(user));
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	public List<User> getAllUsers() {
		List<UserEntity> userEntityList = userRepository.findAll();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	public User getUserById(String id) {
		
		
		
		UserEntity userEntity = userRepository.findById(Long.valueOf(id)).get();
		return UserUtils.convertUserEntityToUser(userEntity);
	}

	
	public List<User> getUsersByFirstName(String firstName) {
		List<UserEntity> userEntityList = userRepository.findByFirstName(firstName);
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}


	public User update(User user, String id) {
		UserEntity userEntity = userRepository.findById(Long.valueOf(id)).get();
		if(userEntity != null) {
			userEntity.setFirstName(user.getFirstName());
			userEntity.setUserName(user.getUserName());
			userEntity.setPassword(user.getPassword());
			userEntity = userRepository.save(userEntity);
			return UserUtils.convertUserEntityToUser(userEntity);
		}
		return null;
	}

	
	public boolean delete(String id) {
		if(userRepository.existsById(Long.valueOf(id))) {
			userRepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}


	public List<User> getUsersByOrderByFirstNameAsc() {
		List<UserEntity> userEntityList = userRepository.findByOrderByFirstNameAsc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}

	public List<User> getUsersByOrderByFirstNameDesc() {
		List<UserEntity> userEntityList = userRepository.findByOrderByFirstNameDesc();
		return UserUtils.convertUserEntityListToUserList(userEntityList);
	}
	
	
	public String login(User user) {
		String userName=user.getUserName();
		String password=user.getPassword();
		List<UserEntity> userLogin=userRepository.findByUserName(userName);
		UserEntity userEntity=userLogin.get(0);
		String loginPassword=userEntity.getPassword();
		if(userEntity.getUserName().equals(userName)) {
			if(loginPassword.equals(password)) {
				UUID uidd=UUID.randomUUID();
				String sessionId=uidd.toString().substring(0,8);
				userEntity.setSessionID(sessionId);
				userRepository.save(userEntity);
				return "{\"Login successful\",\"Your session id is:\" " +sessionId+"}";
			}	
			else
				return "{\"Incorrect password , please login again\"}";
		}
		return "{\"Login unsuccessful\",\"Invalid Username:\" " +userName+"}";	
	}

	public Boolean logout(long id,String authtoken) {
		
		if(userRepository.existsById(id)) {
			List<UserEntity> userlogout=userRepository.findById(id);
			String authtokenCheck=userlogout.get(0).getSessionID();
			if(authtokenCheck.equals(authtoken)) {
				userRepository.deleteById(Long.valueOf(id));
				return true;
			}
			return true;	
		}
		return false;
	}

	

}
