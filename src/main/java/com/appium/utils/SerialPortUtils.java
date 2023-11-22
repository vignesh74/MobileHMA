package com.appium.utils;

import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.deviceinfo_action.AndroidDeviceAction;
import com.appium.exceptions.AutomationException;
import com.appium.manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import jssc.SerialPort;
import jssc.SerialPortException;

import static com.appium.constants.FrameworkConstants.DESCRIPTIVEPORTNAME;

public class SerialPortUtils {

    static BasePage basePage = new BasePage();
    AndroidDeviceAction androidDeviceAction = new AndroidDeviceAction();


    public static String getDeviceCOMPort() {
        String deviceCOMPort = "";
        String deviceCOMPort1 = "";
        com.fazecast.jSerialComm.SerialPort[] spArray;
        spArray = com.fazecast.jSerialComm.SerialPort.getCommPorts();
        String osName = System.getProperty("os.name").toLowerCase();
        try {
            for (com.fazecast.jSerialComm.SerialPort sp : spArray) {
                TestUtils.log().info("{} {} {} {}",sp.getSystemPortName(),sp.getDescriptivePortName(),sp.getPortLocation(),sp.getPortDescription());

                if (osName.contains("windows") && DriverManager.getComPort().isEmpty()) {
                    if (sp.getDescriptivePortName().contains(DESCRIPTIVEPORTNAME)) {
                        deviceCOMPort1 = sp.getSystemPortName();
                        TestUtils.log().info("Device Com port in Serial Util: {}", deviceCOMPort1);
                        TestUtils.log().info(MessageConstants.TWO_BRACKETS, MessageConstants.YOUR_DEVICE_CONNECTED_MESSAGE, deviceCOMPort1);
                    }
                }
                if (osName.contains("mac") && DriverManager.getComPort().isEmpty()) {
                    TestUtils.log().info(sp.getDescriptivePortName());
                    if (sp.getDescriptivePortName().contains(DESCRIPTIVEPORTNAME)) {
                        deviceCOMPort1 = sp.getSystemPortName();
                        deviceCOMPort = "/dev/" + deviceCOMPort1;
                        if (deviceCOMPort.contains("tty"))
                            TestUtils.log().info(MessageConstants.TWO_BRACKETS,MessageConstants.YOUR_DEVICE_CONNECTED_MESSAGE,deviceCOMPort);
                    }
                }
                else {
                    deviceCOMPort = DriverManager.getComPort();
                }
                if (osName.contains("MAC") && DriverManager.getComPort().isEmpty()) {
                    if (sp.getDescriptivePortName().contains(DESCRIPTIVEPORTNAME)) {
                        deviceCOMPort = sp.getSystemPortName();
                        TestUtils.log().info(MessageConstants.TWO_BRACKETS, MessageConstants.YOUR_DEVICE_CONNECTED_MESSAGE, deviceCOMPort);
                    }
                }
            }
        }catch (Exception e){
            TestUtils.log().debug("Error occurred : While getting device COM port... {}",e.getMessage());
            throw new AutomationException("Error occurred : While getting device COM port "+e.getMessage());
        }
        return deviceCOMPort;
    }

    public static String performRoboticArmOperation(String deviceCOMPort, String actionName) throws SerialPortException {
        String roboticArmLogs = "";
        SerialPort jsscSerialPort = new SerialPort("/dev/tty.usbmodem"+deviceCOMPort.trim());
        try {
            // Define COM Port

            jsscSerialPort.openPort();

            jsscSerialPort.setParams(SerialPort.BAUDRATE_115200, 8, 1, 0);
            basePage.waitForGivenTime(2);
            if (actionName.equals("Twist & Go")) {
                jsscSerialPort.writeString("$G,"+DriverManager.getRoboticArmX()+","+DriverManager.getRoboticArmY()+",&");
            } else if (actionName.equalsIgnoreCase("TAP")) {
                jsscSerialPort.writeString("$T,"+DriverManager.getRoboticArmX()+","+DriverManager.getRoboticArmY()+",&");
            } else if (actionName.equalsIgnoreCase("Both")) {
                jsscSerialPort.writeString("$B,"+DriverManager.getRoboticArmX()+","+DriverManager.getRoboticArmY()+",&");
            } else {
                TestUtils.log().info("Action is not valid");
            }

            // Wait time
            basePage.waitForGivenTime(15); // wait till arm got any message

            // Receive Response
            roboticArmLogs = jsscSerialPort.readString();
            TestUtils.log().info("Robotic Arm message: {}",roboticArmLogs);
            if (roboticArmLogs.equalsIgnoreCase("TAP:ENABLE;\r\n")) {
                roboticArmLogs = roboticArmLogs.trim().substring(0, 10);
                TestUtils.log().info("This is my Robotic Arm message: {}", roboticArmLogs.substring(0, 10));

            } else if (roboticArmLogs.equalsIgnoreCase("TAP:DISABLE;\r\n")) {
                TestUtils.log().info(MessageConstants.TWO_BRACKETS,MessageConstants.ROBOTIC_ARM_MESSAGE, roboticArmLogs.substring(0, 11));
                roboticArmLogs = roboticArmLogs.substring(0, 11);
            } else if ((roboticArmLogs.equalsIgnoreCase("TWIST_AND_GO=:ENABLE;\r\n"))) {
                roboticArmLogs = roboticArmLogs.trim().substring(0, 20);
                TestUtils.log().info(MessageConstants.TWO_BRACKETS,MessageConstants.ROBOTIC_ARM_MESSAGE,roboticArmLogs.substring(0, 20));
            } else if ((roboticArmLogs.equalsIgnoreCase("TWIST_AND_GO:DISABLE;\r\n"))) {
                TestUtils.log().info(MessageConstants.TWO_BRACKETS,MessageConstants.ROBOTIC_ARM_MESSAGE,roboticArmLogs.substring(0, 20));
                roboticArmLogs = roboticArmLogs.substring(0, 20);
            }

        } catch (Exception e) {
            throw new AutomationException("Error occurred : Not able to perform Arm operation " + e.getMessage());
        } finally {
            jsscSerialPort.closePort();
            TestUtils.log().info("+++++++++++++++++++++++++++++++++++++++++++++++");
            TestUtils.log().info("Serial Port got closed in finally block");
            TestUtils.log().info("+++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return roboticArmLogs.trim();
    }

    public static boolean performTAPOperation() {
        try {
            //Define COM Port
            TestUtils.log().info("Device Port from DriverManager: {}",DriverManager.getDevicePort());
            SerialPort serialPort = new SerialPort("/dev/tty.usbserial-10");
            serialPort.openPort();

            serialPort.setParams(SerialPort.BAUDRATE_115200, 8, 1, 0);
            basePage.waitForGivenTime(2000);

            //Send Command
            serialPort.writeString("$T,1850,350,&");

            //Wait time
            basePage.waitForGivenTime(25000);

            //Close the COM Port
            serialPort.closePort();
            return true;
        } catch (Exception e) {
            throw new AutomationException("Error occurred : Not able to perform Tap operation " + e.getMessage());
        }
    }

    public String performTwistAndGoOperation() {
        String obj = "";
        try {
            // Define COM Port
            SerialPort jsscSerialPort = new SerialPort(DriverManager.getDevicePort());
            jsscSerialPort.openPort();

            jsscSerialPort.setParams(SerialPort.BAUDRATE_115200, 8, 1, 0);
            basePage.waitForGivenTime(2000);

            // Send Command
            jsscSerialPort.writeString("$G,1500,350,&");

            // Wait time
            basePage.waitForGivenTime(25000);

            // Receive Response
            obj = jsscSerialPort.readString();
            // Close the COM Port
            jsscSerialPort.closePort();
        } catch (Exception e) {
            throw new AutomationException("Error occurred : Not able to perform Twist and Go operation " + e.getMessage());
        }
        return obj;

    }

    public String performBothTapAndTGOperation() {
        String obj = "";
        try {
            // Define COM Port
            SerialPort jsscSerialPort = new SerialPort(DriverManager.getDevicePort());
            jsscSerialPort.openPort();

            jsscSerialPort.setParams(SerialPort.BAUDRATE_115200, 8, 1, 0);
            basePage.waitForGivenTime(2000);

            // Send Command
            jsscSerialPort.writeString("$B,1850,350,&");

            // Wait time
            basePage.waitForGivenTime(25000);

            // Receive Response
            obj = jsscSerialPort.readString();
            // Close the COM Port
            jsscSerialPort.closePort();
        } catch (Exception e) {
            throw new AutomationException("Error occurred : Not able to perform Both Tap and Twist and Go operation " + e.getMessage());
        }
        return obj;
    }


    public String performRoboticArmOperationWithDeviceState(String deviceCOMPort, String actionName, String deviceState) throws SerialPortException {
        String roboticArmLogs = "";
        SerialPort jsscSerialPort = new SerialPort("/dev/tty.usbmodem"+deviceCOMPort.trim());
        try {
            // Define COM Port

            jsscSerialPort.openPort();

            jsscSerialPort.setParams(SerialPort.BAUDRATE_115200, 8, 1, 0);
            basePage.waitForGivenTime(2);
            if (actionName.equals("Twist & Go")) {
                jsscSerialPort.writeString("$G,"+DriverManager.getRoboticArmX()+","+DriverManager.getRoboticArmY()+",&");
            } else if (actionName.equalsIgnoreCase("TAP")) {
                jsscSerialPort.writeString("$T,"+DriverManager.getRoboticArmX()+","+DriverManager.getRoboticArmY()+",&");
            } else if (actionName.equalsIgnoreCase("Both")) {
                jsscSerialPort.writeString("$B,"+DriverManager.getRoboticArmX()+","+DriverManager.getRoboticArmY()+",&");
            } else {
                TestUtils.log().info("Action is not valid");
            }

            // Wait time
            basePage.waitForGivenTime(15); // wait till arm got any message

            // Receive Response
            roboticArmLogs = jsscSerialPort.readString();
            TestUtils.log().info("Robotic Arm message: {}",roboticArmLogs);
            if (roboticArmLogs.equalsIgnoreCase("TAP:ENABLE;\r\n")) {
                roboticArmLogs = roboticArmLogs.trim().substring(0, 10);
                TestUtils.log().info("This is my Robotic Arm message: {}", roboticArmLogs.substring(0, 10));

            } else if (roboticArmLogs.equalsIgnoreCase("TAP:DISABLE;\r\n")) {
                TestUtils.log().info(MessageConstants.TWO_BRACKETS,MessageConstants.ROBOTIC_ARM_MESSAGE, roboticArmLogs.substring(0, 11));
                roboticArmLogs = roboticArmLogs.substring(0, 11);
            } else if ((roboticArmLogs.equalsIgnoreCase("TWIST_AND_GO=:ENABLE;\r\n"))) {
                roboticArmLogs = roboticArmLogs.trim().substring(0, 20);
                TestUtils.log().info(MessageConstants.TWO_BRACKETS,MessageConstants.ROBOTIC_ARM_MESSAGE,roboticArmLogs.substring(0, 20));
            } else if ((roboticArmLogs.equalsIgnoreCase("TWIST_AND_GO:DISABLE;\r\n"))) {
                TestUtils.log().info(MessageConstants.TWO_BRACKETS,MessageConstants.ROBOTIC_ARM_MESSAGE,roboticArmLogs.substring(0, 20));
                roboticArmLogs = roboticArmLogs.substring(0, 20);
            }

            basePage.waitForGivenTime(1);

            if (actionName.equals("Twist & Go") && (deviceState.equalsIgnoreCase("Locked"))) {
                AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
                try {
                    androidDeviceAction.unlockDeviceWithPin("1234");
                    //driver.pressKey(new KeyEvent(AndroidKey.POWER));
                } catch (Exception e) {
                    TestUtils.log().debug("Getting exception while lock or unlock ....");
                }
            }

        } catch (Exception e) {
            throw new AutomationException("Error occurred : Not able to perform Arm operation " + e.getMessage());
        } finally {
            jsscSerialPort.closePort();
            TestUtils.log().info("+++++++++++++++++++++++++++++++++++++++++++++++");
            TestUtils.log().info("Serial Port got closed in finally block");
            TestUtils.log().info("+++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return roboticArmLogs.trim();
    }
}


