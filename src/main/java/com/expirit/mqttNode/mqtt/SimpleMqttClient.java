package com.expirit.mqttNode.mqtt;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expirit.mqttNode.message.Message;
import com.expirit.mqttNode.utill.NodeConfig;

@Service
public class SimpleMqttClient{

	private final Log log = LogFactory.getLog(getClass());
	private final String MQTT_BROKER_HOST ="tcp://localhost:3333";
	private MqttClient mqttClient;
	private MqttConnectOptions connOpt;
	private MqttListener mqttListener;
	private MemoryPersistence persistence = new MemoryPersistence();
	
	@Autowired
	public SimpleMqttClient(MqttConnectOptions connOpt,MqttListener mqttlistener){
		this.connOpt=connOpt;
		this.mqttListener=mqttlistener;
		try {
			connect();
			mqttClient.subscribe(NodeConfig.STATUS_TOPIC);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MqttClient connect() throws MqttException{
		mqttClient = new MqttClient(MQTT_BROKER_HOST, NodeConfig.nodeNum,persistence);
		mqttClient.setCallback(mqttListener);
		mqttClient.connect(connOpt);
		return mqttClient;
	}
	
	public void publish(String messageBody,String topic) throws MqttPersistenceException, MqttException{
		 MqttMessage message = new MqttMessage(messageBody.getBytes());
         message.setQos(2);
         System.out.println(message.getPayload().toString());
         mqttClient.publish(topic, message);
	}
	
	public void subscribe(String topic) {
		// TODO Auto-generated method stub
		try {
			mqttClient.subscribe(topic, 2);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
