package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * This command prints a goodbye message and exits the program
 */
public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        Ui.printGoodbye();
        setExit();
    }

}
