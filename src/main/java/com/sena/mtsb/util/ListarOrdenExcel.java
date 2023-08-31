package com.sena.mtsb.util;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import com.sena.mtsb.model.Orden;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ListarOrdenExcel {
	private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    
    private List<Orden> listOrden;
    
    
    public ListarOrdenExcel(List<Orden> listOrden) {
		this.listOrden = listOrden;
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Orden");
	}
    
    private void writeHeaderRow() {
    	Row row = sheet.createRow(0);
    	
    	CellStyle style = workbook.createCellStyle();
    	HSSFFont font = workbook.createFont();
    	font.setBold(true);
    	font.setFontHeight((short) 16);
    	style.setFont(font);
    	
    	Cell cell = row.createCell(0);
    	cell.setCellValue("Orden ID");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(1);
    	cell.setCellValue("Quien solicito");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(2);
    	cell.setCellValue("Productos");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(3);
    	cell.setCellValue("Cantidad");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(4);
    	cell.setCellValue("Proveedor");
    	cell.setCellStyle(style);
    	
    	cell = row.createCell(6);
    	cell.setCellValue("Fecha y Hora");
    	cell.setCellStyle(style);
    }

	private void writeDataRow() {
    	int rowCount = 1;
    	
    	CellStyle style = workbook.createCellStyle();
    	HSSFFont font = workbook.createFont();
    	font.setFontHeight((short) 14);
    	style.setFont(font);
    	
    	for (Orden orden : listOrden) {
    		Row row = sheet.createRow(rowCount++);
    		
    		Cell cell = row.createCell(0);
    		cell.setCellValue(orden.getIdOrden());
    		sheet.autoSizeColumn(0);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(1);
    		cell.setCellValue(orden.getSolicitudOrden());
    		sheet.autoSizeColumn(1);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(2);
    		cell.setCellValue(orden.getProductoOrden());
    		sheet.autoSizeColumn(2);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(3);
    		cell.setCellValue(orden.getCantidadOrden());
    		sheet.autoSizeColumn(3);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(4);
    		cell.setCellValue(orden.getProveedorOrden());
    		sheet.autoSizeColumn(4);
    		cell.setCellStyle(style);
    		
    		cell = row.createCell(5);
    		cell.setCellValue(orden.getFechaOrden());
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
