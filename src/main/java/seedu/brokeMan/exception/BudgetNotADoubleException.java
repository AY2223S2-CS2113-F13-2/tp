package seedu.brokeMan.exception;

public class BudgetNotADoubleException extends BrokeManException {
    @Override
    public String getMessage() {
        return "The budget you have set is not a double.";
    }
}