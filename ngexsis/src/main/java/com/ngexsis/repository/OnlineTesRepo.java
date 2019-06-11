package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.OnlineTesModel;

@Repository
public interface OnlineTesRepo extends JpaRepository<OnlineTesModel, Long>{

}
