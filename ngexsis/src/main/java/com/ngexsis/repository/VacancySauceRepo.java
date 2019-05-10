package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.VacancySauceModel;

@Repository
public interface VacancySauceRepo extends JpaRepository<VacancySauceModel, Long> {

}
