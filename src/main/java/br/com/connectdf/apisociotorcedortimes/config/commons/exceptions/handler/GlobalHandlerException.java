package br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.handler;

import br.com.connectdf.apisociotorcedortimes.config.commons.exceptions.BadRequestException;
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

@ControllerAdvice
@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handlerBadRequest(BadRequestException e) {
        return createProblemDetail(e, HttpStatus.BAD_REQUEST, null,
                                   "Corpo de requisição inválido", null,
                                   Map.of("timestamp", LocalDateTime.now()));
    }

//    @ExceptionHandler()

    private ProblemDetail createProblemDetail(Throwable exception,
                                              HttpStatus status,
                                              @Nullable URI type,
                                              @Nullable String title,
                                              @Nullable URI instance,
                                              @Nullable Map<String, Object> properties) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status,
                                                                       exception.getMessage());
        if (title != null)
            problemDetail.setTitle(title);
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
