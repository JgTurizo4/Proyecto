package com.sena.mtsb.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

import com.sena.mtsb.interfaces.IntEntradaService;
import com.sena.mtsb.model.Entrada;
import com.sena.mtsb.util.ListarEntradasExcel;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class EntradaContoller {

	@Autowired
	private IntEntradaService service;

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/entrada")
	public String listar (Model model) {
		List<Entrada>entradas=service.Listar();
		model.addAttribute("entradas", entradas);
		return "entrada";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/newEntrada")
	public String agregar(Model model) {
		model.addAttribute("entrada",new Entrada());
		return "formEntrada";
	}
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@PostMapping("/saveEntrada")
	public String save(@Validated Entrada p, Model model) {
		p.setFechaEntrada(LocalDateTime.now());
		service.save(p);
		return "redirect:/entrada";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/editarEntrada/{id}")
	public String editar(@PathVariable String id, Model model) {
		Optional<Entrada>entrada=service.ListarId(id);
		model.addAttribute("entrada",entrada);
		return "formEntrada";
	}

	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/eliminarEntrada/{id}")
	public String delete(Model model, @PathVariable String id) {
		service.delete(id);
		return "redirect:/entrada";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/exportarEntrada")
	public void exportExcel (HttpServletResponse response) throws IOException {
		response.setContentType("aplication/octet-stream");
		String headerKey = "Content-Disposition";
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH : ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "entradas_" + currentDateTime + ".xls";
		String headerValue = "attachement; filename=" + fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Entrada> listEntrada = service.Listar();
		
		ListarEntradasExcel listarEntradaExcel = new ListarEntradasExcel(listEntrada);
		listarEntradaExcel.export(response);
	}
}