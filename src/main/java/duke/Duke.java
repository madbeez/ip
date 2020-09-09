package duke;

import java.util.Scanner;
import duke.task.*;
import duke.error.*;

public class Duke {
    static final int TASK_COUNT = 100;

    public static void main(String[] args) {
        int count = 0;

        String input;
        Task taskList[] = new Task[TASK_COUNT];

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
                } else {
                    count = addTask(count, input, taskList); // Add input as new task
                }
            } catch (IllegalInputException e) {
                System.out.println("Input cannot be empty!");
            }
        }
    }

    private static int addTask(int count, String input, Task[] taskList) {
        try {
            if (input.contains("deadline")) {
                int slashLocation = input.indexOf("/");
                taskList[count] = new Deadline(input.substring(input.indexOf("n") + 3, slashLocation), input.substring(slashLocation + 1));
            } else if (input.contains("event")) {
                int slashLocation = input.indexOf("/");
                taskList[count] = new Event(input.substring(input.indexOf("t") + 2, slashLocation), input.substring(slashLocation + 1));
            } else {
                taskList[count] = new Todo(input);
            }

            System.out.println("I've added:" + System.lineSeparator() + "  " + taskList[count]);
            count++;

            if (count > 1) {
                System.out.println("Now you have " + count + " tasks in the list.");
            } else {
                System.out.println("Now you have " + count + " task in the list.");
            }

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please put a slash in between the description and the date.");
        }

        return count;
    }

    private static void markAsDone(String input, Task[] taskList) {
        // The number of the task that is done
        try {
            int doneTask = Integer.parseInt(input.replaceAll("[^0-9]", "")) - 1;
            taskList[doneTask].markAsDone();
            System.out.println("Nice! I've marked this task as done:" + System.lineSeparator() + "  " + taskList[doneTask]);
        } catch (NumberFormatException e) {
            System.out.println("You must enter the number of the task you want to mark as done.");
        }
    }

    private static void printList(Task[] taskList) {
        int listCount = 1;
        for (Task item: taskList){
            if (item == null) {
                if (listCount == 1) {
                    System.out.println("The list is empty.");
                }
                break;
            }
            System.out.println(listCount + "." + item);
            listCount++;
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
}
