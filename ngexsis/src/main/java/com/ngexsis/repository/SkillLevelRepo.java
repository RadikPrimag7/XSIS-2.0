package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.SkillLevelModel;

@Repository
public interface SkillLevelRepo extends JpaRepository<SkillLevelModel, Long>{

}
