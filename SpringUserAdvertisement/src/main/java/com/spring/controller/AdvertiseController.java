package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.Advertise;
import com.spring.service.AdvertiseService;

@RestController
@RequestMapping("/myapp")
public class AdvertiseController {
	
	@Autowired
	private AdvertiseService advertiseService;
	

	@GetMapping(value="user/advertise/category")
	public List<String> getCategories(){
		return advertiseService.getCategories();		
	}
	
	@PostMapping(value="/user/advertise", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object registerAdvertise(@RequestBody Advertise advertise,@RequestHeader(name="auth-token") String authToken) {
		return advertiseService.save(advertise,authToken);
	}
	
	@PutMapping(value="/user/advertise/{postid}",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object updateAdvertise(@PathVariable(value="postid") String postid,@RequestBody Advertise advertise,@RequestHeader(name="auth-token") String authToken) {
		return advertiseService.update(postid,advertise,authToken);
		
	}
	
	@GetMapping(value="user/advertise/{name}")
	public List<Advertise> getAdvertiseByUser(@PathVariable(value="name") String byName,@RequestHeader(name="auth-token") String authToken){
		return advertiseService.advByUser(byName,authToken);	
	}
	
	@GetMapping(value="user/advertise/{name}/{postid}")
	public List<Advertise> getAdvertiseByUserPostID(@PathVariable(value="name") String byName,@PathVariable(value="postid") String byPostId,@RequestHeader(name="auth-token") String authToken){
		return advertiseService.advByUserPostId(byName,byPostId,authToken);	
	}
	
	@DeleteMapping(value="user/advertise/{postid}")
	public Boolean deleteAdvPostid(@PathVariable(value="postid") String postId,@RequestHeader(name="auth-token") String authToken) {
		return advertiseService.deletebyPostid(postId,authToken);
		
	}
	@GetMapping(value="user/advertise/filter")
	public List<Advertise> filteredAdertise(@RequestParam(name="filter") String filt){
		return advertiseService.advFiltered(filt);	
	}
}
