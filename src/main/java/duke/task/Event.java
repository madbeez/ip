package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This represents an event
 * Contains both description and the event's date
 */
public class Event extends Task{
    private LocalDate date;

    public Event(String description, String at) {
        super(description);
        try {
            this.date = LocalDate.parse(at);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            this.date = LocalDate.parse("2099-01-01"); // Placeholder date
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at:" + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
