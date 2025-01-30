public class MarkerCommand extends Command {

    private final Boolean marked;
    private final int index;

    public MarkerCommand(Boolean marked, int index) {
        this.marked = marked;
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        Task task = taskList.get(index - 1);
        if (marked) {
            task.markAsDone();
            ui.markTask(task);
        }
        else {
            task.unmarkAsDone();
            ui.unmarkTask(task);
        }
    }
}