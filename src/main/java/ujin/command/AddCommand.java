package ujin.command;

import ujin.task.*;
import ujin.ui.*;

public class AddCommand extends Command {

    Task task;
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        taskList.add(task);
        int size = taskList.size();
        ui.addedTask(task, size);
    }
}