package com.sena.mtsb.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.mtsb.interfaces.IntProdReproService;
import com.sena.mtsb.model.ProdRepro;
import com.sena.mtsb.util.ListarProdReproExcel;


import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class ProdReproController {

	@Autowired
	private IntProdReproService service;

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/prodRepro")
	public String ProdRepro (Model model) {
		List<ProdRepro>prodRepros=service.Listar();
		model.addAttribute("prodRepros", prodRepros);
		return "producRepro";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/newProdRepro")
	public String agregar(Model model) {
		model.addAttribute("prodRepro",new ProdRepro());
		return "formAgPro";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@PostMapping("/saveProdRepro")
	public String save(@Validated ProdRepro p, Model model) {
		service.save(p);
		return "redirect:/prodRepro";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/editarProdRepro/{id}")
	public String editar(@PathVariable String id, Model model) {
		Optional<ProdRepro>prodRepro=service.ListarId(id);
		model.addAttribute("prodRepro",prodRepro);
		return "formAgPro";
	}

	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/eliminarProdRepro/{id}")
	public String delete(Model model, @PathVariable String id) {
		service.delete(id);
		return "redirect:/prodRepro";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/exportarProdRepro")
	public void exportExcel (HttpServletResponse response) throws IOException {
		response.setContentType("aplication/octet-stream");
		String headerKey = "Content-Disposition";
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH : ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "prodRepro" + currentDateTime + ".xls";
		String headerValue = "attachement; filename=" + fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<ProdRepro> listProdRepro = service.Listar();
		
		ListarProdReproExcel ListarProdReproExcel = new ListarProdReproExcel(listProdRepro);
		ListarProdReproExcel.export(response);
	}
}

