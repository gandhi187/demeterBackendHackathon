/**
 * 
 */
package com.bosch.hackathon.demeterBackend.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author David Sharma (david.sharma@gmx.de)
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "PL", "TS" })
public class SensorValue {

	
	@JsonProperty("PL")
	private Double pL;
	@JsonProperty("TS")
	private Integer tS;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("PL")
	public Double getPL() {
	return pL;
	}

	@JsonProperty("PL")
	public void setPL(Double pL) {
	this.pL = pL;
	}

	@JsonProperty("TS")
	public Integer getTS() {
	return tS;
	}

	@JsonProperty("TS")
	public void setTS(Integer tS) {
	this.tS = tS;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	
	}

