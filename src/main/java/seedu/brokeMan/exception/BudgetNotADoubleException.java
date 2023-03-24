package seedu.brokeMan.exception;

public class BudgetNotADoubleException extends BrokeManException {
    @Override
    public String getMessage() {
        return "The budget you have set is not a double.\n" +
                "|  If you are trying to enter date information, please use t/.";
    }
}
