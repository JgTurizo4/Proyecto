package com.sena.mtsb.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import com.sena.mtsb.model.Producto;
import com.sena.mtsb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.mtsb.interfaces.IntVentaService;
import com.sena.mtsb.model.Venta;
import com.sena.mtsb.util.ListarVentasExcel;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class VentaController {

    @Autowired
    private IntVentaService service;

    @Autowired
    private ProductoService productoService;


    @GetMapping("/consultarVentas")
    public String consultarVentas(Model model) {
        List<Venta> ventas = service.Listar();
        model.addAttribute("ventas", ventas);
        return "consultarVentas";
    }

    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("venta", new Venta());

        List<Producto> productos = productoService.Listar();
        model.addAttribute("productos", productos);

        return "venta";
    }

    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
    @PostMapping("/save")
    public String save(@Validated Venta p, Model model) {
        // Establecer la fecha y hora actual
        p.setFechaVenta(LocalDateTime.now());

        service.save(p);
        return "redirect:/consultarVentas";
    }

    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Empleado')")
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        Optional<Venta> venta = service.ListarId(id);
        venta.ifPresent(v -> model.addAttribute("venta", v));
        return "venta";
    }

    @PreAuthorize("hasRole('ROLE_Admin')")
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable String id) {
        service.delete(id);
        return "redirect:/consultarVentas";
    }

    @PreAuthorize("hasAnyRole('Admin', 'Empleado')")
    @GetMapping("/exportar")
    public void exportExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String fileName = "ventas_" + currentDateTime + ".xls";
        String headerValue = "attachment; filename=" + fileName;

        response.setHeader(headerKey, headerValue);

        List<Venta> listVentas = service.Listar();

        ListarVentasExcel listarVentaExcel = new ListarVentasExcel(listVentas);
        listarVentaExcel.export(response);
    }
}