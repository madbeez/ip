package duke;

import duke.command.*;
import duke.error.DukeException;

public class Parser {
    /**
     * Parses the input entered by the user and returns the command corresponding to the input
     *
     * @param fullCommand The input entered by the user
     * @return the relevant command based on the input
     * @throws DukeException
     */
    public static Command parse(String fullCommand) throws DukeException{
        if (fullCommand.length() == 0) {
            throw new DukeException("Input cannot be empty!");
        } if (fullCommand.equals("bye")) {
            return new ExitCommand();
        } else if (fullCommand.equals("list")) {
            return new ListCommand();
        } else if (fullCommand.contains("done")) {
            return new DoneCommand(fullCommand);
        } else if (fullCommand.contains("delete")){
            return new DeleteCommand(fullCommand);
        } else if (fullCommand.contains("todo") | fullCommand.contains("deadline") | fullCommand.contains("event")){
            return new AddCommand(fullCommand);
        } else {
            throw new DukeException("Please enter a valid command!");
        }
    }
}
