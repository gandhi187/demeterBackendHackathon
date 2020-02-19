//package com.bosch.hackathon.demeterBackend.eventListener;
//
//import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
//import org.eclipse.paho.client.mqttv3.MqttCallback;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EventListener implements MqttCallback {
//
//    private final Logger log = LoggerFactory.getLogger(EventListener.class);
//
//
//
//    @Override
//    public void connectionLost(Throwable cause) {
//        log.error("Connection to Mqtt Broker lost! Cause: {}", cause.getCause());
//    }
//
//    @Override
//    public void messageArrived(String topic, MqttMessage message) throws Exception {
//        String body = new String(message.getPayload());
//        
//  
//        log.info("Topic: {}, Message: {}", topic, body);
//        System.out.println("test");
//        System.out.println("Topic: {}, Message: {}" + topic + body);
//
//        try {
//        
//
//        } catch (Exception e) {
//            log.error("Can not resolve Mqtt message", e);
//        }
//
//    }
//
//    @Override
//    public void deliveryComplete(IMqttDeliveryToken token) {
//
//    }
//}
