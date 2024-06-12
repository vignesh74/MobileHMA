/**
 * DataProviderInputFileNotFound-This class contains the input file not found exception when we provide the wrong path
 * Date-24/11/2022
 */
package com.appium.exceptions;

public class DataProviderInputFileNotFound extends AutomationException {
    private static final long serialVersionUID = 8734638785785664287L;

    /**
     * DataProviderInputFileNotFound- This constructor used to send input file not found exception message
     * @param message-String
     * Date-24/11/2022
     */
    public DataProviderInputFileNotFound(String message) {
        super(message);
    }

    /**
     * DataProviderInputFileNotFound- This constructor used to send input file not found exception using message and throwable parameter
     * @param message-String
     * @param cause-Throwable
     * Date-24/11/2022
     */
    public DataProviderInputFileNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
