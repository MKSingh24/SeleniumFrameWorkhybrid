package com.org.utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtilsAsMap {

    public static List<Map<String,String>> readExcelAsMap(String excelPath,String sheetName){

        List<Map<String,String>> dataList=new ArrayList<>();

        try{
            FileInputStream fis=new FileInputStream(excelPath);
            Workbook workbook=new XSSFWorkbook(fis);
            Sheet sheet=workbook.getSheet(sheetName);

//            Row headerRow = sheet.getRow(0);
            int total_rows = sheet.getLastRowNum();
            int total_cols = sheet.getRow(0).getLastCellNum();

            for(int i=1;i<=total_rows;i++){
                Row row=sheet.getRow(i);
                Map<String,String> rowMap=new HashMap<>();
                for(int j=0;j<total_cols;j++){
                    String key=sheet.getRow(0).getCell(j).toString();
                    String value=row.getCell(j).toString();
                    rowMap.put(key,value);
                }
                dataList.add(rowMap);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return dataList;
    }
}
