package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.KeahlianModel;

@Repository
public interface KeahlianRepo extends JpaRepository<KeahlianModel, Long>{

}
