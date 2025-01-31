package ujin.command;

import ujin.task.*;
import ujin.ui.*;

/**
 * Represents an abstract base class for all command implementations.
 * This class defines the fundamental structure for commands in the application, requiring
 * subclasses to implement the {@code execute} method and optionally manage exit status.
 */
public abstract class Command {

    /**
     * Indicates whether this command should terminate the application.
     */
    public boolean isExit = false;

    /**
     * Executes the command's primary operation.
     */
    public abstract void execute(TaskList taskList, Ui ui);

    /**
     * Checks if this command represents an exit request.
     *
     * @return {@code true} if the command terminates the application, {@code false} otherwise.
     */
    public boolean isExit() {
        return isExit;
    }
}