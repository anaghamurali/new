package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream("/Users/jay/Downloads/HRA_Monthly_Declaration_Form_FY24-25 (1).xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int no = workbook.getNumberOfSheets();

        List<Map<String, String>> excelData = new ArrayList<>();
        ArrayList<String> columnHeaders = new ArrayList<>();


        for(int i=0;i<no;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")){
                XSSFSheet sheet =workbook.getSheetAt(i);


            Iterator<Row> rows = sheet.iterator();
            if( rows.hasNext()){

            Row firstRow = rows.next();
            

            Iterator<Cell> cell = firstRow.cellIterator();


            while(cell.hasNext()){
                Cell value = cell.next();
                columnHeaders.add(value.getStringCellValue());
                }}

        while(rows.hasNext())
        {
            Row row = rows.next();
            Map<String, String> map = new HashMap<>();



         for(int j=0;j<columnHeaders.size();j++){

                Cell cell1 = row.getCell(j);


                String val ="";

                if (cell1 != null) {
                    switch (cell1.getCellType()) {
                        case STRING:
                        val = cell1.getStringCellValue();
                            break;
                        case NUMERIC:
                        val = String.valueOf(cell1.getNumericCellValue());
                            break;
                        case BOOLEAN:
                        val = String.valueOf(cell1.getBooleanCellValue());
                            break;
                        default:
                        val = "";
                    }
                }


            


                map.put(columnHeaders.get(j),val);


         }excelData.add(map);}

        }

    }   
   workbook.close();
        fis.close();

        // Print the collected data
        for (Map<String, String> row : excelData) {
            System.out.println(row);
        }
                }
            
            }
