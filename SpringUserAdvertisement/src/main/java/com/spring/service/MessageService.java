package com.spring.service;

import com.spring.json.Message;

public interface MessageService {

	Object sendAMessage(Message message, String postid, String authToken);
}
