package com.planning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planning.model.Trip;
import com.planning.repository.TripRepository;

@Service
public class TripServiceImpl implements TripService{
	
	private TripRepository tripRepository;
	
	@Autowired
	public TripServiceImpl(TripRepository tripRepository){
		this.tripRepository = tripRepository;
	}

	@Override
	public Trip addTrip(Trip trip) {
		tripRepository.save(trip);
		return trip;
	}
	
	@Override
	public boolean remove(Integer id) {
		try{
			tripRepository.delete(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Trip editTrip(Trip trip) {
		tripRepository.save(trip);
		return trip;
	}

	@Override
	public Trip findOneByID(Integer id) {
		return tripRepository.findOneById(id);
	}

}
