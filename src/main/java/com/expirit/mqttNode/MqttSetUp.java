package com.expirit.mqttNode;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.expirit.mqttNode.mqtt.SimpleMqttClient;
import com.expirit.mqttNode.service.StatusServiceImpl;

//@Component
//public class MqttSetUp implements CommandLineRunner{
//
//	
//	@Override
//	public void run(String... arg0) throws Exception {
//		// TODO Auto-generated method stub
//		simpleMqttClient.setCallback(new MqttCallback() {
//			
//			@Override
//			public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void deliveryComplete(IMqttDeliveryToken arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void connectionLost(Throwable arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		simpleMqttClient.subscribe(statusTopic);
//	}
//}
