package com.expirit.mqttNode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("mqttConfig.properties")
public class MqttNodeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqttNodeClientApplication.class, args);
	}
}
