package xdu.cloudnative.service.file.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xdu.cloudnative.service.file.vo.ValidError;

/**
 * @author 邓乐丰@xduTD
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public ValidError handleValidException() {
        return null;
    }

}
