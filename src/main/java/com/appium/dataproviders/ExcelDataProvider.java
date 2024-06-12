/**
 * ExcelDataProvider-This class contains the excel data provider method with file path and sheetname
 * Date-24/11/2022
 */
package com.appium.dataproviders;

import java.net.URL;

import com.appium.exceptions.DataProviderInputFileNotFound;
import com.appium.utils.ExcelDocumentReader;

public class ExcelDataProvider {

    private String filePath;
    private String sheetName;
    private int row;

    /**
     * ExcelDataProvider-This constructor is used to get file path and sheet name of the current excel
     * @param filePath-String
     * @param sheetName-String
     * Date-24/11/2022
     */
    public ExcelDataProvider(String filePath, String sheetName) {
        this(filePath, sheetName, -1);
    }

    /**
     * ExcelDataProvider-This constructor is used to get file path ,sheet name and row number of the current excel
     * @param filePath-String
     * @param sheetName-String
     * @param rowToRead-int
     * Date-24/11/2022
     */
    public ExcelDataProvider(String filePath, String sheetName, int rowToRead) {
        URL file = getClass().getResource(filePath);
        if (file == null) {
            throw new DataProviderInputFileNotFound("Failed to find a file in path [ " + filePath + " ]");
        }

        this.filePath = file.getPath();
        this.sheetName = sheetName;
        this.row = rowToRead;
    }

    /**
     * getData- This method gets the test data from a excel file. It returns all the data as a 2d array
     * @return Object[][]
     * @Date- 24/11/2022
     */
    public Object[][] getTestData() {
        return new ExcelDocumentReader(this.filePath).readData(this.sheetName, this.row);
    }

}
