package com.spring.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.spring.entity.AdvertiseEntity;

@Component
public interface AdvertiseRepository extends JpaRepository<AdvertiseEntity, Long>{
	List<AdvertiseEntity> findByOrderByIdAsc();
	List<AdvertiseEntity> findByPostid(String postid);
	List<AdvertiseEntity> findByName(String name);
	Boolean existsByPostid(String postid);
	List<AdvertiseEntity> findByCategory(String category);
	
	
	
	
}
