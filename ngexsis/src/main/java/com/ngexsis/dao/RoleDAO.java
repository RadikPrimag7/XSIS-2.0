package com.ngexsis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ngexsis.model.UserRoleModel;



@Repository
@Transactional
public class RoleDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<String> getRoleNames(Long id) {
        String sql = "Select ur.roleModel.name from " + UserRoleModel.class.getName() + " ur " //
                + " where ur.userModel.id = :id ";
		
		Query query=this.entityManager.createQuery(sql, String.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
}
