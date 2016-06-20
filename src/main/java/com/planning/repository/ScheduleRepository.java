package com.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planning.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	public Schedule findOneById(Integer id);
}
