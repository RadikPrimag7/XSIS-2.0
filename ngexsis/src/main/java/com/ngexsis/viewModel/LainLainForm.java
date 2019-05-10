package com.ngexsis.viewModel;

import com.ngexsis.model.KeteranganTambahanModel;
import com.ngexsis.model.ReferensiModel;

public class LainLainForm {
	private KeteranganTambahanModel ketam;
	
	private ReferensiModel referensi;

	public KeteranganTambahanModel getKetam() {
		return ketam;
	}

	public void setKetam(KeteranganTambahanModel ketam) {
		this.ketam = ketam;
	}

	public ReferensiModel getReferensi() {
		return referensi;
	}

	public void setReferensi(ReferensiModel referensi) {
		this.referensi = referensi;
	}
}
