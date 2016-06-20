package com.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planning.model.Action;

public interface ActionRepository extends JpaRepository<Action, Integer> {
}
