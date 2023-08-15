package br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.handler;

import br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.BadRequestException;
import br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(
            BadRequestException badRequestException) {

        logger.error(badRequestException.getMessage());

        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage("Corpo da requisição inválido");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);

    }

}

