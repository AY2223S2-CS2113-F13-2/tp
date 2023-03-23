package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_MONTH;

public class InvalidMonthTimeException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_INVALID_MONTH;
    }
}
