package com.sena.mtsb.util;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import com.sena.mtsb.model.Venta;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ListarVentasExcel {
    private HSSFWorkbook workbook;
    private HSSFSheet sheet;

    private List<Venta> listVentas;


    public ListarVentasExcel(List<Venta> listVentas) {
		this.listVentas = listVentas;
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Ventas");
	}

    private void writeHeaderRow() {
    	Row row = sheet.createRow(0);

    	CellStyle style = workbook.createCellStyle();
    	HSSFFont font = workbook.createFont();
    	font.setBold(true);
    	font.setFontHeight((short) 16);
    	style.setFont(font);

    	Cell cell = row.createCell(0);
    	cell.setCellValue("Venta ID");
    	cell.setCellStyle(style);

    	cell = row.createCell(1);
    	cell.setCellValue("Cliente");
    	cell.setCellStyle(style);

    	cell = row.createCell(2);
    	cell.setCellValue("Productos");
    	cell.setCellStyle(style);

    	cell = row.createCell(3);
    	cell.setCellValue("Fecha y Hora");
    	cell.setCellStyle(style);

    	cell = row.createCell(4);
    	cell.setCellValue("Total a pagar");
    	cell.setCellStyle(style);
    }

	private void writeDataRow() {
    	int rowCount = 1;

    	CellStyle style = workbook.createCellStyle();
    	HSSFFont font = workbook.createFont();
    	font.setFontHeight((short) 14);
    	style.setFont(font);

    	for (Venta venta : listVentas) {
    		Row row = sheet.createRow(rowCount++);

    		Cell cell = row.createCell(0);
    		cell.setCellValue(venta.getIdVenta());
    		sheet.autoSizeColumn(0);
    		cell.setCellStyle(style);

    		cell = row.createCell(1);
    		cell.setCellValue(venta.getIdenClienteVenta());
    		sheet.autoSizeColumn(1);
    		cell.setCellStyle(style);

    		cell = row.createCell(2);
    		cell.setCellValue(venta.getItemVenta());
    		sheet.autoSizeColumn(2);
    		cell.setCellStyle(style);

    		cell = row.createCell(3);
    		cell.setCellValue(venta.getFechaVenta());
    		sheet.autoSizeColumn(3);
    		cell.setCellStyle(style);

    		cell = row.createCell(4);
    		cell.setCellValue(venta.getPrecioTotalVenta());
    		sheet.autoSizeColumn(4);
    		cell.setCellStyle(style);
    	}
    }

    public void export(HttpServletResponse response) throws IOException {
    	writeHeaderRow();
    	writeDataRow();

    	ServletOutputStream outputStream = response.getOutputStream();
    	workbook.write(outputStream);
    	workbook.close();
    	outputStream.close();
    }
}
