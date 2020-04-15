package com.spring.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.AdvertiseEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Advertise;
import com.spring.rest.repository.AdvertiseRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.AdvertiseUtils;


@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public List<String> getCategories() {
		List<AdvertiseEntity> advertiseEntList=advertiseRepository.findByOrderByIdAsc();
		List<Advertise> advertiseJson=AdvertiseUtils.convertAdvertiseEntityListToAdvertiseList(advertiseEntList);
		List<String> categories=advertiseJson.stream().map(Advertise::getCategory).collect(Collectors.toList());		
		return categories;
	}
	
	

	public Object save(Advertise advertise,String authToken) {
		List<UserEntity> userEntity=userRepository.findBySessionID(authToken);
		UserEntity userEn=userEntity.get(0);
		if(userEntity.isEmpty()) {
			return "No such token available";
		}
		else {
			if((advertise.getName()).equals((userEn.getFirstName()))){
				UUID uidd=UUID.randomUUID();
				String postId=uidd.toString().substring(0,3);
				advertise.setPostid(postId);
				advertise.setDate(Date.valueOf(LocalDate.now()));
				AdvertiseEntity advertiseEntity= advertiseRepository.save(AdvertiseUtils.convertAdvertiseToAdvertiseEntity(advertise));
				return AdvertiseUtils.convertAdvertiseEntityToAdvertise(advertiseEntity);
			}
			else {
				return "Name and auth token doesnot match";
			}
			
		}
	}

	
	public Object update(String postid, Advertise advertise, String authToken) {
		List<AdvertiseEntity> advertiseEntity=advertiseRepository.findByPostid(postid);
		AdvertiseEntity advertiseEnt=advertiseEntity.get(0);
		String advName=advertiseEnt.getName();
		
		List<UserEntity> userEntity=userRepository.findByFirstName(advName);
		UserEntity userEnt=userEntity.get(0);
		String sessionid=userEnt.getSessionID();
		if(sessionid.equals(authToken)) {
			//title,name,category,description,status
			advertiseEnt.setTitle(advertise.getTitle());
			advertiseEnt.setName(advertise.getName());
			advertiseEnt.setCategory(advertise.getCategory());
			advertiseEnt.setDescription(advertise.getDescription());
			advertiseEnt.setStatus(advertise.getStatus());
			advertiseEnt=advertiseRepository.save(advertiseEnt);
			return AdvertiseUtils.convertAdvertiseEntityToAdvertise(advertiseEnt);
		}
		return null;
	}
	

	public List<Advertise> advByUser(String byName,String authToken) {
		List<UserEntity> user=userRepository.findByFirstName(byName);
		UserEntity user1=user.get(0);
		String sessionid=user1.getSessionID();
		if(sessionid.equals(authToken)) {
			List<AdvertiseEntity> advEntity=advertiseRepository.findByName(byName);
			return AdvertiseUtils.convertAdvertiseEntityListToAdvertiseList(advEntity);
		}
		
		return null;
	}
	

	public List<Advertise> advByUserPostId(String byName, String byPostId, String authToken) {
		List<UserEntity> user=userRepository.findByFirstName(byName);
		UserEntity user1=user.get(0);
		String sessionid=user1.getSessionID();
		if(sessionid.equals(authToken)) {
			List<AdvertiseEntity> advEntity=advertiseRepository.findByPostid(byPostId);
			return AdvertiseUtils.convertAdvertiseEntityListToAdvertiseList(advEntity);
		}
		return null;
	}
	

	public Boolean deletebyPostid(String postId, String authToken) {
		if(advertiseRepository.existsByPostid(postId)) {
			List<AdvertiseEntity> advEntity=advertiseRepository.findByPostid(postId);
			AdvertiseEntity advertiseEntity=advEntity.get(0);
			String name=advertiseEntity.getName();
			
			List<UserEntity> usEntity=userRepository.findByFirstName(name);
			UserEntity userEntity=usEntity.get(0);
			String sessionid=userEntity.getSessionID();
			
			if(sessionid.equals(authToken)) {
				Long id=advertiseEntity.getId();
				advertiseRepository.deleteById(id);
				return true;
			}else {	return false;}
		}
		return null;
	}
	

	public List<Advertise> advFiltered(String filter) {
		List<AdvertiseEntity> advEntity =advertiseRepository.findByOrderByIdAsc();
		List<AdvertiseEntity> advEntity1=advEntity.stream().filter(t->(filter.equals(t.getCategory()))||
				(filter.equals(t.getDescription()))||
						(filter.equals(t.getName()))||
								(filter.equals(t.getStatus()))
				).collect(Collectors.toList());
		
		return AdvertiseUtils.convertAdvertiseEntityListToAdvertiseList(advEntity1);
	}
}
