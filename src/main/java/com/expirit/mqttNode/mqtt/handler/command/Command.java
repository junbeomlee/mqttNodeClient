package com.expirit.mqttNode.mqtt.handler.command;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface Command {

	int execute(MqttMessage message);

}
