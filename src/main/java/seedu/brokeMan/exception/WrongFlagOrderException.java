package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_WRONG_FLAG_ORDER;

public class WrongFlagOrderException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_WRONG_FLAG_ORDER;
    }
}
