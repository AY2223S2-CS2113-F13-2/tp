package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_EDIT_COMMAND;

public class InvalidEditCommandException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_INVALID_EDIT_COMMAND;
    }
}
