package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.util.ArrayList;

/**
 * This command prints a list of tasks matching the keyword provided by the user
 */
public class FindCommand extends Command {
    private String input;

    public FindCommand(String fullCommand){
        this.input = fullCommand;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage){
        ArrayList<Task> matches = new ArrayList<>();
        String searchTerm = input.substring(input.indexOf("d") + 2);
        int index = 0;

        for (Task item: tasklist.getTasks()){
            if (item.getDescription().contains(searchTerm)){
                matches.add(item);
            }
        }
        if (matches.isEmpty()){
            System.out.println("No matches found.");
        } else {
            System.out.println("Here are the matching tasks for your search.");
            for (Task item : matches){
                System.out.println(++index + ". " + item);
            }
        }

    }
}
