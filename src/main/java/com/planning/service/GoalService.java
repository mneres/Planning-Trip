package com.planning.service;

import java.util.List;

import com.planning.model.Action;
import com.planning.model.Goal;
import com.planning.model.Requirement;

public interface GoalService {
	Goal addGoal(Goal goal, List<Requirement> requirements, List<Action> actions);
	
	Goal updateGoal(Goal goal, List<Requirement> requirements, List<Action> actions);
	
	void deleteGoal(Integer id);
	
	List<Goal> listAll();
	
	Goal findOneById(Integer id);
	
	Requirement addRequirementInGoal(Requirement requirement, Goal goal);
}