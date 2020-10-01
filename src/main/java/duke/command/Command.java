package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class Command {
    private boolean isExit;
    public Command() {
        this.isExit = false;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
    }

    public boolean isExit(){
        return this.isExit;
    }

    public void setExit(){
        this.isExit = true;
    }
}
