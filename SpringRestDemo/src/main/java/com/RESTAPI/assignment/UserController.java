package com.RESTAPI.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringRestDemo.Order;

@RestController
@RequestMapping("myiter")
public class UserController {
	
	@PostMapping(value="/users", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public User createNewUser(@RequestBody User user) {
		userList.add(user);
		return user;
	}

	
	@GetMapping(value="/user", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		return userList;
	}
	
	@GetMapping(value="/user/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getOrderByUsername(@PathVariable(name="username") String userName) {
		List<User> matchingUsers = userList.stream().filter((User user)->user.getUsername().equalsIgnoreCase(userName)).collect(Collectors.toList());
		return matchingUsers.get(0);
	}
	
	
	@DeleteMapping(value="/user/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User deleteUserByUsername(@PathVariable(name="username") String delUser) {
		User u=getOrderByUsername(delUser);
		userList.remove(u);
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static List<User> userList=new ArrayList<User>();
	static {
		userList.add(new User("Surendra","Singh","Surendra25","surenbabu2514","suruhoja5@gmail.com",8847));
		userList.add(new User("Ruhika","Pattnaik","Chocolush","ruhika@14","riapattnaik5@gmail.com",9337));
		userList.add(new User("Duryodhan","Singh","Duryo1970","9439650025","singh.rkl1970@gmail.com",9861));
	}

}
