package xdu.cloudnative.model.authority.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 * @author 邓乐丰@xduTD
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /** 打印日志 */
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


}
