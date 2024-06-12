/**
 * InvalidFileException-This class contains the invalid file exception when we provide the wrong file
 * Date-24/11/2022
 */
package com.appium.exceptions;

public class InvalidFileException extends AutomationException {

    private static final long serialVersionUID = 1861535540217015795L;
    /**
     * InvalidFileException- This constructor used to send invalid file exception message
     * @param message-String
     * Date-24/11/2022
     */
    public InvalidFileException(String message) {
        super(message);
    }
}
