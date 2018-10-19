package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;

public interface InstansiService {
	InstansiModel getInstansiDetailByIdInstansi(Long id);
	List<InstansiModel> getAllInstansi(Integer id_provinsi);

    InstansiModel getInstansibyNamaAndIdProvinsi(String nama, Long id_provinsi);

}
