package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.BiodataModel;

@Repository
public interface BiodataRepo extends JpaRepository<BiodataModel, Long> {

}
