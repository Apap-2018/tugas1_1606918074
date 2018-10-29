package com.apap.tugas1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;

@Service
@Transactional
public interface JabatanService {
	List<JabatanModel> getAllJabatan();
	JabatanModel getJabatanDetailById(Long id);
	void addJabatan(JabatanModel jabatan);
	void deleteJabatan(JabatanModel jabatan);
}
