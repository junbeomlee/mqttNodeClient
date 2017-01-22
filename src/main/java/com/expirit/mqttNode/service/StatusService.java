package com.expirit.mqttNode.service;

import java.util.List;

import com.expirit.mqttNode.status.Status;

public interface StatusService{
	public void save(String clientId);

	public List<Status> getAll();

	public void delete(String clientId);
	
	public Status get(String clientId);
}
