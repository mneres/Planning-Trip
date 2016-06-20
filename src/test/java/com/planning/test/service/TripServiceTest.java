package com.planning.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.planning.Application;
import com.planning.model.Trip;
import com.planning.service.TripService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration
@Transactional
public class TripServiceTest {

	@Autowired
	private TripService tripService;
	
	@Autowired
	public void SetService(TripService tripService){
		this.tripService = tripService;
	}
	
	@Test
	public void addTrip() {
		Trip trip = createTrip();
		assertNotNull(trip.getId());
	}
	
	@Test
	public void removeTrip(){	
		Trip trip = createTrip();
		assertTrue(tripService.remove(trip.getId()));
	}
	
	@Test
	public void editTrip(){	
		Trip trip = createTrip();
		assertEquals("dublin", trip.getPlaceOfDeparture());
		
		trip.setPlaceOfDeparture("cork");
		tripService.edit(trip);
		
		assertEquals("cork", trip.getPlaceOfDeparture());
	}

	private Trip createTrip() {
		Trip trip = new Trip();
		trip.setPlaceOfDeparture("dublin");
		trip.setArrivalEmplacement("amsterdam");
		trip.setTransportPrice(100);
		tripService.addTrip(trip);
		return trip;
	}
}
