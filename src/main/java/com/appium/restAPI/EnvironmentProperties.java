package com.appium.restAPI;

import com.appium.exceptions.AutomationException;
import com.appium.utils.TestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("serial")
public class EnvironmentProperties extends Properties {

    private static final String FILE_NAME = "src/test/resources/Prod_ApiEnvironment.properties";

    public static String get(String prop) throws IOException {
        String a;
        String b = "";
        FileInputStream fis = null;
        try {
            Properties prop1 = new Properties();
            fis = new FileInputStream(FILE_NAME);
            prop1.load(fis);
            a = prop1.getProperty(prop);
            b = a;
            if (a.contains("${")) {
                b = a.replace(a.substring(a.indexOf("${"), a.indexOf("}") + 1), prop1.getProperty(a.substring(a.indexOf("${") + 2, a.indexOf("}"))));
            }
            while (b.contains("${")) {
                b = b.replace(b.substring(b.indexOf("${"), b.indexOf("}") + 1), prop1.getProperty(b.substring(b.indexOf("${") + 2, b.indexOf("}"))));
            }
        } catch (NullPointerException | FileNotFoundException e) {
            TestUtils.log().debug("Exception occurred while getting the value... {}",e.getMessage());
            throw new AutomationException("Exception occurred while getting the value...{}"+e.getMessage());
        } finally {
            assert fis != null;
            fis.close();
        }
        return b;
    }

    public static void storeProp(String key, String value) throws IOException {
        Properties props = new Properties();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        if (value != null) {
            try {
                fis = new FileInputStream(FILE_NAME);
                props.load(fis);
            } catch (Exception e) {
                TestUtils.log().debug("Exception Occurred during file reading...{}",e.getMessage());
            } finally {
                assert fis != null;
                fis.close();
            }
            try {
                fos = new FileOutputStream(FILE_NAME);
                props.setProperty(key, value);
                props.store(fos, null);
            } catch (Exception e) {
                TestUtils.log().debug("Exception Occurred during file closing... {}", e.getMessage());
            } finally {
                try {
                    if(fos != null)
                        fos.close();
                 }catch(IOException e){ TestUtils.log().debug("Exception Occurred during file closing... {}", e.getMessage());}
            }
        }
    }
}