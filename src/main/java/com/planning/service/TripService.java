package com.planning.service;

import com.planning.model.Trip;

public interface TripService {
	Trip addTrip(Trip trip);
	
	boolean remove(Integer id);

	Trip editTrip(Trip trip);

	Trip findOneByID(Integer id);
}
