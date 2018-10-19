package com.apap.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService{
	@Autowired
	JabatanDb jabatanDb;
	
	@Override
	public List<JabatanModel> getJabatan() {
		// TODO Auto-generated method stub
		return jabatanDb.findAll();
	}
	
}
