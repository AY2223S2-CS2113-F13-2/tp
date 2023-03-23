package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_INCORRECT_TYPE;

public class IncorrectTypeException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_INCORRECT_TYPE;
    }
}
