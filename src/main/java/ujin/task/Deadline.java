package ujin.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDateTime by;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Deadline(String description, String by) {
        super(description);
        this.by = super.parse(by);
    }

    public LocalDateTime by() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + by.format(formatter) + ")";
    }
}