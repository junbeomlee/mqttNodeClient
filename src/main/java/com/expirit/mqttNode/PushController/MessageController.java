package com.expirit.mqttNode.PushController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expirit.mqttNode.message.Message;
import com.expirit.mqttNode.message.MessageWrapper;
import com.expirit.mqttNode.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MessageController {

	@Autowired
	MessageService messageService;
	
//	@RequestMapping(value="/messages", method=RequestMethod.POST)
//	public Message pushMessage(@RequestBody Message message){
//		messageService.publish(message.getTopic(),message.getMessage(),message.getClientId());
//		return message;
//	}
	
	@RequestMapping(value="/messages", method=RequestMethod.POST)
	public MessageWrapper pushMessages(@RequestBody MessageWrapper messageWrapper){
		messageService.publish(messageWrapper.getTopic(),messageWrapper.getMessages());
		return messageWrapper;
	}
}
