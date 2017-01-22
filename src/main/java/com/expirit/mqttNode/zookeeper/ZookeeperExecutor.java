package com.expirit.mqttNode.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.ZooDefs.Ids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expirit.mqttNode.utill.NodeConfig;

@Component
public class ZookeeperExecutor implements StatCallback{

	private ZooKeeper zk;
	private String znode = "/mqtt/"+NodeConfig.nodeNum;
	
	@Autowired
	public ZookeeperExecutor(ZookeeperConnector zc){
		
		try {
			zk=zc.connect("localhost");
			createNode(znode, NodeConfig.nodeNum.getBytes(),CreateMode.EPHEMERAL);
			//zk.exists(znode, true, this, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createNode(String path, byte[] data,CreateMode createMode) throws KeeperException, InterruptedException{
		zk.create(path, data, Ids.OPEN_ACL_UNSAFE, createMode);
	}

	@Override
	public void processResult(int arg0, String arg1, Object arg2, Stat arg3) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		System.out.println(arg1);
		System.out.println(arg3.toString());
		//zk.exists(znode, true, this, null);
	}
}
