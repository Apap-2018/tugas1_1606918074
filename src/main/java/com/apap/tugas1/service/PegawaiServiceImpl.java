package com.apap.tugas1.service;


import java.text.SimpleDateFormat;
import java.util.List;

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
		pegawaiDb.save(pegawai);
		
	}

	@Override
	public void generateNip(PegawaiModel pegawai) {
		// TODO Auto-generated method stub
		System.out.println("masuuuk nih generate nip");
		String nip = "";
		String instansi = pegawai.getId_instansi().toString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(pegawai.getTanggal_lahir());
		String birthdate[] = format.split("-");
//		System.out.println("birthdatee "+ new Gson().toJson(birthdate));
		String year = birthdate[0].substring(2,4);
		String month = birthdate[1];
		String day = birthdate[2];
		String tahunmasuk = pegawai.getTahun_masuk();
		String nipkurangduadigit = instansi + day + month + year + tahunmasuk;
		Integer lastdigit = 1;
		String buatditambah = "";

		List<PegawaiModel> pegawaiModels = pegawaiDb.findPegawaiModelsById_instansiAndAndTahun_masukAndAndTanggal_lahirOrderByNipDesc(
				pegawai.id_instansi, tahunmasuk, pegawai.tanggal_lahir);
//		System.out.println("models nii" + new Gson().toJson(pegawaiModels));
		if(!pegawaiModels.isEmpty()) {
			System.out.println("oke ada nih pegawainya");
			Integer lastindex = pegawaiModels.size();
			System.out.println("lastindex = "+ lastindex);
			String digitterakhir = pegawaiModels.get(lastindex-1).getNip();
			String inidia = digitterakhir.substring(14,16);
			Integer yes = Integer.parseInt(inidia);
			lastdigit = yes +1;
			if(lastdigit < 10) {
				buatditambah = "0" + lastdigit.toString();
			} else {
				buatditambah = lastdigit.toString();
			}
			System.out.println("buatditambah "+ buatditambah);
		} else {
			buatditambah = "01";
		}
		String nipbeneran = nipkurangduadigit + buatditambah;
		pegawai.setNip(nipbeneran);
		
	}
	
	

}
