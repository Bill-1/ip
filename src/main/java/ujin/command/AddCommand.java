package ujin.command;

import ujin.task.*;
import ujin.ui.*;

/**
 * Represents a command to add a task to the task list.
 * This class inherits from the {@link Command} class and implements the execute behavior
 * for adding tasks.
 */
public class AddCommand extends Command {

    /** The task to be added to the task list */
    Task task;

    /**
     * Constructs an AddCommand object with the specified task.
     *
     * @param task The task to be added to the list.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the command by adding the task to the task list and displaying the result through the UI.
     *
     * @param taskList The task list containing all tasks
     * @param ui       The user interface handler
     */
    @Override
    public void execute(TaskList taskList, Ui ui) {
        taskList.add(task);
        int size = taskList.size();
        ui.addedTask(task, size);
    }
}