package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.MaritalStatusModel;

@Repository
public interface MaritalStatusRepo extends JpaRepository<MaritalStatusModel, Long> {

}
