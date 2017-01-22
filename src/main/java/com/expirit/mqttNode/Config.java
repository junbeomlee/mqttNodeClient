package com.expirit.mqttNode;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.expirit.mqttNode.status.Status;

@Configuration
public class Config {

//	@Bean
//	public OkHttpClient okHttpClient() {
//		return new OkHttpClient().newBuilder().build();
//	}
//
//	@Bean
//	public Retrofit retrofit(OkHttpClient client) {
//		return new Retrofit.Builder().baseUrl("http://143.248.136.53:8080/").client(client)
//				.addConverterFactory(GsonConverterFactory.create())
//				.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
//	}

	@Bean
	public RedisTemplate<String, Status> redisTemplate() {
		RedisTemplate<String, Status> template = new RedisTemplate<String, Status>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		jedisConFactory.setHostName("localhost");
		jedisConFactory.setPort(6379);
		return jedisConFactory;
	}
	
	@Bean
	MqttConnectOptions mqttConnectionOptionFactory(){
		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
        connOpts.setKeepAliveInterval(30);
        connOpts.setConnectionTimeout(0);
		return connOpts;
	}

}
