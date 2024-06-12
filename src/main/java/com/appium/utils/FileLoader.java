/**
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
