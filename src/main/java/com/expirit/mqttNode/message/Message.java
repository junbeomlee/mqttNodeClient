package com.expirit.mqttNode.message;

import java.io.Serializable;

import com.expirit.mqttNode.status.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 62169119587150667L;
	private String timeStamp;
	private String message;

}
