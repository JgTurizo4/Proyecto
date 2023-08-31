package com.sena.mtsb.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.mtsb.interfaces.IntProduccionService;
import com.sena.mtsb.model.Produccion;
import com.sena.mtsb.util.ListarProduccionExcel;


import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class ProduccionController {

	@Autowired
	private IntProduccionService service;

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/produccion")
	public String produccion (Model model) {
		List<Produccion>producciones=service.Listar();
		model.addAttribute("producciones", producciones);
		return "produccion";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/newProduccion")
	public String agregar(Model model) {
		model.addAttribute("produccion",new Produccion());
		return "formProduccion";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@PostMapping("/saveProduccion")
	public String save(@Validated Produccion p, Model model) {
		service.save(p);
		return "redirect:/produccion";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/editarProduccion/{id}")
	public String editar(@PathVariable String id, Model model) {
		Optional<Produccion>produccion=service.ListarId(id);
		model.addAttribute("produccion",produccion);
		return "formProduccion";
	}

	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/eliminarProduccion/{id}")
	public String delete(Model model, @PathVariable String id) {
		service.delete(id);
		return "redirect:/produccion";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/exportarProduccion")
	public void exportExcel (HttpServletResponse response) throws IOException {
		response.setContentType("aplication/octet-stream");
		String headerKey = "Content-Disposition";
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH : ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "produccion_" + currentDateTime + ".xls";
		String headerValue = "attachement; filename=" + fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Produccion> listProduccion = service.Listar();
		
		ListarProduccionExcel listarProduccionExcel = new ListarProduccionExcel(listProduccion);
		listarProduccionExcel.export(response);
	}
}
