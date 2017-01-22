package com.expirit.mqttNode.utill;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {

	private final Log log = LogFactory.getLog(getClass());

//    @AfterReturning("execution(* com.expirit.mqttNode.mqtt.SimpleMqttClient.messageArrived(..))")
//    public void logMethodAccessAfter(JoinPoint joinPoint) {
//    	System.out.println("qweqwe");
//        log.info("***** Completed: " + joinPoint.getSignature().getName() + " *****");
//        System.out.println("***** Completed: " + joinPoint.getSignature().getName() + " *****");
//    }

    @Before("execution(* com.expirit.mqttNode.mqtt.RequestHandler.*.*(..))")
    public void logMethodAccessBefore(JoinPoint joinPoint) {
        log.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
        System.out.println("***** Starting: " + joinPoint.getSignature().getName() + " *****");
    }
}
