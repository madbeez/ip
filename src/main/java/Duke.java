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
        String input;
        System.out.println("Hi! My name is Duke!\n" + "How can I help you?");

        // Echo loops until "bye" is inputted
        while(true) {
            Scanner echo = new Scanner(System.in); // Scan and echo user input
            input = echo.nextLine();
            if (input.equals("bye")) {
                System.out.println("Goodbye. See you soon!"); // Exits when "bye" is inputted
                break;
            }
            System.out.println(input);
        }


    }
}
