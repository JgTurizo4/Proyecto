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

import com.sena.mtsb.interfaces.IntOrdenService;
import com.sena.mtsb.model.Orden;
import com.sena.mtsb.util.ListarOrdenExcel;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class OrdenController {

	@Autowired
	private IntOrdenService service;

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/orden")
	public String listar (Model model) {
		List<Orden>ordenes=service.Listar();
		model.addAttribute("ordenes", ordenes);
		return "orden";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/newOrden")
	public String agregar(Model model) {
		model.addAttribute("orden",new Orden());
		return "formOrden";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@PostMapping("/saveOrden")
	public String save(@Validated Orden p, Model model) {
		p.setFechaOrden(LocalDateTime.now());
		service.save(p);
		return "redirect:/orden";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/editarOrden/{id}")
	public String editar(@PathVariable String id, Model model) {
		Optional<Orden>orden=service.ListarId(id);
		model.addAttribute("orden",orden);
		return "formOrden";
	}

	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/eliminarOrden/{id}")
	public String delete(Model model, @PathVariable String id) {
		service.delete(id);
		return "redirect:/orden";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/exportarOrden")
	public void exportExcel (HttpServletResponse response) throws IOException {
		response.setContentType("aplication/octet-stream");
		String headerKey = "Content-Disposition";
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH : ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "Orden_" + currentDateTime + ".xls";
		String headerValue = "attachement; filename=" + fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Orden> listOrden = service.Listar();
		
		ListarOrdenExcel listarOrdenExcel = new ListarOrdenExcel(listOrden);
		listarOrdenExcel.export(response);
	}
}