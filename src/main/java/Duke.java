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
        String[] list = new String[100];

        System.out.println("Hi! My name is Bop!\n" + "How can I help you?");

        // Echo loops until "bye" is inputted
        while(true) {
            Scanner echo = new Scanner(System.in); // Scan and echo user input
            input = echo.nextLine();
            if (input.equals("bye")) {
                System.out.println("Goodbye. See you soon!"); // Exits when "bye" is inputted
                break;
            }
            else if (input.equals("list")){
                int listCount = 1;
                for (String item: list){
                    if (item == null) {
                        if (listCount == 1)
                            System.out.println("The list is empty.");
                        break;
                    }
                    System.out.println(listCount + ". " + item);
                    listCount++;
                }
            }
            else {
                list[count] = input;
                count++;
                System.out.println("added: " + input);
            }
        }
    }
}
