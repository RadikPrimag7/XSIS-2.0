package com.ngexsis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="x_userrole",
		uniqueConstraints = {
				@UniqueConstraint(name="x_userrole_UK", columnNames= {"addrbook_id","role_id"})
		})
public class UserRoleModel {
	
	@Id
	@GeneratedValue
	@Column(name="Id",nullable=false)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="addrbook_id", foreignKey=@ForeignKey(name="fk_user"), nullable=false)
	private UserModel userModel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id", foreignKey=@ForeignKey(name="fk_role"), nullable=false)
	private RoleModel roleModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}



	
	
}
