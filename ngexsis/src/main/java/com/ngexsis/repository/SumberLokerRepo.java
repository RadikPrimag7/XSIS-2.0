package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.SumberLokerModel;

@Repository
public interface SumberLokerRepo extends JpaRepository<SumberLokerModel, Long> {

}
