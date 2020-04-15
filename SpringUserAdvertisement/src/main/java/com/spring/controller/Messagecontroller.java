package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.Message;
import com.spring.service.MessageService;

@RestController
@RequestMapping("/myapp")
public class Messagecontroller {
	
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping(value="/user/advertise/{postid}/message", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object sendMessage(@PathVariable(value="postid") String postid,@RequestBody Message message,@RequestHeader(name="auth-token") String authToken) {
		return messageService.sendAMessage(message,postid,authToken);
	}
	

}
