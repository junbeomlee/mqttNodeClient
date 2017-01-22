package com.expirit.mqttNode.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expirit.mqttNode.utill.NodeConfig;

public class MqttConnector {

//	private final String MQTT_BROKER_HOST ="tcp://localhost:3333";
//	private MqttClient mqttClient;
//	private MqttConnectOptions connOpt;
//	private MqttListener mqttListener;
//	
//	@Autowired
//	public MqttConnector(MqttConnectOptions connOpt,MqttListener mqttlistener){
//		this.connOpt=connOpt;
//		this.mqttListener=mqttlistener;
//	}
//	
//	public MqttClient connect() throws MqttException{
//		mqttClient = new MqttClient(MQTT_BROKER_HOST, NodeConfig.nodeNum);
//		mqttClient.setCallback(mqttListener);
//		mqttClient.connect(connOpt);
//		return mqttClient;
//	}
//	
//	public void close() throws MqttException{
//		mqttClient.close();
//	}
}
