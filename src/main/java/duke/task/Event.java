package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
            return "[D]" + super.toString() + "(at:" + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        } catch (NullPointerException e) {
            return "[D]" + super.toString() + "(at:N/A)";
        }
    }
}
