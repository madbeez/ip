package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * This command prints the entire list of tasks
 */
public class ListCommand extends Command{
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        ui.printList(tasks);
    }
}
