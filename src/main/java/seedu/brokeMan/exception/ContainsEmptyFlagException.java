package seedu.brokeMan.exception;

public class ContainsEmptyFlagException extends BrokeManException {
    @Override
    public String getMessage() {
        return "Your flags description cannot be empty.";
    }
}
