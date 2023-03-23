package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_OPTIONAL_TIME_FLAG;

public class InvalidOptionalTimeFlagException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_INVALID_OPTIONAL_TIME_FLAG;
    }
}
