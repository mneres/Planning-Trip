package com.planning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.planning.model.Schedule;
import com.planning.model.Trip;
import com.planning.service.ScheduleService;
import com.planning.service.TripService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController extends BaseController{
	
	private ScheduleService scheduleService;
	private TripService tripService;
	
	@Autowired
	public void setService(ScheduleService scheduleService, TripService tripService){
		this.scheduleService = scheduleService;
		this.tripService = tripService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Schedule> findItems() {
		return scheduleService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Schedule addSchedule(@RequestBody Schedule schedule) {
		scheduleService.addSchedule(schedule);
		return schedule;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Schedule getSchedule(@PathVariable Integer id) {
		return scheduleService.findOneById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Schedule updateSchedule(@RequestBody Schedule updatedSchedule, @PathVariable Integer id) {
		updatedSchedule.setId(id);
		scheduleService.editSchedule(updatedSchedule);
		return updatedSchedule;
	}
  
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSchedule(@PathVariable Integer id) {
		scheduleService.remove(id);
	}
	
	@RequestMapping(value = "/{idSchedule}/addTrip", method = RequestMethod.POST)
	public Trip addTripOnSchedule(@PathVariable Integer idSchedule, @RequestBody Trip trip) {
		Schedule schedule = scheduleService.findOneById(idSchedule);
		schedule.addTrip(trip);
		scheduleService.editSchedule(schedule);
		return trip;
	}
	
	@RequestMapping(value = "/{idSchedule}/removeTrip/{idTrip}", method = RequestMethod.DELETE)
	public void removeTripFromSchedule(@PathVariable Integer idSchedule, @PathVariable Integer idTrip) {
		Schedule schedule = scheduleService.findOneById(idSchedule);
		Trip trip = tripService.findOneByID(idTrip);
		schedule.removeTrip(trip);
		scheduleService.editSchedule(schedule);
		tripService.remove(idTrip);
	}
	
	@RequestMapping(value = "/editTrip/{id}", method = RequestMethod.PUT)
	public Trip updateTrip(@RequestBody Trip updatedTrip, @PathVariable Integer id) {
		updatedTrip.setId(id);
		tripService.editTrip(updatedTrip);
		return updatedTrip;
	}	
}		
