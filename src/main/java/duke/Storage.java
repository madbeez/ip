package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static final String DEFAULT_FILEPATH = "tasks.txt";
    private static String filePath;

    public Storage(String filePath) throws IOException {
        if (filePath.isEmpty()){
            this.filePath = DEFAULT_FILEPATH;
        } else{
            this.filePath = filePath;
        }

        File file = new File(filePath);

        if (!file.exists()){
            file.createNewFile();
        }
    }

    /**
     * Loads a list of tasks from the chosen filepath
     * @throws FileNotFoundException
     */
    public ArrayList<Task> load() throws FileNotFoundException {
        File data = new File(filePath);
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner text = new Scanner(data);
        int index = 0;

        while (text.hasNext()) {
            String input = text.nextLine();
            Task newTask = null;


            if (input.charAt(1) == 'T'){
                newTask = new Todo(input.substring(input.indexOf(" ") + 1));

            } else {
                String description = input.substring(input.indexOf(" ") + 1, input.indexOf("("));
                LocalDate date = LocalDate.parse(input.substring(input.indexOf(":") + 1, input.indexOf(")")), DateTimeFormatter.ofPattern("MMM d yyyy"));
                String parsedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                if (input.charAt(1) == 'D'){
                    newTask = new Deadline(description, parsedDate);
                } else if (input.charAt(1) == 'E'){
                    newTask = new Event(description, parsedDate);
                }
            }

            taskList.add(newTask);

            if (input.charAt(4) == '\u2713'){
                newTask.markAsDone();
            }
        }

        return taskList;
    }

    /**
     * Saves the current list of tasks to the chosen filepath
     *
     * @param taskList The list of tasks to be saved
     */
    public static void save(ArrayList<Task> taskList){
        try{
            FileWriter save = new FileWriter(filePath);
            for (Task item : taskList){
                save.write(item.toString() + System.lineSeparator());
                save.flush();
            }
            save.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

}
