package xdu.cloudnative.exception;

public class FileNotExistsException extends Exception {
    public FileNotExistsException(String msg) {
        super(msg);
    }
}
