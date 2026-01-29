package com.org.utilities;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getExcelData(String excelPath,String sheetName) {

        try {
                FileInputStream fis = new FileInputStream(excelPath);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet(sheetName);

                int rows = sheet.getPhysicalNumberOfRows();
                int cols = sheet.getRow(0).getPhysicalNumberOfCells();
//                  int rows = sheet.getLastRowNum();
//                  int cols = sheet.getRow(0).getLastCellNum();

                Object[][] data = new Object[rows-1][cols];

                for (int i = 1; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                    }
                }
                workbook.close();
                return data;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }