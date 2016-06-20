package com.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planning.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>{

}
