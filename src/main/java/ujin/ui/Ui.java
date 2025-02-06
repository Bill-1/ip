package ujin.ui;

import java.util.Scanner;

import ujin.task.Task;
import ujin.task.TaskList;

/**
 * Represents the user interface (UI) of the application. The UI is responsible for displaying
 * messages to the user and reading input from the user. It handles various user interactions
 * such as showing welcome messages, displaying tasks, and handling errors.
 * The UI includes methods for showing various types of output, such as task additions,
 * deletions, marking tasks as done or not done, and listing tasks. It also provides input
 * reading functionality for user commands.
 */
public class Ui {

    /**
     * The name of the chatbot used in the UI interaction.
     */
    private final String BOT_NAME = "Ujin";

    /**
     * A string constant representing a horizontal line used for visual separation in the UI.
     */
    private final String HOR_LINE = "____________________________________";

    /**
     * Displays a welcome message, including the bot's logo and a greeting.
     * The message includes a horizontal line separator for clarity.
     */
    public String showWelcome() {
        String logo =
                " _    _      _   _____   _   _  \n"
                        + "| |  | |    | | |_   _| | \\ | |\n"
                        + "| |  | |    | |   | |   |  \\| |\n"
                        + "| |  | | _  | |   | |   | |\\  |\n"
                        + "| |  | || |_| |  _| |_  | | \\ |\n"
                        + " \\____/  \\___/  |_____| |_| |_|\n";
        String message = "Hello from\n" + logo + HOR_LINE + "\nHello! I'm " + BOT_NAME
                + "\nWhat can I do for you?\n" + HOR_LINE;
        return message;
//        System.out.println("Hello from\n" + logo);
//        System.out.println(HOR_LINE);
//        System.out.println("Hello! I'm " + BOT_NAME);
//        System.out.println("What can I do for you?\n");
//        System.out.println(HOR_LINE);
    }

    /**
     * Reads a user input command from the console.
     *
     * @return The user input as a string.
     */
    public String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Displays a horizontal line separator in the UI.
     */
    public void showLine() {
        System.out.println(HOR_LINE);
    }

    /**
     * Displays an error message in the UI.
     *
     * @param error The error message to be displayed.
     */
    public void showError(String error) {
        System.out.println(error);
    }

    /**
     * Displays a message indicating that a task has been added.
     *
     * @param newTask The task that was added.
     * @param size The current size of the task list.
     */
    public String addedTask(Task newTask, int size) {
        String message = "Got it. I've added this task:\n" + newTask + "\nNow you have "
                + size + " task(s) in the list.\n";
        return message;
//        System.out.println("Got it. I've added this task:\n" + newTask + '\n');
//        System.out.println("Now you have " + size + " tasks in the list.\n");
    }

    /**
     * Displays a message indicating that a task has been deleted.
     *
     * @param deletedTask The task that was deleted.
     * @param size The current size of the task list.
     */
    public String deletedTask(Task deletedTask, int size) {
        String message = "Noted. I've removed this task:\n" + deletedTask + "\nNow you have "
                + size + " task(s) in the list.\n";
        return message;
//        System.out.println("Noted. I've removed this task:\n" + deletedTask);
//        System.out.println("Now you have " + size + " tasks in the list.\n");
    }

    /**
     * Displays a message indicating that a task has been marked as done.
     *
     * @param task The task that was marked as done.
     */
    public String markTask(Task task) {
        String message = "Nice! I've marked this task as done:\n" + task + "\n";
        return message;
//        System.out.println("Nice! I've marked this task as done:\n");
//        System.out.println(task);
    }

    /**
     * Displays a message indicating that a task has been unmarked (set as not done).
     *
     * @param task The task that was unmarked.
     */
    public String unmarkTask(Task task) {
        String message = "Ok! I've marked this task as not done:\n" + task + "\n";
        return message;
//        System.out.println("OK, I've marked this task as not done yet:\n");
//        System.out.println(task);
    }

    /**
     * Displays the list of tasks in the task list.
     *
     * @param taskList The list of tasks to be displayed.
     */
    public String showTasks(TaskList taskList) {
        String message = "";
        int size = taskList.size();
        for (int i = 0; i < size; i++) {
            String index = String.valueOf(i + 1);
            message += index + ". " + taskList.get(i) + "\n";
//            System.out.println(index + "." + taskList.get(i));
        }
        return message;
    }

    /**
     * Displays the list of tasks that match a search keyword.
     * This method prints out each matching task in the provided {@link TaskList}.
     *
     * @param taskList The list of tasks to display, containing the tasks that matched the search criteria.
     */
    public String findTasks(TaskList taskList) {
        String message = "Here are the matching task(s) in your list:\n";
//        System.out.println("Here are the matching tasks in your list:\n");
        int size = taskList.size();
        for (int i = 0; i < size; i++) {
            String index = String.valueOf(i + 1);
            message += index + ". " + taskList.get(i) + "\n";
//            System.out.println(index + "." + taskList.get(i));
        }
        return message;
    }

    /**
     * Displays a farewell message when the program ends.
     * The message includes a thank you note and a goodbye message.
     */
    public String fareWell() {
        String message = "Thank you for chatting with " + BOT_NAME
                + "Bye. Hope to you see you again soon!\n" + HOR_LINE + '\n';
        return message;
//        System.out.println("Thank you for chatting with " + BOT_NAME);
//        System.out.println("Bye. Hope to see you again soon!\n");
//        System.out.println(HOR_LINE);
    }
}
