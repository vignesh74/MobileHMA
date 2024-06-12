/**
 * DataProviderInputFileException-This class contains the input file exception when we provide wrong format file path
 * Date-24/11/2022
 */
package com.appium.exceptions;

public class DataProviderInputFileException extends AutomationException {
    private static final long serialVersionUID = 8734638785785664287L;

    /**
     * DataProviderInputFileException- This constructor used to send input file exception message
     * @param message-String
     * Date-24/11/2022
     */
    public DataProviderInputFileException(String message) {
        super(message);
    }
}
