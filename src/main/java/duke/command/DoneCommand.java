package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class DoneCommand extends Command{
    private String input;

    public DoneCommand(String fullCommand){
        this.input = fullCommand;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage){
        try {
            int doneTask = Integer.parseInt(input.replaceAll("[^0-9]", "")) - 1;
            taskList.getTask(doneTask).markAsDone();
            System.out.println("Nice! I've marked this task as done:" + System.lineSeparator() + "  " + taskList.getTask(doneTask));
        } catch (NumberFormatException e) {
            System.out.println("You must enter the number of the task you want to mark as done.");
        }
    }
}
