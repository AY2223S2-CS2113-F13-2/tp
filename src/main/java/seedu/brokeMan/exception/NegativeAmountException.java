package seedu.brokeMan.exception;

import static seedu.brokeMan.common.Messages.MESSAGE_NEGATIVE_AMOUNT;

public class NegativeAmountException extends BrokeManException {
    @Override
    public String getMessage() {
        return MESSAGE_NEGATIVE_AMOUNT;
    }
}
