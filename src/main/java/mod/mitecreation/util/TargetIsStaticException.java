package mod.mitecreation.util;

public class TargetIsStaticException extends ReflectiveOperationException {

    public TargetIsStaticException(String message) {
        super(message);
    }

    public TargetIsStaticException() {
        super();
    }

    public TargetIsStaticException(String message,Throwable cause) {
        super(message,cause);
    }

    public TargetIsStaticException(Throwable cause) {
        super(cause);
    }
}
