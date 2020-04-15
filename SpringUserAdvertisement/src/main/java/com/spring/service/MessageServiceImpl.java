package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.AdvertiseEntity;
import com.spring.entity.MessageEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Message;
import com.spring.rest.repository.AdvertiseRepository;
import com.spring.rest.repository.MessageRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.MessageUtils;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private UserRepository userRepository;

	
	public Object sendAMessage(Message message, String postid, String authToken) {
		List<AdvertiseEntity> advertiseEntity=advertiseRepository.findByPostid(postid);
		AdvertiseEntity advertiseEntity1=advertiseEntity.get(0);
		String advOwner=advertiseEntity1.getName();
		
		List<UserEntity> userEntity=userRepository.findByFirstName(advOwner);
		UserEntity userEntity1=userEntity.get(0);
		String sessionid=userEntity1.getSessionID();
		
		if(sessionid.equals(authToken)) {
			message.setOwnerName(advOwner);
			message.setPostid(postid);
			MessageEntity messageEntity=messageRepository.save(MessageUtils.convertMessageToMessageEntity(message));
			return MessageUtils.convertMessageEntityToMessage(messageEntity);
			}
		return null;
	}
	
	
	
	
	

}
