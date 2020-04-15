package com.spring.service;

import java.util.List;

import com.spring.json.Advertise;

public interface AdvertiseService {

	List<String> getCategories();
	
	Object save(Advertise advertise,String token);	
	
	Object update(String postid, Advertise advertise, String authToken);
	
	List<Advertise> advByUser(String byName,String token);
	
	List<Advertise> advByUserPostId(String byName, String byPostId, String authToken);
	
	Boolean deletebyPostid(String postId, String authToken);
	
	List<Advertise> advFiltered(String filter);

}