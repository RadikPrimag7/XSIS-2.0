package com.ngexsis.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngexsis.model.UserModel;


@Repository
@EntityScan(basePackages = "ngexsis.model")
public interface UserRepo extends JpaRepository<UserModel, Long>{

	@Query(value="SELECT * FROM x_addrbook WHERE (email = ?1 OR abuid=?1) AND abpwd = ?2", nativeQuery = true)
    public List<UserModel> find(String email, String abpwd);
	
}
