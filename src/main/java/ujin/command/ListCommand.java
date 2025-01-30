package ujin.command;

import ujin.task.*;
import ujin.ui.*;

public class ListCommand extends Command{

    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.showTasks(taskList);
    }
}