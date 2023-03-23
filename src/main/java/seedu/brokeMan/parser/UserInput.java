package seedu.brokeMan.parser;

public class UserInput {
    protected String userCommand;
    protected String commandDescription;

    protected UserInput(String userCommand, String commandDescription) {
        this.userCommand = userCommand;
        this.commandDescription = commandDescription;
    }

    protected static UserInput splitUserInput(String userFullInput) {
        if (!userFullInput.contains(" ")) {
            return new UserInput(userFullInput, "");
        }
        String[] userSplitInputs = userFullInput.split(" ", 2);
        return new UserInput(userSplitInputs[0], userSplitInputs[1]);
    }
}
