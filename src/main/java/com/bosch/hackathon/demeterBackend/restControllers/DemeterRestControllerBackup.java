///**
// * 
// */
//package com.bosch.hackathon.demeterBackend.restControllers;
//
//import java.util.concurrent.ThreadLocalRandom;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bosch.hackathon.demeterBackend.model.SensorValue;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
///**
// * @author David Sharma (david.sharma@gmx.de)
// *	
// */
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@Api(value = "demeter", description = "DemeterRestController")
//@RequestMapping(value = "/backend")
//@Component
//public class DemeterRestControllerBackup {
//
//
//	private SensorValue fuel = new SensorValue();;
//	private SensorValue position= new SensorValue();;;
//	private SensorValue tireP= new SensorValue();;;
//
//	private SensorValue humidity= new SensorValue();;;
//	private SensorValue temperature= new SensorValue();;;
//	private SensorValue pressure= new SensorValue();;;
//
//	private SensorValue wind= new SensorValue();;;
//	private SensorValue area;
//	private SensorValue lifetime;
//
//	@ApiOperation(value = "/getFuel", notes = "returns the fuel consumption")
//	@RequestMapping(value = "/getFuel", method = RequestMethod.GET)
//	public SensorValue getFuel() throws InterruptedException {
//		Thread.sleep(2000);
//		fuel.setPL(ThreadLocalRandom.current().nextDouble(4, 9));
//		return fuel;
//	}
//
//	@ApiOperation(value = "/getPosition", notes = "returns the actual position")
//	@RequestMapping(value = "/getPosition", method = RequestMethod.GET)
//	public SensorValue getPosition() throws InterruptedException {
//		Thread.sleep(2000);
//
//		return position;
//
//	}
//
//	@ApiOperation(value = "/getTireP", notes = "return the tire pressure")
//	@RequestMapping(value = "/getTireP", method = RequestMethod.GET)
//	public SensorValue getTireP() throws InterruptedException {
//		Thread.sleep(2000);
//
//		tireP.setPL(ThreadLocalRandom.current().nextDouble(0.5, 1.4));
//
//		return tireP;
//
//	}
//	@CrossOrigin(origins = "http://localhost:3000")
//	@ApiOperation(value = "/getHumidity", notes = "returns the huidity")
//	@RequestMapping(value = "/getHumidity", method = RequestMethod.GET)
//	public SensorValue getHumidity() throws InterruptedException {
//		Thread.sleep(2000);
//
//		humidity.setPL(ThreadLocalRandom.current().nextDouble(0.5, 1.4));
//
//		return humidity;
//
//	}
//
//	@ApiOperation(value = "/getTemperature", notes = "return the temp")
//	@RequestMapping(value = "/getTemperature", method = RequestMethod.GET)
//	public SensorValue getTemperature() throws InterruptedException {
//		Thread.sleep(2000);
//
//		temperature.setPL(ThreadLocalRandom.current().nextDouble(25, 30));
//
//		return temperature;
//
//	}
//
//	@ApiOperation(value = "/getPressure", notes = "returns the pressure")
//	@RequestMapping(value = "/getPressure", method = RequestMethod.GET)
//	public SensorValue getPressure() throws InterruptedException {
//		Thread.sleep(2000);
//
//		pressure.setPL(ThreadLocalRandom.current().nextDouble(1000, 1301));
//
//		return pressure;
//
//	}
//
//	@ApiOperation(value = "/getWind", notes = "returns the wind")
//	@RequestMapping(value = "/getWind", method = RequestMethod.GET)
//	public SensorValue getWind() throws InterruptedException {
//		Thread.sleep(2000);
//
//		wind.setPL(ThreadLocalRandom.current().nextDouble(20, 40));
//
//		return wind;
//		
//
//	}
//
////	@ApiOperation(value = "/getArea", notes = "returns the area")
////	@RequestMapping(value = "/getArea", method = RequestMethod.GET)
////	public SensorValue getArea() {
////		return area;
////
////	}
////
////	@ApiOperation(value = "/getLifetime", notes = "returns the lifetime")
////	@RequestMapping(value = "/getLifetime", method = RequestMethod.GET)
////	public SensorValue getLifetime() {
////		return lifetime;
////
////	}
//}
