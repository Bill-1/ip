package ujin.command;

import ujin.task.*;
import ujin.ui.*;

public class DeleteCommand extends Command {

    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        Task task = taskList.get(index - 1);
        taskList.delete(index - 1);
        int size = taskList.size();
        ui.deletedTask(task, size);
    }
}