package com.expirit.mqttNode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expirit.mqttNode.status.Status;
import com.expirit.mqttNode.status.StatusRepository;
import com.expirit.mqttNode.utill.DateUtil;
import com.expirit.mqttNode.utill.NodeConfig;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	StatusRepository statusRepository;
	
	public void save(String clientId) {
		// TODO Auto-generated method stub
		Status status = new Status(clientId,NodeConfig.nodeNum,DateUtil.getNowDateStringFormat());
		statusRepository.save(status);
	}

	@Override
	public List<Status> getAll() {
		// TODO Auto-generated method stub
		return statusRepository.getList();
	}
	
	@Override
	public Status get(String clientId){
		return statusRepository.get(clientId);
	}

	@Override
	public void delete(String clientId) {
		// TODO Auto-generated method stub
		statusRepository.delete(clientId);
	}

}
