package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.repository.InstansiDb;

@Service
@Transactional
public class InstansiServiceImpl implements InstansiService{
	@Autowired
    InstansiDb instansiDb;
	
	@Override
	public InstansiModel getInstansiDetailByIdInstansi(Long id) {
		// TODO Auto-generated method stub
		return instansiDb.findInstansiModelById(id);
	}

	
}
