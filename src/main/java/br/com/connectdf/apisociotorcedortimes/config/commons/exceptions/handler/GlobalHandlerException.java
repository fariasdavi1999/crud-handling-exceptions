package br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.handler;

import br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.BadRequestException;
import br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.NotFoundException;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handleBadRequest(
            BadRequestException badRequestException) {

        logger.error(badRequestException.getMessage() +
                             badRequestException.getCause());

        return createProblemDetail(badRequestException, BAD_REQUEST, null,
                                   "Corpo da requisição inválido", "", null,
                                   Map.of("timestamp", LocalDateTime.now()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ProblemDetail handleNoSuchElement(
            NoSuchElementException noSuchElementException) {

        logger.error(noSuchElementException.getMessage() +
                             noSuchElementException.getCause());

        return createProblemDetail(noSuchElementException, NOT_FOUND, null,
                                   "Nenhum valor foi encontrado",
                                   "No value present", null,
                                   Map.of("timestamp", LocalDateTime.now()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(
            NotFoundException notFoundException) {
        logger.error(
                notFoundException.getMessage() + notFoundException.getCause());

        return createProblemDetail(notFoundException, NOT_FOUND, null,
                                   "Não encontrado",
                                   "No value present", null,
                                   Map.of("timestamp", LocalDateTime.now()));
    }



    private ProblemDetail createProblemDetail(Throwable exception,
                                              HttpStatus status,
                                              @Nullable URI type,
                                              @Nullable String title,
                                              @Nullable String detail,
                                              @Nullable URI instance, @Nullable
                                              Map<String, Object> properties) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status,
                                                                       exception.getMessage());
        if (title != null)
            problemDetail.setTitle(title);
        if (detail != null)
            problemDetail.setDetail(detail);
        if (type != null)
            problemDetail.setType(type);
        if (instance != null)
            problemDetail.setInstance(instance);
        if (properties != null && !properties.isEmpty()) {
            properties.forEach(problemDetail::setProperty);
        }
        return problemDetail;
    }
}

