package br.com.connectdf.apisociotorcedortimes.commons.exceptions;

import java.io.Serial;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
