package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.IdentityTypeModel;

@Repository
public interface IdentityTypeRepo extends JpaRepository<IdentityTypeModel, Long> {

}
