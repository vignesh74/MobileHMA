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
 * @author - Brijesh Mishra
 * VideoRecordUtils- This class contains the video recording related methods
 * Date-02/11/2022
 */


package com.appium.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.appium.constants.MessageConstants;
import org.apache.commons.codec.binary.Base64;
import static com.appium.constants.FrameworkConstants.YES;
import com.appium.manager.DriverManager;

import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.Scenario;

public class VideoRecordUtils {

	private VideoRecordUtils() {
	}

	/**
	 * startRecording- This method starts recording of the tests
	 * Date-02/11/2022
	 */
	public static void startRecording() {
		if (ConfigLoader.getInstance().getPassedTestsVideo().equalsIgnoreCase(YES)
				|| ConfigLoader.getInstance().getFailedTestsVideo().equalsIgnoreCase(YES)
				|| ConfigLoader.getInstance().getSkippedTestsVideo().equalsIgnoreCase(YES)) {

			((CanRecordScreen) DriverManager.getDriver()).startRecordingScreen();
		}
	}
	
	/**
	 * stopRecording- This method stops the recording of the tests
	 * @param - Scenario
	 * Date-02/11/2022
	 */

    public static void stopRecording(Scenario scenario) throws IOException {
    	
    	String status= String.valueOf(scenario.getStatus());
		try {
			if (ConfigLoader.getInstance().getPassedTestsVideo().equalsIgnoreCase(YES) && status.equalsIgnoreCase("PASSED")) {
				String media = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
				String dirPath = MessageConstants.ARTIFACTS_STRING + File.separator + MessageConstants.VIDEOS_STRING + File.separator + "passedTests" + File.separator
						+ File.separator + DriverManager.getPlatform() + "_" + DriverManager.getDeviceName()
						+ File.separator + DriverManager.getDateTime();
				createDirectoryAndCopyFile(scenario, media, dirPath);
			} else if (ConfigLoader.getInstance().getFailedTestsVideo().equalsIgnoreCase(YES) && status.equalsIgnoreCase("FAILED")) {
				String media = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
				String dirPath = MessageConstants.ARTIFACTS_STRING + File.separator + MessageConstants.VIDEOS_STRING + File.separator + "failedTests" + File.separator
						+ File.separator + DriverManager.getPlatform() + "_" + DriverManager.getDeviceName()
						+ File.separator + DriverManager.getDateTime();
				createDirectoryAndCopyFile(scenario, media, dirPath);
			} else if (ConfigLoader.getInstance().getSkippedTestsVideo().equalsIgnoreCase(YES) && status.equalsIgnoreCase("SKIPPED")) {
				String media = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
				String dirPath = MessageConstants.ARTIFACTS_STRING + File.separator + MessageConstants.VIDEOS_STRING + File.separator + "skippedTests" + File.separator
						+ File.separator + DriverManager.getPlatform() + "_" + DriverManager.getDeviceName()
						+ File.separator + DriverManager.getDateTime();
				createDirectoryAndCopyFile(scenario, media, dirPath);
			}
		}catch (Exception e){
			TestUtils.log().debug("Exception occurred in stop recording");
		}
   }


	/**
	 * createDirectoryAndCopyFile- This method creates the directory of video recording and copy a file
	 *
	 * @param scenario- Scenario
	 * @param media-  String
	 * @param dirPath-    String
	 * Date-02/11/2022
	 */
	private static void createDirectoryAndCopyFile(Scenario scenario, String media, String dirPath) throws IOException {
		File videoDir = new File(dirPath);
		if (!videoDir.exists()) {
			videoDir.mkdirs();
		}
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(videoDir + File.separator + scenario.getName() + ".mp4");
			stream.write(Base64.decodeBase64(media));
		} catch (IOException e) {
			TestUtils.log().debug("IOException occurred ");
		} finally {
			assert stream != null;
			stream.close();
		}
	}
	
}
