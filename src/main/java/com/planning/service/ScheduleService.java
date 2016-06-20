package com.planning.service;

import java.util.List;

import com.planning.model.Schedule;

public interface ScheduleService {
	Schedule addSchedule(Schedule schedule);

	Schedule findOneById(Integer id);

	boolean remove(Integer id);

	Schedule editSchedule(Schedule schedule);

	List<Schedule> listAll();
}
