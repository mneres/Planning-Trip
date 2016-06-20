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
import com.planning.model.Schedule;
import com.planning.model.Trip;
import com.planning.service.ScheduleService;
import com.planning.service.TripService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration
@Transactional
public class ScheduleServiceTest {
	
	private ScheduleService scheduleService;
	private TripService tripService;
		
	@Autowired
	public void setService(ScheduleService scheduleService, TripService tripService){
		this.scheduleService = scheduleService;
		this.tripService = tripService;
	}

	@Test
	public void addSchedule() {
		Schedule schedule = createSchedule();	
		scheduleService.addSchedule(schedule);
		assertNotNull(schedule.getId());
	}
	
	@Test
	public void deleteSchedule() {
		Schedule schedule = createSchedule();
		scheduleService.addSchedule(schedule);		
		assertTrue(scheduleService.remove(schedule.getId()));
	}
	
	@Test
	public void editSchedule() {
		Schedule schedule = createSchedule();
		
		scheduleService.addSchedule(schedule);
		
		schedule.setName("Second trip");
		scheduleService.editSchedule(schedule);
		
		Schedule schedule2 = scheduleService.findOneById(schedule.getId());
		assertEquals("Second trip", schedule2.getName());
	}
	
	@Test
	public void addTripOnSchedule(){
		Trip trip = createTrip("dublin", "amsterdam", 100);
		Trip trip2 = createTrip("amsterdam", "berlin", 20);
		
		Schedule schedule = createSchedule();	
		schedule.addTrip(trip);
		schedule.addTrip(trip2);
		scheduleService.addSchedule(schedule);
		
		Schedule schedule2 = scheduleService.findOneById(schedule.getId());
		assertEquals(2, schedule2.countTrip());
	}
	
	@Test
	public void removeTripFromSchedule(){
		Trip trip = createTrip("dublin", "amsterdam", 100);
		Schedule schedule = createSchedule();	
		
		schedule.addTrip(trip);
		scheduleService.addSchedule(schedule);
		
		schedule.removeTrip(trip);
		assertTrue(tripService.remove(trip.getId()));
		
		Schedule schedule2 = scheduleService.findOneById(schedule.getId());
		assertEquals(0, schedule2.countTrip());
	}

	private Schedule createSchedule() {
		Schedule schedule = new Schedule("Euro trip");
		return schedule;
	}

	private Trip createTrip(String placeOfDeparture, 
			String arrivalEmplacement, int transportPrice) {
		Trip trip = new Trip();
		trip.setPlaceOfDeparture(placeOfDeparture);
		trip.setArrivalEmplacement(arrivalEmplacement);
		trip.setTransportPrice(transportPrice);
		return trip;
	}
}
