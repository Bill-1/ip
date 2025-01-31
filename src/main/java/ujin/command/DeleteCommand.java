package ujin.command;

import ujin.task.*;
import ujin.ui.*;

public class DeleteCommand extends Command {

    private final int INDEX;

    public DeleteCommand(int index) {

        this.INDEX = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        Task task = taskList.get(INDEX - 1);
        taskList.delete(INDEX - 1);
        int size = taskList.size();
        ui.deletedTask(task, size);
    }
}