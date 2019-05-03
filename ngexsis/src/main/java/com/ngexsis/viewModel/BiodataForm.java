package com.ngexsis.viewModel;

import com.ngexsis.model.AddressModel;
import com.ngexsis.model.BiodataModel;

public class BiodataForm {

	private BiodataModel biodata;
	
	private AddressModel address;

	public BiodataModel getBiodata() {
		return biodata;
	}

	public void setBiodata(BiodataModel biodata) {
		this.biodata = biodata;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}
	
	
}
