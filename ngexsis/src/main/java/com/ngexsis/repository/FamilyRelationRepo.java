package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.FamilyRelationModel;

@Repository
public interface FamilyRelationRepo extends JpaRepository<FamilyRelationModel, Long>{

}
