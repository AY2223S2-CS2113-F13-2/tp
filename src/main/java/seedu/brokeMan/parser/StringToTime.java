package seedu.brokeMan.parser;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import static seedu.brokeMan.common.Messages.MESSAGE_INVALID_TIME;

public class StringToTime {
    public static LocalDateTime convertStringToTime(String timeInString) throws DateTimeException {
        String[] timeByWord = timeInString.split(" ");
        if (timeByWord.length != 5) {
            throw new DateTimeException(MESSAGE_INVALID_TIME);
        } else if (!areWordsValidTimeNumbers(timeByWord)) {
            throw new DateTimeException(MESSAGE_INVALID_TIME);
        }
        // dummy assert
        assert (timeByWord.length == 5) : MESSAGE_INVALID_TIME;

        Integer[] timeByNumber = new Integer[5];
        for (int i = 0; i < 5; i++) {
            timeByNumber[i] = Integer.parseInt(timeByWord[i]);
        }
        return LocalDateTime.of(timeByNumber[0], timeByNumber[1], timeByNumber[2], timeByNumber[3], timeByNumber[4]);
    }

    private static boolean areWordsValidTimeNumbers(String[] timeByWord) throws DateTimeException {
        try {
            for (String time : timeByWord) {
                if (Integer.parseInt(time) < 0) {
                    throw new DateTimeException(MESSAGE_INVALID_TIME);
                }
            }
            return true;
        } catch (NumberFormatException e) {
            throw new DateTimeException(MESSAGE_INVALID_TIME);
        }
    }
}
