package ujin.helper;

import java.util.List;
import ujin.command.*;
import ujin.task.*;
import ujin.ui.*;
import ujin.*;

public class Parser {
    public static Command parse(String command, Ui ui) throws UjinException{
        String[] tokens = command.split(" ", 2);

        switch (tokens[0]) {
            case "todo" -> {
                Task newTask = new Todo(tokens[1]);
                return new AddCommand(newTask);
            }
            case "deadline" -> {
                System.out.println(tokens[1]);
                String[] desc = parseInfo(tokens[1]);
                System.out.println(desc[1]);
                Task newTask = new Deadline(desc[0], desc[1]);
                return new AddCommand(newTask);
            }
            case "event" -> {
                String[] desc = parseInfo(tokens[1]);
                Task newTask = new Event(desc[0], desc[1], desc[2]);
                return new AddCommand(newTask);
            }
            case "mark" -> {
                try {
                    int index = Integer.parseInt(tokens[1]);
                    return new MarkerCommand(true, index);
                } catch (Exception e) {
                    System.out.println("\t Error!");
                }
            }
            case "unmark" -> {
                try {
                    int index = Integer.parseInt(tokens[1]);
                    return new MarkerCommand(false, index);
                } catch (Exception e) {
                    ui.showError(e.getMessage());
                }
            }
            case "delete" -> {
                try {
                    int index = Integer.parseInt(tokens[1]);
                    return new DeleteCommand(index);
                } catch (Exception e) {
                    ui.showError(e.getMessage());
                }
            }
            case "list" -> {
                return new ListCommand();
            }
            case "bye" -> {
                return new ExitCommand();
            }
            default -> {
                throw new UjinException("Please check the first word! It should be about the task!");
            }
        }

        return null;
    }

    public static String[] parseInfo(String string) {
        return string.split(" /\\S+ ");
    }
}