package com.ngexsis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="x_userrole")
public class UserRoleModel {

	@Id
	private long id;
	private long addrbookId;
	private long role_id;
}
