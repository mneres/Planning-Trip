package com.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planning.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Integer> {
	public Goal findOneById(Integer id);
}
