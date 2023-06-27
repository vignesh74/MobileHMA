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
 * FileLoader-This class is used to load the file from given path
 * Date-28/11/2022
 */
package com.appium.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.appium.exceptions.InvalidFileException;

public class FileLoader {

    /**
     * loadFileFromProjectAsString- This method is used to load the file from project as a string
     * @param filePath- String
     * @return- String
     * @throws IOException
     * Date-28/11/2022
     */
    public static String loadFileFromProjectAsString(String filePath) throws IOException {

        BufferedReader resource;
        resource = openTextFileFromProject(filePath);
        String text;
        try {
            text = IOUtils.toString(resource);
        } finally {
            resource.close();
        }
        return text;
    }
    /**
     * openTextFileFromProject- This method is used to open text file from the project
     * @param filePath-String
     * @return -BufferedReader
     * @throws IOException
     * Date- 28/11/2022
     */
    public static BufferedReader openTextFileFromProject(String filePath) throws IOException {
        BufferedReader bufferedReader;
        String strDelimiter="/";
        filePath = filePath.replace("%20", " ");
        if (!filePath.startsWith("/")) {
            filePath = strDelimiter+ filePath;
        }
        if (!isReadableFile(filePath)) {
            throw new InvalidFileException("File path of [ " + filePath + " ] was invalid or file was unreadable");
        }

        FileReader fileReader = new FileReader(getAbosutePathForResource(filePath));
         bufferedReader = new BufferedReader(fileReader);
         return bufferedReader;
    }

    /**
     * isReadableFile-This method is checked for the file is readable or not
     * @param filePath- String
     * @return-boolean
     * Date- 28/11/2022
     */
    public static boolean isReadableFile(String filePath) {

        boolean readable = false;
        File file = new File(filePath);
        if (!file.isDirectory() && file.exists() && file.canRead()) {
            readable = true;
        } else if (null != FileLoader.class.getResource(filePath)) {
           TestUtils.log().info("File path is not null");
        }
        return readable;
    }

    /**
     * getAbosutePathForResource- This method is used to get absolute path
     * @param filePath- String
     * @return- String
     * Date-28/11/2022
     */
    public static String getAbosutePathForResource(String filePath)
    {
        URL file = FileLoader.class.getResource(filePath);
        if (null == file) {
            return filePath;
        }
        return file.getPath();
    }
    /**
     * readFile- This method is used to read file data
     * @param file- File
     * @return- String
     * @throws IOException
     * Date- 28/11/2022
     */
    public static String readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
