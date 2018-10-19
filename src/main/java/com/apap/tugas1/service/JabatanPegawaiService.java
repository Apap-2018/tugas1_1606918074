package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanPegawaiModel;

public interface JabatanPegawaiService {
	List<JabatanPegawaiModel> getJabatanPegawaiListByIdPegawai(Long idPegawai);
	
	void addJabatanPegawai(JabatanPegawaiModel jabatanPegawaiModel);
}
