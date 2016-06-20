package com.planning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="trip_id")
	private Integer id;
	String placeOfDeparture;
	String arrivalEmplacement;
	String transportCompany;
	int transportPrice;
	String accommodationName;
	int accommodationPrice;
	
	public Trip(){}
	
	public Integer getId() {
		return id;
	}
	
	public String getPlaceOfDeparture() {
		return placeOfDeparture;
	}

	public void setPlaceOfDeparture(String placeOfDeparture) {
		this.placeOfDeparture = placeOfDeparture;
	}

	public String getArrivalEmplacement() {
		return arrivalEmplacement;
	}

	public void setArrivalEmplacement(String arrivalEmplacement) {
		this.arrivalEmplacement = arrivalEmplacement;
	}

	public String getTransportCompany() {
		return transportCompany;
	}

	public void setTransportCompany(String transportCompany) {
		this.transportCompany = transportCompany;
	}

	public int getTransportPrice() {
		return transportPrice;
	}

	public void setTransportPrice(int transportPrice) {
		this.transportPrice = transportPrice;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public int getAccommodationPrice() {
		return accommodationPrice;
	}

	public void setAccommodationPrice(int accommodationPrice) {
		this.accommodationPrice = accommodationPrice;
	}
}
