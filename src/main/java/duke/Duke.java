package duke;

import duke.command.Command;
import duke.error.DukeException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
            ui.printLoadSuccess();
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.printWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.printLine(); // show the divider line
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                Storage.save(tasks.getTasks());
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.printError(e.getErrorMessage());
            } finally {
                ui.printLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        new Duke("tasks.txt").run();
/*
        String input;
        ArrayList<Task> taskList = new ArrayList<>();

        printWelcomeMessage();

        // Echo loops until "bye" is inputted
        while(true) {
            Scanner echo = new Scanner(System.in); // Scan user input
            input = echo.nextLine();

            // Exit program if "bye" is inputted
            try {
                if (input.length() == 0) {
                    throw new IllegalInputException();
                } if (input.equals("bye")) {
                    System.out.println("Goodbye. See you soon!");
                    break;
                } else if (input.equals("list")) {
                    printList(taskList);
                } else if (input.contains("done")) {
                    markAsDone(input, taskList);
                } else if (input.contains("delete")){
                    deleteTask(input, taskList);
                } else if (input.contains("todo") | input.contains("deadline") | input.contains("event")){
                    addTask(input, taskList); // Add input as new task
                } else {
                    System.out.println("Please enter a valid command!");
                }
                saveTasks("saveFile.txt", taskList);
            } catch (IllegalInputException e) {
                System.out.println("Input cannot be empty!");
            }
        }
 */
    }
}
