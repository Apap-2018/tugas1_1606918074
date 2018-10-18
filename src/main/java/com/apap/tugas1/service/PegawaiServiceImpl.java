package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDb;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {
	@Autowired
	private PegawaiDb pegawaiDb;
	
	@Override
	public PegawaiModel getPegawaiDetailByNip(String nip) {
		// TODO Auto-generated method stub
		return pegawaiDb.findByNip(nip);
	}

	@Override
	public void addPegawai(PegawaiModel pegawai) {
		// TODO Auto-generated method stub
		// method itungannya dmn yak
		//method itungan itu nanti ngebalikin NIP pegawai
		//semacam dipanggil di htmlnya sblm manggil method ini
		pegawaiDb.save(pegawai);
		
	}

	@Override
	public void generateNip(PegawaiModel pegawai) {
		// TODO Auto-generated method stub
		
		
	}
	
	

}
