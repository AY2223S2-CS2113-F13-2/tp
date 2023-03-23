package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_TIME;

public class InvalidDateTimeException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_INVALID_TIME;
    }
}
