import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */
        int count = 0;
        String input;
        Task list[] = new Task[100];

        System.out.println("Hi! My name is Duke!\n" + "How can I help you?");

        // Echo loops until "bye" is inputted
        while(true) {
            Scanner echo = new Scanner(System.in); // Scan and echo user input
            input = echo.nextLine();

            // Exit program if "bye" is inputted
            if (input.equals("bye")) {
                System.out.println("Goodbye. See you soon!");
                break;
            }

            // Print list of tasks
            else if (input.equals("list")){
                int listCount = 1;
                for (Task item: list){
                    if (item == null) {
                        if (listCount == 1)
                            System.out.println("The list is empty.");
                        break;
                    }
                    System.out.println(listCount + "." + item);
                    listCount++;
                }
            }

            // Set selected task as done
            else if (input.contains("done")){
                // The number of the task that is done
                int doneTask = Integer.parseInt(input.replaceAll("[^0-9]", "")) - 1;
                list[doneTask].markAsDone();
                System.out.println("Nice! I've marked this task as done:\n" + list[doneTask]);
            }

            // Add input as new task
            else {
                if (input.contains("deadline")){
                    int slashLocation = input.indexOf("/");
                    list[count] = new Deadline(input.substring(input.indexOf("n") + 3,slashLocation),input.substring(slashLocation+1));
                }

                else if (input.contains("event")){
                    int slashLocation = input.indexOf("/");
                    list[count] = new Event(input.substring(input.indexOf("t") + 2,slashLocation),input.substring(slashLocation+1));
                }

                else {
                    list[count] = new ToDo(input);
                }

                System.out.println("I've added: " + System.lineSeparator() + "  " + list[count]);
                count++;
                System.out.println("Now you have " + count + " tasks in the list.");

            }
        }
    }
}
