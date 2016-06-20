package com.planning.service;

import com.planning.model.Action;

public interface ActionService {
	Action addAction(Action action);
	
	Action updateAction(Action action);
	
	boolean deleteAction(Integer id);
}
