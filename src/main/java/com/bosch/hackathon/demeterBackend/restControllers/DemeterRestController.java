/**
 * 
 */
package com.bosch.hackathon.demeterBackend.restControllers;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.hackathon.demeterBackend.model.SensorValue;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author David Sharma (david.sharma@gmx.de)
 * 
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "demeter", description = "DemeterRestController")
@RequestMapping(value = "/backend")
@Component
public class DemeterRestController implements MqttCallback {

	private SensorValue fuel;
	private SensorValue position;
	private SensorValue tireP;

	private SensorValue humidity;
	private SensorValue temperature;
	private SensorValue pressure;

	private SensorValue wind;
	private SensorValue area;
	private SensorValue lifetime;

	@ApiOperation(value = "/getFuel", notes = "returns the fuel consumption")
	@RequestMapping(value = "/getFuel", method = RequestMethod.GET)
	public SensorValue getFuel() {
		return fuel;

	}

	@ApiOperation(value = "/getPosition", notes = "returns the actual position")
	@RequestMapping(value = "/getPosition", method = RequestMethod.GET)
	public SensorValue getPosition() {
		return position;

	}

	@ApiOperation(value = "/getTireP", notes = "return the tire pressure")
	@RequestMapping(value = "/getTireP", method = RequestMethod.GET)
	public SensorValue getTireP() {
		return tireP;

	}
	@CrossOrigin(origins = "http://localhost:3000")
	@ApiOperation(value = "/getHumidity", notes = "returns the huidity")
	@RequestMapping(value = "/getHumidity", method = RequestMethod.GET)
	public SensorValue getHumidity() {
		return humidity;

	}

	@ApiOperation(value = "/getTemperature", notes = "return the temp")
	@RequestMapping(value = "/getTemperature", method = RequestMethod.GET)
	public SensorValue getTemperature() {
		return temperature;

	}

	@ApiOperation(value = "/getPressure", notes = "returns the pressure")
	@RequestMapping(value = "/getPressure", method = RequestMethod.GET)
	public SensorValue getPressure() {
		return pressure;

	}

	@ApiOperation(value = "/getWind", notes = "returns the wind")
	@RequestMapping(value = "/getWind", method = RequestMethod.GET)
	public SensorValue getWind() {
		return wind;

	}

	@ApiOperation(value = "/getArea", notes = "returns the area")
	@RequestMapping(value = "/getArea", method = RequestMethod.GET)
	public SensorValue getArea() {
		return area;

	}

	@ApiOperation(value = "/getLifetime", notes = "returns the lifetime")
	@RequestMapping(value = "/getLifetime", method = RequestMethod.GET)
	public SensorValue getLifetime() {
		return lifetime;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.paho.client.mqttv3.MqttCallback#connectionLost(java.lang.
	 * Throwable)
	 */
	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#deliveryComplete(org.eclipse.paho
	 * .client.mqttv3.IMqttDeliveryToken)
	 */
	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.String,
	 * org.eclipse.paho.client.mqttv3.MqttMessage)
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String body = new String(message.getPayload());
		System.out.println(body + "  " + topic);

		if (topic.equals("fek/102")) {

			ObjectMapper mapper = new ObjectMapper();

			fuel = mapper.readValue(body, SensorValue.class);

		}
		else if (topic.equals("fek/87")) {

			ObjectMapper mapper = new ObjectMapper();

			position = mapper.readValue(body, SensorValue.class);

		}
		else if (topic.equals("fek/305")) {

			ObjectMapper mapper = new ObjectMapper();

			tireP = mapper.readValue(body, SensorValue.class);

		}

		else if (topic.equals("fek/436")) {

			ObjectMapper mapper = new ObjectMapper();

			humidity = mapper.readValue(body, SensorValue.class);

		}

		else if (topic.equals("fek/438")) {

			ObjectMapper mapper = new ObjectMapper();

			temperature = mapper.readValue(body, SensorValue.class);

		}

		else if (topic.equals("fek/437")) {

			ObjectMapper mapper = new ObjectMapper();

			pressure = mapper.readValue(body, SensorValue.class);

		}

		else if (topic.equals("fek/306")) {

			ObjectMapper mapper = new ObjectMapper();

			wind = mapper.readValue(body, SensorValue.class);

		}
		else if (topic.equals("fek/307")) {

			ObjectMapper mapper = new ObjectMapper();

			area = mapper.readValue(body, SensorValue.class);

		}

		else if (topic.equals("fek/308")) {

			ObjectMapper mapper = new ObjectMapper();

			lifetime = mapper.readValue(body, SensorValue.class);

		}

		try {

		} catch (Exception e) {
			System.out.println("Can not resolve Mqtt message" + e);
		}

	}
}
