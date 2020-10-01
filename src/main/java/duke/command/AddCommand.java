package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

/**
 * This command adds the relevant tasks to the task list
 */
public class AddCommand extends Command{
    private String input;

    public AddCommand(String fullCommand){
        this.input = fullCommand;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage){
        try {
            if (input.contains("deadline")) {
                int slashLocation = input.indexOf("/");
                taskList.addTask(new Deadline(input.substring(input.indexOf("n") + 3, slashLocation), input.substring(slashLocation + 1)));
            } else if (input.contains("event")) {
                int slashLocation = input.indexOf("/");
                taskList.addTask(new Event(input.substring(input.indexOf("t") + 2, slashLocation), input.substring(slashLocation + 1)));
            } else {
                taskList.addTask(new Todo(input.substring(input.indexOf(" ") + 1)));
            }

            System.out.println("I've added:" + System.lineSeparator() + "  " + taskList.getTask(taskList.getSize()));

            if (taskList.getSize() > 1) {
                System.out.println("Now you have " + taskList.getSize() + " tasks in the list.");
            } else {
                System.out.println("Now you have " + taskList.getSize() + " task in the list.");
            }

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please enter your input in the correct format.");
        }
    }

}
