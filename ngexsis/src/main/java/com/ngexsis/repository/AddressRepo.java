package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.AddressModel;

@Repository
public interface AddressRepo extends JpaRepository<AddressModel, Long> {

}
