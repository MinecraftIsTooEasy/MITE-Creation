package mod.mitecreation.util;

public class TargetIsNotStaticException extends ReflectiveOperationException{
    public TargetIsNotStaticException(String message) {
        super(message);
    }

    public TargetIsNotStaticException() {
        super();
    }

    public TargetIsNotStaticException(String message,Throwable cause) {
        super(message,cause);
    }

    public TargetIsNotStaticException(Throwable cause) {
        super(cause);
    }
}
