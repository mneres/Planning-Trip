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

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController extends BaseController{
	
	private ScheduleService scheduleService;
	
	@Autowired
	public void setService(ScheduleService scheduleService){
		this.scheduleService = scheduleService;
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
	
	@RequestMapping(value = "/{id}/addTrip", method = RequestMethod.POST)
	public Trip addTripOnSchedule(@PathVariable Integer id, @RequestBody Trip trip) {
		Schedule schedule = scheduleService.findOneById(id);
		schedule.addTrip(trip);
		scheduleService.addSchedule(schedule);
		return trip;
	}
}		
