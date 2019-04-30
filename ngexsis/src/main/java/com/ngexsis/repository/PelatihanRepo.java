package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.PelatihanModel;

@Repository
public interface PelatihanRepo extends JpaRepository<PelatihanModel, Long>{
	
}
