package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.OrganisasiModel;

@Repository
public interface OrganisasiRepo extends JpaRepository<OrganisasiModel, Long> {

}
