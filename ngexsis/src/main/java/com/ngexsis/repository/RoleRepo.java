package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.RoleModel;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Long>{

}
