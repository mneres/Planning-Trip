package com.planning.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="trip_id")
	private Integer id;
	String placeOfDeparture;
	String arrivalEmplacement;
	String transportCompany;
	BigDecimal transportPrice;
	String accommodationName;
	BigDecimal accommodationPrice;
	@Temporal(TemporalType.DATE)
	@Column(name = "starts_at")
	@NotNull
	private Date startsAt;
	@Temporal(TemporalType.DATE)
	@Column(name = "ends_on")
	@NotNull
	private Date endsOn;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	private Date createdAt;
	
	public Trip(){}
	
	@PrePersist
	void createdAt() {
	    this.createdAt = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getTransportPrice() {
		return transportPrice;
	}

	public void setTransportPrice(BigDecimal transportPrice) {
		this.transportPrice = transportPrice;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public BigDecimal getAccommodationPrice() {
		return accommodationPrice;
	}

	public void setAccommodationPrice(BigDecimal accommodationPrice) {
		this.accommodationPrice = accommodationPrice;
	}
	
	public Date getStartsAt() {
		return startsAt;
	}
	
	public void setStartsAt(Date startsAt) {
		this.startsAt = startsAt;
	}
	
	public Date getEndsOn() {
		return endsOn;
	}
	
	public void setEndsOn(Date endsOn) {
		this.endsOn = endsOn;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
}
