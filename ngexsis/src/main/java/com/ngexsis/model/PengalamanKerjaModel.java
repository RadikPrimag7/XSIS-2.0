package com.ngexsis.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="x_riwayat_pekerjaan")
public class PengalamanKerjaModel {

	
	private long id;
	private long createdBy;
	private Date createdOn;
	private long modifiedBy;
	private Date modifiedOn;
	private long deletedBy;
	private Date DeletedOn;
	private boolean isDelete;
	private long biodataId;
	private String companyName;
	private String city;
	private String country;
	private String joinYear;
	private String joinMonth;
	private String resignYear;
	private String resignMonth;
	private String lastPosition;
	private String income;
	private boolean isItRelated;
	private String aboutJob;
	private String exitReason;
	private String notes;
	
}
