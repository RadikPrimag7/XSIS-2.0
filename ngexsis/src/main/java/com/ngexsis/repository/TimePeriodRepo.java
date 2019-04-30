package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.TimePeriodModel;

@Repository
public interface TimePeriodRepo extends JpaRepository<TimePeriodModel, Long> {

}
