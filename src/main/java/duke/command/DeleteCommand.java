package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * This command deletes the selected task from the task list
 */
public class DeleteCommand extends Command {
    private String input;

    public DeleteCommand(String fullCommand){
        this.input = fullCommand;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage){
        try {
            int chosenTask = Integer.parseInt(input.replaceAll("[^0-9]", ""));
            System.out.println("Understood. I've removed this task:" + System.lineSeparator() + "  "
                    + taskList.getTask(chosenTask));
            taskList.removeTask(chosenTask);
            System.out.println("Now you have " + (taskList.getSize()) + " tasks in the list.");
        } catch (NumberFormatException e) {
            System.out.println("You must enter the number of the task you want to delete.");
        }
    }
}
