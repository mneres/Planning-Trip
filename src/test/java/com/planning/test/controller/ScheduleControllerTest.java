package com.planning.test.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.planning.model.Schedule;
import com.planning.model.Trip;
import com.planning.service.ScheduleService;
import com.planning.test.AbstractControllerTest;

@Transactional
public class ScheduleControllerTest extends AbstractControllerTest {
	@Autowired	
    private WebApplicationContext context;
	private MockMvc mockMvc;
	private ScheduleService scheduleService;
	
	@Autowired
	public void setService(ScheduleService scheduleService){
		this.scheduleService = scheduleService;
	}
	
    @Before
    public void setUp() {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).dispatchOptions(true).build(); 
    }

	@Test
	public void getSchedules() throws Exception{
        String uri = "/api/schedules";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
        		.get(uri)
        		.accept(MediaType.APPLICATION_JSON))
        		.andReturn();
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
	}
	
	@Test
	public void getScheduleById() throws Exception{
        String uri = "/api/schedules";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
        		.get(uri + "/1")
        		.accept(MediaType.APPLICATION_JSON))
        		.andReturn();
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
	}
	
	@Test
	public void addSchedule() throws Exception{
        String uri = "/api/schedules";
		Schedule schedule = createSchedule();
		
		String inputJson = super.mapToJson(schedule);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
        		.contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(inputJson))
				.andReturn();
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
	}
	
	@Test
	public void addTripOnSchedule() throws Exception{
        String uri = "/api/schedules";
        
		Schedule schedule = createSchedule();
		scheduleService.addSchedule(schedule);

		Trip trip = createTrip();
		
		String inputJson = super.mapToJson(trip);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
				.post(uri + "/" + schedule.getId() + "/addTrip")
        		.contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(inputJson))
				.andReturn();
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
	}

	private Schedule createSchedule() {
		Schedule schedule = new Schedule("First trip");
		return schedule;
	}

	private Trip createTrip() {
		Trip trip = new Trip();
		trip.setPlaceOfDeparture("dublin");
		trip.setArrivalEmplacement("amsterdam");
		trip.setTransportPrice(new BigDecimal("" + 100.00).setScale(2,
	            BigDecimal.ROUND_HALF_UP));
		trip.setStartsAt(new Date());
		trip.setEndsOn(new Date());
		return trip;
	}
}
