package duke;

import duke.task.Task;

import java.util.Scanner;

public class Ui {
    public void printWelcome(){
        System.out.println("Hi! My name is Duke!\n" + "How can I help you?");
    }

    public static void printGoodbye(){
        System.out.println("Goodbye! See you soon!");
    }

    public void printLine(){
        System.out.println("________________________________________");
    }

    /**
     * Prints the list of tasks
     *
     * @param taskList The list meant to be printed
     */
    public void printList(TaskList taskList) {
        int index = 1;
        if (taskList.getSize() == 0) {
            System.out.println("The list is empty.");
        } else {
            for (Task item : taskList.getTasks()) {
                System.out.println(index++ + "." + item);
            }
        }
    }

    /**
     * Reads the input from the user and returns it as a string
     *
     * @return the user input
     */
    public String readCommand(){
        Scanner echo = new Scanner(System.in); // Scan user input
        String input = echo.nextLine();
        return input;
    }

    public void printLoadSuccess(){
        System.out.println("Save file loaded successfully.");
    }

    /**
     * Prints the relevant error message for the encountered error
     *
     * @param errorMessage The error message
     */
    public void printError(String errorMessage){
        System.out.println(errorMessage);
    }

    public void showLoadingError() {
        System.out.println("Error loading from filepath.");
    }

}
