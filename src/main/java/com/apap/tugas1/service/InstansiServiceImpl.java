package com.apap.tugas1.service;

import java.util.List;

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

	@Override
    public InstansiModel getInstansibyNamaAndIdProvinsi(String nama, Long id_provinsi) {
        return instansiDb.findInstansiModelByNamaAndId_provinsi(nama, id_provinsi);
    }

	@Override
    @Transactional(readOnly = false)
    public List<InstansiModel> getAllInstansi(Integer id) {
        return instansiDb.findAllById_provinsi(id);
    }
	
}
