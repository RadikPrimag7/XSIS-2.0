package com.ngexsis.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="x_religion")
public class ReligionModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "religion_seq")
	@TableGenerator(name="religion_seq", table="tbl_sequence", pkColumnName="seq_id", valueColumnName="seq_value",
	initialValue=0, allocationSize=1)
	private Long id;
	
	@Column(name="name", length=50, nullable=false)
	private String name;
	
	@Column(name="description", length=100)
	private String description;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy="religion", cascade = CascadeType.ALL)
//	private List<BiodataModel> listBiodata = new ArrayList<BiodataModel>();

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
//
//	public List<BiodataModel> getListBiodata() {
//		return listBiodata;
//	}
//
//	public void setListBiodata(List<BiodataModel> listBiodata) {
//		this.listBiodata = listBiodata;
//	}

}
