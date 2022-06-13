package xdu.cloudnative.exception;

/**
 * @author 邓乐丰@xduTD
 */
public class UserNotExistsException extends Exception {
    public UserNotExistsException(String userId) {
        super("User of id:" + userId + " not exists.");
    }
}
