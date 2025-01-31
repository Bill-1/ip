package ujin.helper;

import java.util.List;
import ujin.command.*;
import ujin.task.*;
import ujin.ui.*;
import ujin.*;

/**
 * The {@code Parser} class is responsible for parsing user input commands
 * and returning the appropriate {@link Command} object based on the input.
 * It can handle various types of commands such as adding tasks, marking tasks,
 * deleting tasks, and others. This class uses a simple string parsing technique
 * and splits the command into tokens to determine the action to perform.
 */
public class Parser {

    /**
     * Parses the given command string and returns a corresponding {@link Command}
     * object. The command string is split into tokens to identify the task type
     * and create the appropriate {@link Command} subclass instance.
     *
     * @param command The command string to parse.
     * @param ui The {@link Ui} object used to display error messages.
     * @return A {@link Command} object that corresponds to the parsed command.
     * @throws UjinException If the command is unrecognized or invalid.
     */
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

    /**
     * Helper method that splits a string containing task information into
     * components based on a specific delimiter.
     *
     * @param string The input string to parse.
     * @return An array of strings containing the task information.
     */
    public static String[] parseInfo(String string) {
        return string.split(" /\\S+ ");
    }
}