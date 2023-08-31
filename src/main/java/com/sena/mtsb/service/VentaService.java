package com.sena.mtsb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.mtsb.interfaces.IntVentaService;
import com.sena.mtsb.interfaces.IntVenta;
import com.sena.mtsb.model.Venta;
import com.sena.mtsb.model.Producto;

@Service
public class VentaService implements IntVentaService {

    @Autowired
    private IntVenta data;

    @Autowired
    private ProductoService productoService;

    @Override
    public List<Venta> Listar() {
        List<Venta> ventas = (List<Venta>) data.findAll();

        for (Venta venta : ventas) {
            Optional<Producto> productoOptional = productoService.ListarId(venta.getItemVenta());

            if (productoOptional.isPresent()) {
                Producto producto = productoOptional.get();
                venta.setItemVenta(producto.getNombreProducto());
            }
        }

        return ventas;
    }

    @Override
    public Optional<Venta> ListarId(String id) {
        return data.findById(id);
    }

    @Override
    public int save(Venta p) {
        int res = 0;
        Venta venta = data.save(p);
        if (venta == null) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(String id) {
        data.deleteById(id);
    }
}
