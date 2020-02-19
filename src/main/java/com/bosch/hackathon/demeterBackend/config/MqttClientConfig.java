package com.bosch.hackathon.demeterBackend.config;

import javax.inject.Inject;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.bosch.hackathon.demeterBackend.restControllers.DemeterRestController;


@Configuration
public class MqttClientConfig implements EnvironmentAware {

    private final Logger log = LoggerFactory.getLogger(MqttClientConfig.class);

    private RelaxedPropertyResolver propertyResolver;

	@Inject
    private DemeterRestController eventListener;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "mqtt.");
    }

    @Bean(destroyMethod = "disconnect")
    MqttClient mqttClient() {
        log.debug("MqttClient client is connecting");
        String serverURI = propertyResolver.getProperty("serverURI");
        log.info("MQTT URI " + serverURI);

        if (serverURI == null) {
            log.error("Your mqtt.serverURI is not configured properly");
            throw new ApplicationContextException("Database connection pool is not configured correctly");
        }

        try {

            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            MqttClient mqttClient = new MqttClient(serverURI, "You");
            mqttClient.connect(connOpts);
            mqttClient.setCallback(eventListener);
            mqttClient.subscribe("fek/#", 2);

//            mqttClient.subscribe("fek/102", 2);
//            mqttClient.subscribe("fek/87", 2);
//            mqttClient.subscribe("fek/305", 2);
//            mqttClient.subscribe("fek/438", 2);
//            mqttClient.subscribe("fek/437", 2);
//            mqttClient.subscribe("fek/436", 2);
//            mqttClient.subscribe("fek/306", 2);
//            mqttClient.subscribe("fek/307", 2);
//            mqttClient.subscribe("fek/308", 2);

            log.info("Connected to Mqtt server, {}", serverURI);
            return mqttClient;
        } catch (MqttException me) {
            log.error("Mqtt Client creation failed: \n code: {} \n msg: {} ", me.getReasonCode(), me.getMessage());
            log.info("MQTT URI " + serverURI);
            throw new BeanCreationException("mqttClient", "Failed to create a MqttClient", me);
        }

    }
}
