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
            this.date = null;
        }
    }

    @Override
    public String toString() {
        try {
            return "[E]" + super.toString() + "(at:" + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        } catch (NullPointerException e) {
            return "[E]" + super.toString() + "(at:Jan 1 2099)"; // Placeholder date
        }
    }
}
