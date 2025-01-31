package ujin;

import ujin.task.*;
import ujin.command.*;
import ujin.ui.*;
import ujin.helper.*;
import java.sql.Array;
import java.util.*;
import java.io.*;

/**
 * Represents the main application for managing tasks. The `Ujin` class integrates the user interface (UI),
 * task list management, and file handling. It initializes the task list from a file, handles user commands,
 * and performs actions like adding, deleting, and updating tasks.
 * The application supports saving the task list to a file when the program is exiting using a shutdown hook.
 */
public class Ujin {

    /**
     * The list of tasks managed by the application.
     */
    private TaskList taskList;

    /**
     * The user interface (UI) component for interacting with the user.
     */
    private Ui ui;

    /**
     * Constructs a new `Ujin` application with the specified file path for loading and saving tasks.
     * It initializes the UI and loads the task list from the specified file.
     *
     * @param filePath The file path where tasks are stored and loaded from.
     */
    public Ujin(String filePath) {
        ui = new Ui();
        this.taskList = new TaskList(TaskProcessor.readTasksFromFile(filePath));
    }

    /**
     * Runs the application, displaying the welcome message and continuously reading and processing user commands.
     * The task list is saved to the file when the program shuts down (via a shutdown hook).
     */
    public void run() {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            String filePath = "./data/tasks.txt";
            TaskProcessor.writeTasksToFile(taskList, filePath);
        }));

        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String command = ui.readCommand();
            ui.showLine();
            try {
                Command c = Parser.parse(command, ui);
                c.execute(taskList, ui);
                isExit = c.isExit();
            } catch (UjinException e) {
                ui.showError(e.getMessage());
            }
            ui.showLine();
        }
    }

    /**
     * The entry point of the application. Initializes and runs the `Ujin` application with the task file.
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        new Ujin("./data/tasks.txt").run();
    }

}
