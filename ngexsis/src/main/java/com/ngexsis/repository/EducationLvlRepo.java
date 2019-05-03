package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.EducationLvlModel;

@Repository
public interface EducationLvlRepo extends JpaRepository<EducationLvlModel, Long> {

}
