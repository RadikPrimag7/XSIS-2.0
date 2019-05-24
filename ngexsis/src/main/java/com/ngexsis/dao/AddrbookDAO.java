package com.ngexsis.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngexsis.model.UserModel;





@Repository
@Transactional
public class AddrbookDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public UserModel findUserAccount(String email) {
		try {
			String sql = "Select e from " + UserModel.class.getName() + " e " //
                    + " Where e.email = :email or e.abuid = :email";
			
		Query query=entityManager.createQuery(sql, UserModel.class);
		query.setParameter("email",email);
		
		return(UserModel)query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
}
