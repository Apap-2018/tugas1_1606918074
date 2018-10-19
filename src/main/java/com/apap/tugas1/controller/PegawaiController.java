package com.apap.tugas1.controller;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanPegawaiService;
import com.apap.tugas1.service.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.PegawaiService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	public String index() {
		return "index";
	}
	
	/*
	 * dari navbar tambah pegawai kesini
	 */
	@RequestMapping(value="/pegawai/tambah", method=RequestMethod.GET)
	private String addPegawai(Model model) {
		model.addAttribute("pegawai", new PegawaiModel());
		return "addPegawai";
		}

	@PostMapping(value="/pegawai/tambah")
	private String addPegawaiSubmit(@ModelAttribute PegawaiModel pegawai) {
		pegawaiService.generateNip(pegawai);
		pegawaiService.addPegawai(pegawai);
		return "add";
	}

}
