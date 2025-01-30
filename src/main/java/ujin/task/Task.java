package ujin.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmarkAsDone() {
        isDone = false;
    }

    public String toString() {
        String box = "[" + (this.isDone ? "X" : " ") + "]";
        return (box + ' ' + this.description);
    }

    public String description() {
        return this.description;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public LocalDateTime parse(String date) {
        date = date.trim();
        String[] parts = date.split("[-/ ]");
        String year, month, day, time;
        if (date.contains(String.valueOf(' '))) {
            if (parts.length == 4) {
                if (parts[2].length() == 4) {
                    year = parts[2];
                    month = parts[1];
                    day = parts[0];
                }
                else{
                    year = parts[0];
                    month = parts[1];
                    day = parts[2];
                }
                time = parts[3];
            }
            else {
                year = String.valueOf(LocalDate.now().getYear());
                month = parts[0];
                day = parts[1];
                time = parts[2];
            }
        }
        else {
            time = "23:59";
            if (parts.length == 3) {
                if (parts[2].length() == 4) {
                    year = parts[2];
                    month = parts[1];
                    day = parts[0];
                } else {
                    year = parts[0];
                    month = parts[1];
                    day = parts[2];
                }
            } else {
                year = String.valueOf(LocalDate.now().getYear());
                month = parts[0];
                day = parts[1];
            }
        }
        date = year + "-" + month + "-" + day + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(date, formatter);
    }
}
