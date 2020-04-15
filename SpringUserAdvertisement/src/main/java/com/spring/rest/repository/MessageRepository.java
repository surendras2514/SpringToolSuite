package com.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}
