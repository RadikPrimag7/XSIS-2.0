package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.SertifikasiModel;



@Repository
public interface SertifikasiRepo extends JpaRepository<SertifikasiModel, Long> {

}
