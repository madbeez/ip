package duke;

import duke.error.IllegalInputException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    public static void main(String[] args) {

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
    }

    private static void addTask(String input, ArrayList<Task> taskList) {
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

    private static void deleteTask(String input, ArrayList<Task> taskList){
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

    private static void markAsDone(String input, ArrayList<Task> taskList) {
        // The number of the task that is done
        try {
            int doneTask = Integer.parseInt(input.replaceAll("[^0-9]", "")) - 1;
            taskList.get(doneTask).markAsDone();
            System.out.println("Nice! I've marked this task as done:" + System.lineSeparator() + "  " + taskList.get(doneTask));
        } catch (NumberFormatException e) {
            System.out.println("You must enter the number of the task you want to mark as done.");
        }
    }

    private static void printList(ArrayList<Task> taskList) {
        if (taskList.size() == 0) {
            System.out.println("The list is empty.");
        } else {
            for (Task item: taskList) {
                System.out.println((taskList.indexOf(item) + 1) + "." + item);
            }
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("Hi! My name is Duke!\n" + "How can I help you?");
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */
    }

    // Saves the current list of tasks to a text file
    private static void saveTasks(String filePath, ArrayList<Task> taskList){
        try{
        FileWriter save = new FileWriter(filePath);
            for (Task item : taskList){
                save.write(item.toString() + System.lineSeparator());
                save.flush();
            }
            save.close();
        } catch (IOException e) {
        System.out.println("Something went wrong: " + e.getMessage());
        } catch (NullPointerException e) {
        }
    }
}
