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
    }
}
