package ujin.ui;

import ujin.task.*;

import java.util.Scanner;

public class Ui{

    private final String BOTNAME = "Ujin";
    private final String HORLINE = "____________________________________________________________";

    public void showWelcome() {
        String logo =
                " _    _      _   _____   _   _  \n" +
                        "| |  | |    | | |_   _| | \\ | |\n" +
                        "| |  | |    | |   | |   |  \\| |\n" +
                        "| |  | | _  | |   | |   | |\\  |\n" +
                        "| |  | || |_| |  _| |_  | | \\ |\n" +
                        " \\____/  \\___/  |_____| |_| |_|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(HORLINE);
        System.out.println("Hello! I'm " + BOTNAME);
        System.out.println("What can I do for you?\n");
        System.out.println(HORLINE);
    }

    public String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println(HORLINE);
    }

    public void showError(String error) {
        System.out.println(error);
    }

    public void addedTask(Task newTask, int size) {
        System.out.println("Got it. I've added this task:\n" + newTask + '\n');
        System.out.println("Now you have " + size + " tasks in the list.\n");
    }

    public void deletedTask(Task deletedTask, int size) {
        System.out.println("Noted. I've removed this task:\n" + deletedTask);
        System.out.println("Now you have " + size + " tasks in the list.\n");
    }

    public void markTask(Task task) {
        System.out.println("Nice! I've marked this task as done:\n");
        System.out.println(task);
    }

    public void unmarkTask(Task task) {
        System.out.println("OK, I've marked this task as not done yet:\n");
        System.out.println(task);
    }

    public void showTasks(TaskList taskList) {
        int size = taskList.size();
        for (int i = 0; i < size; i++) {
            String index = String.valueOf(i + 1);
            System.out.println(index + "." + taskList.get(i));
        }
    }

    public void fareWell() {
        System.out.println("Thank you for chatting with " + BOTNAME);
        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(HORLINE);
    }
}