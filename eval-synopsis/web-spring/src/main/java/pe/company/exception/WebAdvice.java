package pe.company.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pe.company.bean.response.ErrorResponse;

@ControllerAdvice
public class WebAdvice {

    private static final Logger logger = LoggerFactory.getLogger(WebAdvice.class);
    
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<?> ClientException(ClientException e) {
        logger.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(ErrorResponse.builder().code("ERROR-0001").message("Pais no encontrado").build());
    }

}
