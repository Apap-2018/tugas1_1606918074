package com.apap.tugas1.controller;

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

@Controller
public class PegawaiController {
	@Autowired
	private PegawaiService pegawaiService;
	
	/*
	 * home.html
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String view(@RequestParam("nip") String nip, Model model) {
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNip(nip);

		model.addAttribute("pegawai", pegawai);
		return "view-pegawai";
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
