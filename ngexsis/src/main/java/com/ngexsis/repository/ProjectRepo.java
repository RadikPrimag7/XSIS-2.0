package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.ProjectModel;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectModel, Long> {

}
