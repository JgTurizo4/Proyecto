package com.sena.mtsb.util;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import com.sena.mtsb.model.Entrada;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ListarEntradasExcel {
	private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    
    private List<Entrada> listEntradas;
    
    
    public ListarEntradasExcel(List<Entrada> listEntradas) {
		this.listEntradas = listEntradas;
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Entradas");
	}
    
    private void writeHeaderRow() {
    	Row row = sheet.createRow(0);
    	
    	CellStyle style = workbook.createCellStyle();
    	HSSFFont font = workbook.createFont();
    	font.setBold(true);
    	font.setFontHeight((short) 16);
    	style.setFont(font);
    	
    	Cell cell = row.createCell(0);
    	cell.setCellValue("Entrada ID");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(1);
    	cell.setCellValue("Quien recibe");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(2);
    	cell.setCellValue("Cedula Proveedor");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(3);
    	cell.setCellValue("Productos");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(4);
    	cell.setCellValue("Cantidad");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(5);
    	cell.setCellValue("Fecha y hora");
    	cell.setCellStyle(style);
    }

	private void writeDataRow() {
    	int rowCount = 1;
    	
    	CellStyle style = workbook.createCellStyle();
    	HSSFFont font = workbook.createFont();
    	font.setFontHeight((short) 14);
    	style.setFont(font);
    	
    	for (Entrada entrada : listEntradas) {
    		Row row = sheet.createRow(rowCount++);
    		
    		Cell cell = row.createCell(0);
    		cell.setCellValue(entrada.getIdEntrada());
    		sheet.autoSizeColumn(0);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(1);
    		cell.setCellValue(entrada.getRecibeEntrada());
    		sheet.autoSizeColumn(1);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(2);
    		cell.setCellValue(entrada.getCedulaProvEntrada());
    		sheet.autoSizeColumn(2);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(3);
    		cell.setCellValue(entrada.getNombreItemEntrada());
    		sheet.autoSizeColumn(3);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(4);
    		cell.setCellValue(entrada.getCantidadEntrada());
    		sheet.autoSizeColumn(4);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(5);
    		cell.setCellValue(entrada.getFechaEntrada());
    		sheet.autoSizeColumn(5);
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
