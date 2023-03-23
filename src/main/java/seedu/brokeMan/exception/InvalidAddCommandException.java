package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_ADD_COMMAND;

public class InvalidAddCommandException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_INVALID_ADD_COMMAND;
    }
}
