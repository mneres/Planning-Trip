package com.planning.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Schedule{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="schedule_id")
	private Integer id;
	@NotNull
	@Column(nullable = false)
	private String name;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="schedule_trips", joinColumns={@JoinColumn(name="schedule_id", referencedColumnName="schedule_id")}, inverseJoinColumns={@JoinColumn(name="trip_id", referencedColumnName="trip_id")})
	private List<Trip> trips = new ArrayList<Trip>();
    
    public Schedule(){}
    
    public Schedule(String name){
    	this.name = name;
    }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Trip> getTrips() {
		return trips;
	}
	public void addTrip(Trip trip) {
		this.trips.add(trip);
	}

	public int countTrip() {
		return this.trips.size();
	}

	public boolean removeTrip(Trip trip) {
		int index = 0;
		for(Trip t: this.trips){
			if(t.equals(trip)){
				this.trips.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}
}
