package com.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planning.model.Schedule;
import com.planning.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
		this.scheduleRepository = scheduleRepository;
	}

	@Override
	public Schedule addSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
		return schedule;
	}

	@Override
	public Schedule findOneById(Integer id) {
		return scheduleRepository.findOneById(id);
	}

	@Override
	public boolean remove(Integer id) {
		try{
			scheduleRepository.delete(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Schedule editSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
		return schedule;
	}

	@Override
	public List<Schedule> listAll() {
		List<Schedule> list = new ArrayList<Schedule>();
		try{
			list = scheduleRepository.findAll();
		}catch(Exception e){
		}
		return list;
	}
}
