package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.KeluargaModel;

@Repository
public interface KeluargaRepo extends JpaRepository<KeluargaModel, Long> {

}
