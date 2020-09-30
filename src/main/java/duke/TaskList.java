package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

// Stores the task list and contains operations on the task list
public class TaskList {
    private ArrayList<Task> taskList;
    public TaskList() {
        this.taskList = new ArrayList<>();
    }
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }


    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public Task getTask(int index) {
        return taskList.get(index - 1);
    }

    public int getSize() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(int index) {
        taskList.remove(index - 1);
    }

/*
    public static void addTask(String input, ArrayList<Task> taskList) {
        try {
            if (input.contains("deadline")) {
                int slashLocation = input.indexOf("/");
                taskList.add(new Deadline(input.substring(input.indexOf("n") + 3, slashLocation), input.substring(slashLocation + 1)));
            } else if (input.contains("event")) {
                int slashLocation = input.indexOf("/");
                taskList.add(new Event(input.substring(input.indexOf("t") + 2, slashLocation), input.substring(slashLocation + 1)));
            } else {
                taskList.add(new Todo(input.substring(input.indexOf(" ") + 1)));
            }

            System.out.println("I've added:" + System.lineSeparator() + "  " + taskList.get(taskList.size()-1));

            if (taskList.size() > 1) {
                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
            } else {
                System.out.println("Now you have " + taskList.size() + " task in the list.");
            }

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please put a slash in between the description and the date.");
        }
    }

    public static void deleteTask(String input, ArrayList<Task> taskList){
        try {
            int chosenTask = Integer.parseInt(input.replaceAll("[^0-9]", "")) - 1;
            System.out.println("Understood. I've removed this task:" + System.lineSeparator() + "  "
                    + taskList.get(chosenTask) + System.lineSeparator() + "Now you have " + (taskList.size() - 1)
                    + " tasks in the list.");
            taskList.remove(taskList.get(chosenTask));
        } catch (NumberFormatException e) {
            System.out.println("You must enter the number of the task you want to delete.");
        }
    }

    public static void markAsDone(String input, ArrayList<Task> taskList) {
        // The number of the task that is done
        try {
            int doneTask = Integer.parseInt(input.replaceAll("[^0-9]", "")) - 1;
            taskList.get(doneTask).markAsDone();
            System.out.println("Nice! I've marked this task as done:" + System.lineSeparator() + "  " + taskList.get(doneTask));
        } catch (NumberFormatException e) {
            System.out.println("You must enter the number of the task you want to mark as done.");
        }
    }
    */
}
