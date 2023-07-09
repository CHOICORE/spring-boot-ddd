package me.choicore.springbootddd.presentation.rest.handler;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlingController {


    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalStateException e, HttpServletRequest request) {
        request.getMethod();
        request.getRequestURI();
        log.info("request method: {}", request.getMethod());
        log.info("request uri: {}", request.getRequestURI());


        return ResponseEntity.ok(null);


//        ErrorResponse errorResponse = ErrorResponse.create(e, HttpStatus.BAD_REQUEST, "error.illegal.state");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                             .body(errorResponse);
    }

}
