package com.ngexsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.NoteTypeModel;

@Repository
public interface NoteTypeRepo extends JpaRepository<NoteTypeModel, Long>{

}
