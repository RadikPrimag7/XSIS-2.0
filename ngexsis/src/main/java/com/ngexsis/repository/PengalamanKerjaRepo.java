package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.PengalamanKerjaModel;

@Repository
public interface PengalamanKerjaRepo extends JpaRepository<PengalamanKerjaModel, Long>{

}
