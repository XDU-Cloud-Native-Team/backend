package xdu.cloudnative.service.authority.exception;

/**
 * @author 邓乐丰@xduTD
 */
public class UserNotExistsException extends Exception {
    public UserNotExistsException(String msg) {
        super(msg);
    }
}
