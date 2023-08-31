package com.sena.mtsb.util;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import com.sena.mtsb.model.Produccion;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ListarProduccionExcel {
	 private HSSFWorkbook workbook;
	    private HSSFSheet sheet;
	    
	    private List<Produccion> listProduccion;
	    
	    
	    public ListarProduccionExcel(List<Produccion> listProduccion) {
			this.listProduccion = listProduccion;
			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("Produccion");
		}
	    
	    private void writeHeaderRow() {
	    	Row row = sheet.createRow(0);
	    	
	    	CellStyle style = workbook.createCellStyle();
	    	HSSFFont font = workbook.createFont();
	    	font.setBold(true);
	    	font.setFontHeight((short) 16);
	    	style.setFont(font);
	    	
	    	Cell cell = row.createCell(0);
	    	cell.setCellValue("Produccion ID");
	    	cell.setCellStyle(style);
	    	
	    	cell = row.createCell(1);
	    	cell.setCellValue("Producto");
	    	cell.setCellStyle(style);
	    	
	    	cell = row.createCell(2);
	    	cell.setCellValue("Cantidad");
	    	cell.setCellStyle(style);
	    	
	    	cell = row.createCell(3);
	    	cell.setCellValue("Fecha y hora de realizacion");
	    	cell.setCellStyle(style);
	    	
	    	cell = row.createCell(4);
	    	cell.setCellValue("Estado");
	    	cell.setCellStyle(style);
	    }

		private void writeDataRow() {
	    	int rowCount = 1;
	    	
	    	CellStyle style = workbook.createCellStyle();
	    	HSSFFont font = workbook.createFont();
	    	font.setFontHeight((short) 14);
	    	style.setFont(font);
	    	
	    	for (Produccion produccion : listProduccion) {
	    		Row row = sheet.createRow(rowCount++);
	    		
	    		Cell cell = row.createCell(0);
	    		cell.setCellValue(produccion.getIdProduccion());
	    		sheet.autoSizeColumn(0);
	    		cell.setCellStyle(style);
	    		
	    		cell = row.createCell(1);
	    		cell.setCellValue(produccion.getTipoProduccion());
	    		sheet.autoSizeColumn(1);
	    		cell.setCellStyle(style);
	    		
	    		cell = row.createCell(2);
	    		cell.setCellValue(produccion.getFechaProduccion());
	    		sheet.autoSizeColumn(2);
	    		cell.setCellStyle(style);
	    		
	    		cell = row.createCell(3);
	    		cell.setCellValue(produccion.getEstadoProduccion());
	    		sheet.autoSizeColumn(3);
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

