package com.apap.tugas1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiCmd;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.JabatanService;

@Controller
public class JabatanController {
	
	@Autowired //bikin berapapun autowirednya sesuai kebutuhan fitur
	private JabatanService jabatanService;
	
	@RequestMapping(value="/jabatan/viewall", method=RequestMethod.GET)
	public String view(Model model) {
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
//		for ()
		model.addAttribute("allJabatan", jabatan);
		return "view-all-jabatan";
	}
	
	@RequestMapping(value="/jabatan/viewJabatan", method=RequestMethod.GET)
	public String viewJabatan(@RequestParam Long id, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id);
		model.addAttribute("jabatan", jabatan);
		return "view-jabatan";
	}
	
	@RequestMapping(value="/jabatan/tambah", method=RequestMethod.GET)
	private String addJabatan(Model model) {
		model.addAttribute("jabatan", new JabatanModel());
		return "addJabatan";

		}
	
	@PostMapping(value="/jabatan/tambah")
	private String addJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		jabatanService.addJabatan(jabatan);
		return "success-add";
	}
	
	@RequestMapping(value="/jabatan/hapus", method=RequestMethod.POST)
	public String delete(@ModelAttribute JabatanModel jabatan, Model model) {
		jabatanService.deleteJabatan(jabatan);
		return "view-all-jabatan";
	}
	
}
