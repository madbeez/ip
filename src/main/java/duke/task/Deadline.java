package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This represents a deadline
 * Contains both description and the deadline
 */
public class Deadline extends Task {
    private LocalDate date;

    public Deadline(String description, String by) {
        super(description);
        try {
            this.date = LocalDate.parse(by);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            this.date = null;
        }
    }


    @Override
    public String toString() {
        try {
            return "[D]" + super.toString() + "(by:" + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        } catch (NullPointerException e) {
            return "[D]" + super.toString() + "(by:Jan 1 2099)";
        }
    }
}
