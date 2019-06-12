package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.OnlineTestDetailModel;

@Repository
public interface OnlineTesDetailRepo extends JpaRepository<OnlineTestDetailModel, Long>{

}
