package ujin.command;

import ujin.task.*;
import ujin.ui.*;

public class MarkerCommand extends Command {

    private final Boolean MARKED;
    private final int INDEX;

    public MarkerCommand(Boolean marked, int index) {
        this.MARKED = marked;
        this.INDEX = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        Task task = taskList.get(INDEX - 1);
        if (MARKED) {
            task.markAsDone();
            ui.markTask(task);
        }
        else {
            task.unmarkAsDone();
            ui.unmarkTask(task);
        }
    }
}