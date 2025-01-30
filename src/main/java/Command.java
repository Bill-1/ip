public abstract class Command {

    public boolean isExit = false;

    public abstract void execute(TaskList taskList, Ui ui);

    public boolean isExit() {
        return isExit;
    }
}