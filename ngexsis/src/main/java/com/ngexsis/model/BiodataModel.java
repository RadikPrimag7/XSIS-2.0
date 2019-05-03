package com.ngexsis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name ="x_biodata")
public class BiodataModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "biodata_seq")
	@TableGenerator(name = "biodata_seq", table = "tbl_sequence", pkColumnName = "seq_id",
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private Long id;
}
