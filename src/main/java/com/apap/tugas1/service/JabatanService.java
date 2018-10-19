package com.apap.tugas1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanModel;

@Service
@Transactional
public interface JabatanService {
	List<JabatanModel> getAllJabatan();
}
