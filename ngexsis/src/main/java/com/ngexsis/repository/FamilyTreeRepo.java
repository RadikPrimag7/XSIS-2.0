package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.FamilyTreeModel;

@Repository
public interface FamilyTreeRepo extends JpaRepository<FamilyTreeModel, Long> {

}
