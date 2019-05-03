package com.ngexsis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "x_family_relation")
public class FamilyRelationModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "family_relasi_seq")
	@TableGenerator(name = "family_relasi_seq", table = "tbl_sequence", pkColumnName = "seq_id",
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Long id;
	
	@Column(name = "created_by", nullable = false, length = 11)
	private long createdBy;
	
	@Column(name = "created_on", nullable = false)
	private Date createdOn;
	
	@Column(name = "modified_by", nullable = true, length = 11)
	private long modifiedBy;
	
	@Column(name = "modified_on", nullable = true)
	private Date modifiedOn;
	
	@Column(name = "deleted_by", nullable = true, length = 11)
	private long deletedBy;
	
	@Column(name = "deleted_on", nullable = true)
	private Date deletedOn;
	
	@Column(name = "is_delete", nullable = false)
	private boolean isDelete;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "description", nullable = true, length = 100)
	private String description;
	
	@Column(name = "family_tree_type_id", nullable = true, length = 11, updatable = false, insertable = false)
	private long familyTreeTypeId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="family_tree_type_id", foreignKey = @ForeignKey(name ="fk_familyTree"))
	private FamilyTreeModel familyTree1;
	

	@JsonManagedReference
	@OneToMany(mappedBy = "familyRelation", cascade = CascadeType.ALL)
	private List<KeluargaModel> listKeluargaModel = new ArrayList<KeluargaModel>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public long getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Date getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public long getDeletedBy() {
		return deletedBy;
	}


	public void setDeletedBy(long deletedBy) {
		this.deletedBy = deletedBy;
	}


	public Date getDeletedOn() {
		return deletedOn;
	}


	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}


	public boolean isDelete() {
		return isDelete;
	}


	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public long getFamilyTreeTypeId() {
		return familyTreeTypeId;
	}


	public void setFamilyTreeTypeId(long familyTreeTypeId) {
		this.familyTreeTypeId = familyTreeTypeId;
	}


	public FamilyTreeModel getFamilyTree1() {
		return familyTree1;
	}


	public void setFamilyTree1(FamilyTreeModel familyTree1) {
		this.familyTree1 = familyTree1;
	}


	public List<KeluargaModel> getListKeluargaModel() {
		return listKeluargaModel;
	}


	public void setListKeluargaModel(List<KeluargaModel> listKeluargaModel) {
		this.listKeluargaModel = listKeluargaModel;
	}
	
}
