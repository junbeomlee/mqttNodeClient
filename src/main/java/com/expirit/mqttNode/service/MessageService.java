package com.expirit.mqttNode.service;

import java.util.List;

import org.json.simple.*;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expirit.mqttNode.message.Message;
import com.expirit.mqttNode.message.MessageWrapper;
import com.expirit.mqttNode.mqtt.SimpleMqttClient;

@Service
public class MessageService {

	@Autowired 
	SimpleMqttClient mqttClient;
	
	@Autowired
	StatusService statusServiceImpl;
	
	public void publish(String topic, String messageBody,String clientId) {
		// TODO Auto-generated method stub
		try {
		
			mqttClient.publish(messageBody, topic);
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void publish(MessageWrapper messageWrapper) {
		// TODO Auto-generated method stub

	}

	public void publish(String topic, List<Message> messages) {
		// TODO Auto-generated method stub
		try {
			String listMessageJsonString=JSONArray.toJSONString(messages);
			mqttClient.publish(listMessageJsonString,topic);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
