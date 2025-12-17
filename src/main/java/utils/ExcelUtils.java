package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getTestData(String path, String sheetName) {

        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new RuntimeException("Excel file not found: " + path);
            }

            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows][cols];

            for (int i = 1; i <= rows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    throw new RuntimeException("Empty row at index: " + i);
                }

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i - 1][j] = cell.toString().trim();
                }
            }

            workbook.close();
            fis.close();

            return data;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel data", e);
        }
    }
}
