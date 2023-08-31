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

import com.sena.mtsb.interfaces.IntProductoService;
import com.sena.mtsb.model.Producto;
import com.sena.mtsb.util.ListarProductosExcel;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class ProductosController {
	
	@Autowired
	private IntProductoService service;

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/Productos")
	public String productos (Model model) {
		List<Producto>productos=service.Listar();
		model.addAttribute("productos", productos);
		return "productos";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/newProducto")
	public String agregar(Model model) {
		model.addAttribute("producto",new Producto());
		return "formAgPro";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@PostMapping("/saveProducto")
	public String save(@Validated Producto p, Model model) {
		p.setFechaCaducidad(LocalDateTime.now());
		service.save(p);
		return "redirect:/productos";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/editarProducto/{id}")
	public String editar(@PathVariable String id, Model model) {
		Optional<Producto>producto=service.ListarId(id);
		model.addAttribute("producto",producto);
		return "formAgPro";
	}
	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/eliminarProducto/{id}")
	public String delete(Model model, @PathVariable String id) {
		service.delete(id);
		return "redirect:/productos";
	}

	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
	@GetMapping("/exportarProductos")
	public void exportExcel (HttpServletResponse response) throws IOException {
		response.setContentType("aplication/octet-stream");
		String headerKey = "Content-Disposition";
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH : ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "productos_" + currentDateTime + ".xls";
		String headerValue = "attachement; filename=" + fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Producto> listProductos = service.Listar();
		
		ListarProductosExcel listarProductoExcel = new ListarProductosExcel(listProductos);
		listarProductoExcel.export(response);
	}
}
