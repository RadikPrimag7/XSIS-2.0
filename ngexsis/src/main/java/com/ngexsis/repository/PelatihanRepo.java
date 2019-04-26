package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelatihanRepo extends JpaRepository<PelatihanRepo, Long> {

}
