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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="x_biodata")
public class BiodataModel {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="biodata_seq")
	@TableGenerator(name="biodata_seq", table="tbl_sequence", pkColumnName="seq_id", valueColumnName="seq_value",
	initialValue=0, allocationSize=1)
	private Long id;
	
	@Column(name="fullname", length=255, nullable=false)
	private String fullname;
	
	@Column(name="nick_name", length=100, nullable=false)
	private String nickName;
	
	@Column(name="pob", length=100, nullable=false)
	private String pob;
	
	@Column(name="dob", nullable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="gender", nullable=false)
	private boolean gender;
	
	@Column(name="religion_id", length=11, nullable=false)
	private Long religionId;
	
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name="religion_id", foreignKey = @ForeignKey(name="fk_religion"))
//	private ReligionModel religion;
	
	@Column(name="height")
	private int height;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="nationality", length=100)
	private String nationality;
	
	@Column(name="ethnic", length=50)
	private String ethnic;
	
	@Column(name="hobby", length=255)
	private String hobby;
	
	@Column(name="identity_type_id", length=11, nullable=false)
	private Long identityTypeId;
	
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name="identity_type_id", foreignKey = @ForeignKey(name="fk_identity_type"))
//	private IdentityTypeModel identityType;
	
	@Column(name="identity_no", length=50, nullable=false)
	private String identityNo;
	
	@Column(name="email", length=100, nullable=false)
	private String email;
	
	@Column(name="phone_number1", length=50, nullable=false)
	private String phoneNumber1;

	@Column(name="phone_number2", length=50)
	private String phoneNumber2;
	
	@Column(name="parent_phone_number", length=50, nullable=false)
	private String parentPhoneNumber;
	
	@Column(name="child_sequence", length=5)
	private String childSequence;
	
	@Column(name="how_many_brothers", length=5)
	private String howManyBrothers;
	
	@Column(name="marital_status_id", length=11, nullable=false)
	private Long maritalStatusId;
	
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name="marital_status_id", foreignKey = @ForeignKey(name="fk_marital_status"))
//	private MaritalStatusModel maritalStatus;
	
	@Column(name="addrbook_id", length=11)
	private Long addrbookId;
	
	@Column(name="token", length=10)
	private String token;
	
	@Column(name="expired_token")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date expiredToken;
	
	@Column(name="marriage_year", length=10)
	private String marriageYear;
	
	@JsonManagedReference
	@OneToMany (mappedBy = "biodataPelatihan", cascade = CascadeType.ALL)
	private List<PelatihanModel> listPelatihan = new ArrayList<PelatihanModel>();
	
	@JsonManagedReference
	@OneToMany (mappedBy = "biodataKeluarga", cascade = CascadeType.ALL)
	private List<KeluargaModel> listKeluarga = new ArrayList<KeluargaModel>();
	
	@JsonManagedReference
	@OneToMany (mappedBy = "biodataSumber", cascade = CascadeType.ALL)
	private List<SumberLokerModel> listLoker = new ArrayList<SumberLokerModel>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "biodataPengalaman", cascade = CascadeType.ALL)
	private List<PengalamanKerjaModel> listPengalaman = new ArrayList<PengalamanKerjaModel>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "biodataSertifikasi", cascade = CascadeType.ALL)
	private List<SertifikasiModel> listSertifikasi = new ArrayList<SertifikasiModel>();
	
	
	
	
//	@OneToMany(mappedBy = "keahlian", cascade = CascadeType.ALL)
//	private List<KeahlianModel> keahlian = new ArrayList<KeahlianModel>();

	
	
	

//	public List<KeahlianModel> getKeahlian() {
//		return keahlian;
//	}
//
//	public void setKeahlian(List<KeahlianModel> keahlian) {
//		this.keahlian = keahlian;
//	}

	public List<PelatihanModel> getListPelatihan() {
		return listPelatihan;
	}

	public void setListPelatihan(List<PelatihanModel> listPelatihan) {
		this.listPelatihan = listPelatihan;
	}

	public List<KeluargaModel> getListKeluarga() {
		return listKeluarga;
	}

	public void setListKeluarga(List<KeluargaModel> listKeluarga) {
		this.listKeluarga = listKeluarga;
	}

	public List<SumberLokerModel> getListLoker() {
		return listLoker;
	}

	public void setListLoker(List<SumberLokerModel> listLoker) {
		this.listLoker = listLoker;
	}

	public String getMarriageYear() {
		return marriageYear;
	}

	public void setMarriageYear(String marriageYear) {
		this.marriageYear = marriageYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Long getReligionId() {
		return religionId;
	}

	public void setReligionId(Long religionId) {
		this.religionId = religionId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Long getIdentityTypeId() {
		return identityTypeId;
	}

	public void setIdentityTypeId(Long identityTypeId) {
		this.identityTypeId = identityTypeId;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getParentPhoneNumber() {
		return parentPhoneNumber;
	}

	public void setParentPhoneNumber(String parentPhoneNumber) {
		this.parentPhoneNumber = parentPhoneNumber;
	}

	public String getChildSequence() {
		return childSequence;
	}

	public void setChildSequence(String childSequence) {
		this.childSequence = childSequence;
	}

	public String getHowManyBrothers() {
		return howManyBrothers;
	}

	public void setHowManyBrothers(String howManyBrothers) {
		this.howManyBrothers = howManyBrothers;
	}

	public Long getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Long maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Long getAddrbookId() {
		return addrbookId;
	}

	public void setAddrbookId(Long addrbookId) {
		this.addrbookId = addrbookId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiredToken() {
		return expiredToken;
	}

	public void setExpiredToken(Date expiredToken) {
		this.expiredToken = expiredToken;
	}

	public List<PengalamanKerjaModel> getListPengalaman() {
		return listPengalaman;
	}

	public void setListPengalaman(List<PengalamanKerjaModel> listPengalaman) {
		this.listPengalaman = listPengalaman;
	}

	public List<SertifikasiModel> getListSertifikasi() {
		return listSertifikasi;
	}

	public void setListSertifikasi(List<SertifikasiModel> listSertifikasi) {
		this.listSertifikasi = listSertifikasi;
	}


//
//	public ReligionModel getReligion() {
//		return religion;
//	}
//
//	public void setReligion(ReligionModel religion) {
//		this.religion = religion;
//	}
//	
//	public IdentityTypeModel getIdentityType() {
//		return identityType;
//	}
//
//	public void setIdentityType(IdentityTypeModel identityType) {
//		this.identityType = identityType;
//	}
//
//	public MaritalStatusModel getMaritalStatus() {
//		return maritalStatus;
//	}
//
//	public void setMaritalStatus(MaritalStatusModel maritalStatus) {
//		this.maritalStatus = maritalStatus;
//	}
}
