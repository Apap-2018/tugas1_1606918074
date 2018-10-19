package com.apap.tugas1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.service.JabatanService;

@Controller
public class JabatanController {
	
	@Autowired //bikin berapapun autowirednya sesuai kebutuhan fitur
	private JabatanService jabatanService;
	
	@RequestMapping(value="/jabatan/viewall", method=RequestMethod.GET)
	public String view(Model model) {
		List<JabatanModel> jabatan = jabatanService.getJabatan();
		
		model.addAttribute("allJabatan", jabatan);
		return "view-all-jabatan";
	}
}
