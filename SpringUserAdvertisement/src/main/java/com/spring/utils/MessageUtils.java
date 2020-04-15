package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.MessageEntity;
import com.spring.json.Message;

public class MessageUtils {
	
	public static List<Message> convertMessageEntityListToMessageList(List<MessageEntity> messageEntityList) {
		List<Message> messageList = new ArrayList<Message>();
		Consumer<MessageEntity> consumer = (MessageEntity messageEntity)->messageList.add(convertMessageEntityToMessage(messageEntity));
		messageEntityList.stream().forEach(consumer);
		return messageList;
	}
	
	public static Message convertMessageEntityToMessage(MessageEntity messageEntity) {
		return new Message(messageEntity.getId(),messageEntity.getCustomerName(),messageEntity.getOwnerName(),
				messageEntity.getMessage(),messageEntity.getPostid());
	}

	public static MessageEntity convertMessageToMessageEntity(Message message) {
		return new MessageEntity(message.getCustomerName(),message.getOwnerName(),message.getMessage(),message.getPostid());
	}

}
