package com.apap.tugas1.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiCmd;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanPegawaiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;
import com.google.gson.Gson;

@Controller
public class PegawaiController {
	@Autowired
	PegawaiService pegawaiService;

	@Autowired
	InstansiService instansiService;

	@Autowired
	ProvinsiService provinsiService;

	@Autowired
	JabatanPegawaiService jabatanPegawaiService;
	
	@Autowired
	JabatanService jabatanService;
	/*
	 * home.html
	 */
	@RequestMapping(value="/pegawai", method=RequestMethod.GET)
	public String view(@RequestParam("nip") String nip, Model model) {
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNip(nip);
		Long instansiId = pegawai.id_instansi;
		InstansiModel instansi = instansiService.getInstansiDetailByIdInstansi(Long.valueOf(instansiId));
		Integer provinsiId = instansi.id_provinsi;
		ProvinsiModel provinsi = provinsiService.getProvinsiByIdProvinsi(provinsiId);
		pegawai.setJabatanfull(instansi.nama + " - " + provinsi.nama);
		List<JabatanPegawaiModel> jabatanPegawaiModels = jabatanPegawaiService.getJabatanPegawaiListByIdPegawai(pegawai.getId());
		List<Double> gaji = new ArrayList<Double>();
		for(JabatanPegawaiModel jabatanPegawaiModel : jabatanPegawaiModels) {
			Double percentage = 0.01*provinsi.getPresentase_tunjangan();
			System.out.println("PERSENNN "+ percentage);
			Double tambahan = percentage*jabatanPegawaiModel.getGaji_pokok();
			System.out.println("TAMBAHHH "+ tambahan);
			Double gajitotal = jabatanPegawaiModel.getGaji_pokok() + tambahan;
			gaji.add(gajitotal);
			System.out.println("TOTALLL  "+ gajitotal);
		}
		Collections.sort(gaji);
		Long gajifinal = gaji.get(0).longValue();
		System.out.println("FINALL "+ gajifinal);
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("instansi", instansi);
		model.addAttribute("jabatanPegawaiModels", jabatanPegawaiModels);
		model.addAttribute("gaji", gajifinal);
		return "view-pegawai";
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
		Long idJabatan = (long) 0;
		model.addAttribute("allJabatan", jabatan);
		model.addAttribute("id_jabatan", idJabatan);
		return "index";
	}
	
	@RequestMapping(value="/pegawai/tambah", method=RequestMethod.GET)
	private String addPegawai(Model model) {
		List<ProvinsiModel> provinsiModelList = provinsiService.getAllProvinsi();
		List<JabatanModel> jabatanModelList = jabatanService.getAllJabatan();
		PegawaiCmd pegawaiCmd = new PegawaiCmd();

		model.addAttribute("provinsiList", provinsiModelList);
		model.addAttribute("jabatanList", jabatanModelList);
		model.addAttribute("pegawaiCmd", pegawaiCmd);
		return "addPegawai";

		}

	@RequestMapping(value="/getInstansis", method=RequestMethod.GET)
	private @ResponseBody List<InstansiModel> getAllInstansi(@RequestParam(value="provinsiId", required = true) Integer provinsiId){
		List<InstansiModel> instansiModelList = instansiService.getAllInstansi(provinsiId);
		return instansiModelList;
	}

	@PostMapping(value="/pegawai/tambah")
	private String addPegawaiSubmit(@ModelAttribute PegawaiCmd pegawai, Model model) {
		PegawaiModel pegawaiModel = new PegawaiModel();
		pegawaiModel.setNama(pegawai.getNama());
		pegawaiModel.setTahun_masuk(pegawai.getTahun_masuk());
		pegawaiModel.setTanggal_lahir(pegawai.getTanggal_lahir());
		pegawaiModel.setTempat_lahir(pegawai.getTempat_lahir());
//		System.out.println("pegawaiCMd "+ new Gson().toJson(pegawai));
		InstansiModel instansiModel = instansiService.getInstansibyNamaAndIdProvinsi(pegawai.getInstansi(), pegawai.getId_provinsi());
//		System.out.println("pegawaiCMd "+ new Gson().toJson(instansiModel));
		pegawaiModel.setId_instansi(instansiModel.getId());
 		System.out.println("masuuuk nih controller");

		pegawaiService.generateNip(pegawaiModel);
		String nippegawaibaru = pegawaiModel.getNip();
		pegawaiService.addPegawai(pegawaiModel);

		PegawaiModel pegawaibaru = pegawaiService.getPegawaiDetailByNip(nippegawaibaru);
		Integer idjabatan = pegawai.getId_jabatan();
		JabatanPegawaiModel jabatanPegawaiBaru = new JabatanPegawaiModel();
		jabatanPegawaiBaru.setId_jabatan(Long.valueOf(idjabatan));
		jabatanPegawaiBaru.setId_pegawai(pegawaibaru.getId());

		jabatanPegawaiService.addJabatanPegawai(jabatanPegawaiBaru);
		model.addAttribute("nipbaru", nippegawaibaru);
		return "success-add";
	}
	
	@RequestMapping(value="/pegawai/ubah", method=RequestMethod.GET)
	public String update(@RequestParam("nip") String nip, Model model) {
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNip(nip);
		
		if(pegawai != null) {
			model.addAttribute("pegawai", pegawai);
			return "update-pegawai";
		} else {
			return "not-found";
		}
	}
	
	@RequestMapping(value="/pegawai/ubah", method=RequestMethod.POST)
	private String updatePegawaiSubmit(@ModelAttribute PegawaiModel pegawai) {
		pegawaiService.addPegawai(pegawai);
		return "update";
	}
}
