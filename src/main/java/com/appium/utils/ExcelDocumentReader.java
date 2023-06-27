/**
 # MIT License
 #
 # Organization   eInfochips
 # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED.
 #
 # Permission is hereby granted, free of charge, to any person obtaining a copy
 # of this software and associated documentation files (the "Software"), to deal
 # in the Software without restriction, including without limitation the rights
 # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 # copies of the Software, and to permit persons to whom the Software is
 # furnished to do so, subject to the following conditions:
 #
 # The above copyright notice and this permission notice shall be included in all
 # copies or substantial portions of the Software.
 #
 # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 # LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 # SOFTWARE.
 #
 #              EINFOCHIPS
 #             2025 Gateway Place, Suite #238,
 #              San Jose, CA 95110
 #------------------------------------------------------------------------------------
 * @author- Brijesh Mishra
 * ExcelDocumentReader-This class is used to read the data from excel sheet
 * Date-28/11/2022
 */
package com.appium.utils;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.appium.exceptions.AutomationException;
public class ExcelDocumentReader {
    Sheet excelWSheet;
    Workbook excelWBook;
    Cell cell;
    private String filepath;
    private int startRow = 1;

    /**
     * ExcelDocumentReader- This is constructor used to add file path of current excel
     * @param filepath- String
     * Date-28/11/2022
     */
    public ExcelDocumentReader(String filepath) {
        this.filepath = filepath;
    }

    /**
     * ExcelDocumentReader- default constructor
     * Date-28/11/2022
     */
    public ExcelDocumentReader() {
    }

    /**
     * readData- This method is used to read data by using sheet name
     * @param sheetName- String
     * @return- Object[][]
     * Date- 28/11/2022
     */
    public Object[][] readData(String sheetName) {
        return (readData(sheetName, -1));
    }

    /**
     * readData- This method is used to read data by using file path and sheet name
     * @param filepath- String
     * @param sheetName-String
     * @return- Object[][]
     * Date-28/11/2022
     */
    public Object[][] readData(String filepath, String sheetName) {
        return (readData(filepath, sheetName, -1));
    }

    /**
     * readData- This method is used to read data by using sheet name and row number and starting index
     * @param sheetName- String
     * @param rowToRead- int
     * @param startRow- int
     * @return- Object[][]
     * Date-28/11/2022
     */
    public Object[][] readData(String sheetName, int rowToRead, int startRow) {
        this.startRow = startRow;
        return readData(filepath, sheetName, rowToRead);
    }

    /**
     * readData- This method is used to read data by using sheet name and row number
     * @param sheetName- String
     * @param rowToRead- int
     * @return- Object [][]
     * Date-28/11/2022
     */
    public Object[][] readData(String sheetName, int rowToRead) {
        return readData(filepath, sheetName, rowToRead);
    }

    /**
     * readData- This method is used to read data from the XLSX
     * @param filepath- String
     * @param sheetName- String
     * @param rowToRead- int
     * @return Object[][]
     * Date-28/11/2022
     */
    public Object[][] readData(String filepath, String sheetName, int rowToRead) {

        String[][] tabArray = null;
        int totalRows = 1;

        try {

            // Access the required test data sheet
            if (filepath.toUpperCase().indexOf(".XLSX") >= 0) {
                excelWBook = new XSSFWorkbook(FileLoader.getAbosutePathForResource(filepath)); // XLSX
            } else {
                FileInputStream excelFile = new FileInputStream(FileLoader.getAbosutePathForResource(filepath));
                excelWBook = new HSSFWorkbook(excelFile); // XLS
            }

            if (StringUtils.isNumeric(sheetName)) {
                excelWSheet = excelWBook.getSheetAt(Integer.valueOf(sheetName));
            } else {
                excelWSheet = excelWBook.getSheet(sheetName);
            }

            int startCol = 0;
            int offsetRows = 0;
            int ci;
            int cj;

            if (startRow > 1) {
                totalRows = excelWSheet.getLastRowNum();
                offsetRows = totalRows - startRow;
            } else if (rowToRead == -1 && startRow == 0) {
                totalRows = excelWSheet.getLastRowNum() + 1;
            } else if (rowToRead == -1) {
                totalRows = excelWSheet.getLastRowNum();
            } else {
                startRow = rowToRead;
                totalRows = startRow;
            }

            // you can write a function as well to get Column count

            int totalCols = excelWSheet.getRow(startRow).getLastCellNum();

            tabArray = new String[totalRows - offsetRows][totalCols];
            if (offsetRows != 0) {
                offsetRows--;
            } else if (startRow == 0) {
                offsetRows = 1;
            }
            ci = 0;
            for (int i = startRow; i <= totalRows - offsetRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);
                }
            }

        } catch (FileNotFoundException e) {
            throw new AutomationException("Failed to locate Excel file");
        } catch (IOException e) {
            throw new AutomationException("Could not read Excel file");
        }
        return (tabArray);
    }

    /**
     * getCellData-This method is used to get cell data from specific row as per its types
     * @param rowNum- int
     * @param colNum- int
     * @return- String
     * Date-28/11/2022
     */
    private String getCellData(int rowNum, int colNum) {
        cell = excelWSheet.getRow(rowNum).getCell(colNum);
        if (cell == null) {
            return "";
        }
        String cellData = "";
        switch (cell.getCellType()) {
            case CELL_TYPE_NUMERIC:
                DataFormatter formatter = new DataFormatter();
                cellData = formatter.formatCellValue(cell);
                break;

            case CELL_TYPE_STRING:
                cellData = cell.getStringCellValue();
                break;

            case CELL_TYPE_FORMULA:
                cellData = String.valueOf(cell.getCellFormula());
                break;

            case CELL_TYPE_BOOLEAN:
                cellData = String.valueOf(cell.getBooleanCellValue());
                break;

            default:
                break;
        }

        return cellData;
    }
}
