/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author- Brijesh Mishra CSVDataProvider-This class contains the csv data provider method with file path name * Date-24/11/2022
 **/
package com.appium.dataproviders;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.appium.exceptions.AutomationException;
import com.appium.exceptions.DataProviderInputFileNotFound;
import com.appium.utils.FileLoader;

public class CSVDataProvider {
    private static String delimiter = ",";

    private CSVDataProvider() {

    }

    /**
     * getData- his gets the test data from a csv file. It returns all the data as a 2d array
     *
     * @param filePath-String
     * @return Object[][]
     * @Date- 24/11/2022
     */
    public static Object[][] getData(String filePath) {
        String line = "";
        String[][] dataArray = null;
        List<String> csvRowList = new ArrayList<>();
        String[] rowSplit;
        int columnCount = 0;
        int rowCount = 0;

        // Get the file location from the project main/resources folder
        if (!(filePath.contains(":") || filePath.startsWith("/"))) {
            URL file = CSVDataProvider.class.getResource(filePath);
            if (file == null) {
                throw new DataProviderInputFileNotFound("No file was found on path [ " + filePath + " ]");
            }
            filePath = file.getPath();
        }

        // in case file path has a %20 for a whitespace, replace with actual
        // whitespace
        filePath = filePath.replace("%20", " ");
        // open the CSV and add each line into a list
        try (BufferedReader bufferedReader = FileLoader.openTextFileFromProject(filePath)) {
            while ((line = bufferedReader.readLine()) != null) {
                csvRowList.add(line);
            }
        } catch (IOException e) {
            throw new AutomationException("Failed to read in CSV file", e);
        }

        // Remove first line of headers
        csvRowList.remove(0);
        columnCount = csvRowList.get(0).split(delimiter).length;
        rowCount = csvRowList.size();
        dataArray = new String[rowCount][columnCount];

        // transform the list into 2d array
        // start at row 1 since, first row 0 is column headings
        for (int rowNum = 0; rowNum <= rowCount - 1; rowNum++) {

            // take the row which is a string, and split it
            rowSplit = csvRowList.get(rowNum).split(delimiter);

            for (int colNum = 0; colNum < columnCount; colNum++) {
                try {
                    dataArray[rowNum][colNum] = rowSplit[colNum];
                } catch (ArrayIndexOutOfBoundsException e) {
                    dataArray[rowNum][colNum] = "";
                }
            }
        }
        return dataArray;
    }

    /**
     * getData- This is a overloaded method with filepath and delimiter value
     *
     * @param filePath-String
     * @param delimiterValue-String
     * @return-Object[][] Date-24/11/2022
     */
    public static Object[][] getData(String filePath, String delimiterValue) {
        delimiter = delimiterValue;
        return getData(filePath);
    }

}
