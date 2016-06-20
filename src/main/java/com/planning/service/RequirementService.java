package com.planning.service;

import com.planning.model.Requirement;

public interface RequirementService {
	Requirement addRequirement(Requirement req);
	
	Requirement updateRequirement(Requirement req);
	
	boolean deleteRequirement(Integer id);
}
