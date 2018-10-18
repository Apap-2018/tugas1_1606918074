package com.apap.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.apap.tugas1.service.JabatanService;

@Controller
public class JabatanController {
	
	@Autowired //bikin berapapun autowirednya sesuai kebutuhan fitur
	private JabatanService jabatansService;
	
	
}
