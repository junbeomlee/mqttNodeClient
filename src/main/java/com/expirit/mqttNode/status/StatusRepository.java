package com.expirit.mqttNode.status;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class StatusRepository {
	private static final String KEY = "status";
	
	@Autowired
	private RedisTemplate<String, Status> statusTemplate;
	
	private HashOperations<String, String, Status> hashOps;
	
	@Autowired
    public StatusRepository(RedisTemplate<String, Status> statusTemplate) {
        this.statusTemplate = statusTemplate;
    }
	
    @PostConstruct
    private void init() {
        hashOps = statusTemplate.opsForHash();
    }
    
    public void save(Status status){
		hashOps.put(KEY, status.getClientId(), status);
	}
    
	public Status get(String key){
		return (Status) hashOps.get(KEY, key);
	}
	
	public List<Status> getList(){
		Set<String> keyList=hashOps.keys(KEY);
		return hashOps.multiGet(KEY, keyList);
	}

	public void delete(String clientId) {
		// TODO Auto-generated method stub
		hashOps.delete(KEY, clientId);
	}
	
	public void deleteAll(){
		Set<String> keyList=hashOps.keys(KEY);
		keyList.forEach(key->{
			hashOps.delete(KEY, key);
		});
	}
}
