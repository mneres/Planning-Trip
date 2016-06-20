package com.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planning.model.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Integer> {

}
