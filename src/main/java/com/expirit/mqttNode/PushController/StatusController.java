package com.expirit.mqttNode.PushController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expirit.mqttNode.message.Message;
import com.expirit.mqttNode.service.StatusService;
import com.expirit.mqttNode.status.Status;
import com.expirit.mqttNode.status.StatusRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StatusController {

	@Autowired
	StatusService statusService;
	
	@Autowired
	StatusRepository statusRepository;
	
	@RequestMapping(value="/statuses", method=RequestMethod.GET)
	public List<Status> getStatussList(){
		
		return statusService.getAll();
	}
	
	@RequestMapping(value="/status", method=RequestMethod.GET)
	public void statsList(){
		
		statusService.save("asd");
	}
	
	@RequestMapping(value="/statusd", method=RequestMethod.GET)
	public void deleteAll(){
		
		statusRepository.deleteAll();
	}
}
