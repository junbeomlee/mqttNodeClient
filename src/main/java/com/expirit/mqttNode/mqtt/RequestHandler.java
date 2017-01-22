package com.expirit.mqttNode.mqtt;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expirit.mqttNode.mqtt.handler.command.Command;
import com.expirit.mqttNode.service.StatusService;

@Service
public class RequestHandler {
	
	private static final String CONNECT="connect";
	private static final String DISCONNET="disconnect";
	
	private final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	StatusService statusService;
	
	private Map<String, Command> commandMap;
	
	public RequestHandler(){
		commandMap= new HashMap<String,Command>();
		commandMap.put(CONNECT, new ConnectCommand());
		commandMap.put(DISCONNET, new DisconnectCommand());
	}
	
    public Command handleRequest(String action) {
        Command command = commandMap.get(action);
        return command;
    }
    
    public class ConnectCommand implements Command{

    	private final Log log = LogFactory.getLog(getClass());
    	
		@Override
		public int execute(MqttMessage message) {
			// TODO Auto-generated method stub
			log.info("Message: "+ message);
			String clientId=new String(message.getPayload());
			
			try{
				statusService.save(clientId);
			}catch(Exception e){
				e.printStackTrace();
			}
			return 1;
		}
    }
    
    public class DisconnectCommand implements Command{

		@Override
		public int execute(MqttMessage message) {
			// TODO Auto-generated method stub
			log.info("Message: "+ message);
			String clientId=new String(message.getPayload());
			
			try{
				statusService.delete(clientId);
			}catch(Exception e){
				e.printStackTrace();
			}
			return 1;
		}
    	
    }
}
