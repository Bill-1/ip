package ujin.command;

import ujin.Contact;
import ujin.task.Task;
import ujin.task.TaskList;
import ujin.ui.Ui;

public class AddContactCommand extends Command{
    public Contact contact;

    public AddContactCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute(TaskList taskList, Ui ui) {
        int size = taskList.size();
        return "Hello world!";
    }
}