package ujin;

import ujin.task.*;
import ujin.command.*;
import ujin.ui.*;
import ujin.helper.*;
import java.sql.Array;
import java.util.*;
import java.io.*;


public class Ujin {

    private TaskList taskList;
    private Ui ui;

    public Ujin(String filePath) {
        ui = new Ui();
        this.taskList = new TaskList(TaskProcessor.readTasksFromFile(filePath));
    }

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

    public static void main(String[] args) {
        new Ujin("./data/tasks.txt").run();
    }

}
