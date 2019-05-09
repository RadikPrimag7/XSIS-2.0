package com.ngexsis.viewModel;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.KeahlianModel;
import com.ngexsis.model.PelatihanModel;
import com.ngexsis.model.PendidikanModel;
import com.ngexsis.model.PengalamanKerjaModel;
import com.ngexsis.model.SertifikasiModel;

public class ProfilForm {
	private BiodataModel biodata;
	
	private PendidikanModel pendidikan;
	
	private PengalamanKerjaModel pengalaman;
	
	private KeahlianModel keahlian;
	
	private PelatihanModel pelatihan;
	
	private SertifikasiModel sertifikasi;

	public BiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(BiodataModel biodata) {
		this.biodata = biodata;
	}

	public PendidikanModel getPendidikan() {
		return pendidikan;
	}

	public void setPendidikan(PendidikanModel pendidikan) {
		this.pendidikan = pendidikan;
	}

	public PengalamanKerjaModel getPengalaman() {
		return pengalaman;
	}

	public void setPengalaman(PengalamanKerjaModel pengalaman) {
		this.pengalaman = pengalaman;
	}

	public KeahlianModel getKeahlian() {
		return keahlian;
	}

	public void setKeahlian(KeahlianModel keahlian) {
		this.keahlian = keahlian;
	}

	public PelatihanModel getPelatihan() {
		return pelatihan;
	}

	public void setPelatihan(PelatihanModel pelatihan) {
		this.pelatihan = pelatihan;
	}

	public SertifikasiModel getSertifikasi() {
		return sertifikasi;
	}

	public void setSertifikasi(SertifikasiModel sertifikasi) {
		this.sertifikasi = sertifikasi;
	}
	
	
}
