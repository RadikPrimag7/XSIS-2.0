package com.ngexsis.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="x_riwayat_pekerjaan")
public class PengalamanKerjaModel {

	@Id
	@Column(name="id", nullable=false, length=11)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pengalaman_kerja_seq")
	@TableGenerator(name = "pengalaman_kerja_seq", table = "tbl_sequence", pkColumnName = "seq_id",
	valueColumnName = "seq_value", initialValue = 0, allocationSize = 1)
	private long id;
	
	
	@Column(name="biodata_id", nullable=false,length=11)
	private long biodataId;
	
	@Column(name="company_name",length=100)
	private String companyName;
	
	@Column(name="city",length=50)
	private String city;
	
	@Column(name="country",length=50)
	private String country;
	
	@Column(name="join_year",length=10)
	private String joinYear;
	
	@Column(name="join_month",length=10)
	private String joinMonth;
	
	@Column(name="resign_year",length=10)
	private String resignYear;
	
	@Column(name="resign_month",length=10)
	private String resignMonth;
	
	@Column(name="last_position",length =100)
	private String lastPosition;
	
	@Column(name="income",length=20)
	private String income;
	
	@Column(name="is_it_related")
	private boolean isItRelated;
	
	@Column(name="about_job",length=1000)
	private String aboutJob;
	
	@Column(name="exit_reason",length=500)
	private String exitReason;
	
	@Column(name="notes",length=5000)
	private String notes;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(long biodataId) {
		this.biodataId = biodataId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJoinYear() {
		return joinYear;
	}

	public void setJoinYear(String joinYear) {
		this.joinYear = joinYear;
	}

	public String getJoinMonth() {
		return joinMonth;
	}

	public void setJoinMonth(String joinMonth) {
		this.joinMonth = joinMonth;
	}

	public String getResignYear() {
		return resignYear;
	}

	public void setResignYear(String resignYear) {
		this.resignYear = resignYear;
	}

	public String getResignMonth() {
		return resignMonth;
	}

	public void setResignMonth(String resignMonth) {
		this.resignMonth = resignMonth;
	}

	public String getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(String lastPosition) {
		this.lastPosition = lastPosition;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public boolean isItRelated() {
		return isItRelated;
	}

	public void setItRelated(boolean isItRelated) {
		this.isItRelated = isItRelated;
	}

	public String getAboutJob() {
		return aboutJob;
	}

	public void setAboutJob(String aboutJob) {
		this.aboutJob = aboutJob;
	}

	public String getExitReason() {
		return exitReason;
	}

	public void setExitReason(String exitReason) {
		this.exitReason = exitReason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
