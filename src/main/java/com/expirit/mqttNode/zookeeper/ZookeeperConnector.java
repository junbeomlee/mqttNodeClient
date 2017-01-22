package com.expirit.mqttNode.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Component;

@Component
public class ZookeeperConnector {

	private ZooKeeper zooKeeper;
	private CountDownLatch connSignal = new CountDownLatch(1);
	
	public ZooKeeper connect(String host) throws IOException, InterruptedException{
		zooKeeper = new ZooKeeper(host,5000,new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				//System.out.println(event.toString());
				// TODO Auto-generated method stub
				if (event.getType() == Event.EventType.None){
					if(event.getState()==KeeperState.SyncConnected){
						connSignal.countDown();
					}
					if(event.getState()==KeeperState.Expired){
						System.out.println("expired");
					}
				}
			}
		});
		connSignal.await();
		return zooKeeper;
	}
	
	public void close() throws InterruptedException{
		zooKeeper.close();
	}
}
