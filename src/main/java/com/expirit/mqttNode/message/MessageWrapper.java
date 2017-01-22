package com.expirit.mqttNode.message;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageWrapper implements Serializable{
	private List<Message> messages;
	private String clientId;
	private String topic;
	private String nodeNum;
}
