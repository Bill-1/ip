package ujin.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDateTime start, end;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Event(String description, String start, String end) {
        super(description);
        this.start = super.parse(start);
        this.end = super.parse(end);
    }

    public LocalDateTime start() {
        return start;
    }

    public LocalDateTime end() {
        return end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from:" + start.format(formatter) + " to:" + end.format(formatter) + ")";
    }
}