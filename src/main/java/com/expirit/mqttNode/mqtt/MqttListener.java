package com.expirit.mqttNode.mqtt;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expirit.mqttNode.mqtt.handler.command.Command;

@Component
public class MqttListener implements MqttCallback{

	private final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	RequestHandler requestHandler;

	@Override
	public void connectionLost(Throwable cause) {
//		try{
//			simpleMqttClient.connect();
//		}catch(Exception e){
//			
//		}
	}
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.String, org.eclipse.paho.client.mqttv3.MqttMessage)
	 * 
	 * 처리해야될 요청이 오면 처리 나머지는무시 요청은 requestHandler로 보낸다
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		log.info("Request topic: "+topic);
		log.info("Request MqttMessage: "+message);

		try{
			List<String> topics = Arrays.asList(topic.split("/"));
			if(requestCheck(topics)){
				Command command=requestHandler.handleRequest(topics.get(3));
				if(command!=null)
					command.execute(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * clients/{clientId}/{messageType}/{message}
	 */
	public Boolean requestCheck(List<String> topics){
		
		if(topics.isEmpty())
			return false;
		
		if(!topics.get(0).equals("clients")&&topics.get(1)!=null&&topics.get(2)!=null)
			return false;
		
		if(topics.size()!=4)
			return false;
		
		return true;
	}
}
