package com.expirit.mqttNode.status;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status implements Serializable{
	/**
	 * 
	 */
	private String clientId;
	private String nodeNumber;
	private String timeStamp;
}
