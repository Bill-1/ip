package ujin.command;

import ujin.ui.*;
import ujin.task.*;
import ujin.helper.*;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList taskList, Ui ui) {
        String filePath = "./data/tasks.txt";
        TaskProcessor.writeTasksToFile(taskList, filePath);
        this.isExit = true;
        ui.fareWell();
    }
}