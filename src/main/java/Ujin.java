import java.sql.Array;
import java.util.*;
import java.io.*;

public class Ujin {
    public static void main(String[] args) {

        List<Task> li = TaskProcessor.readTasksFromFile();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            TaskProcessor.writeTasksToFile(li);
        }));
        Scanner scanner = new Scanner(System.in);
        String logo =
                " _    _      _   _____   _   _  \n" +
                        "| |  | |    | | |_   _| | \\ | |\n" +
                        "| |  | |    | |   | |   |  \\| |\n" +
                        "| |  | | _  | |   | |   | |\\  |\n" +
                        "| |  | || |_| |  _| |_  | | \\ |\n" +
                        " \\____/  \\___/  |_____| |_| |_|\n";
        System.out.println("Hello from\n" + logo);
        String botName = "Ujin";
        String horLine = "____________________________________________________________";
        System.out.println("\t" + horLine);
        System.out.println("\t Hello! I'm " + botName);
        System.out.println("\t What can I do for you?\n");
        System.out.println("\t" + horLine);
        String text;

        do {
            text = scanner.nextLine();
            System.out.println("\t" + horLine);
            try {
                if (text.equals("list")) {
                    for (int i = 0; i < li.size(); i++) {
                        String index = String.valueOf(i + 1);
                        System.out.println("\t " + index + "." + li.get(i));
                    }
                } else {
                    String[] arr = text.split(" ");
                    if (arr[0].equals("delete")) {
                        if (arr.length != 2) {
                            throw new UjinException("Oops, it seems you put more or less variables :(");
                        }
                        int index;
                        try {
                            index = Integer.parseInt(arr[1]);
                            Task deletedTask = li.get(index - 1);
                            li.remove(index - 1);
                            String size = String.valueOf(li.size());
                            System.out.println("\t Noted. I've removed this task:\n");
                            System.out.println("\t\t" + deletedTask + '\n');
                            System.out.println("\t\tNow you have " + size + " tasks in the list.\n");
                        } catch (Exception e) {
                            System.out.println("\t Error!");
                        }
                    } else {
                        if (arr[0].equals("mark")) {
                            if (arr.length != 2) {
                                throw new UjinException("Oops, it seems you put more or less variables :(");
                            }
                            int index;
                            try {
                                index = Integer.parseInt(arr[1]);
                                li.get(index - 1).markAsDone();
                                System.out.println("\t Nice! I've marked this task as done:\n");
                                System.out.println("\t\t" + li.get(index - 1));
                            } catch (Exception e) {
                                System.out.println("\t Error!");
                            }
                        } else {
                            if (arr[0].equals("unmark")) {
                                if (arr.length != 2) {
                                    throw new UjinException("Oops, it seems you put more or less variables :(");
                                }
                                int index;
                                try {
                                    index = Integer.parseInt(arr[1]);
                                    li.get(index - 1).unmarkAsDone();
                                    System.out.println("\t OK, I've marked this task as not done yet:\n");
                                    System.out.println("\t\t" + li.get(index - 1));
                                } catch (Exception e) {
                                    System.out.println("Oops, you should put a number!");
                                }
                            } else {
                                boolean flag = true, secondFlag = false;
                                String start = "", end = "", task = "";
                                for (int i = 0; i < arr.length; i++) {
                                    String currentText = arr[i];
                                    if (currentText.charAt(0) == '/') {
                                        if (flag) {
                                            flag = false;
                                        } else {
                                            secondFlag = true;
                                        }
                                    } else {
                                        if (flag && i != 0) {
                                            task += (currentText + " ");
                                        }
                                        if (!flag && !secondFlag) {
                                            start += (" " + currentText);
                                        }
                                        if (secondFlag) {
                                            end += (" " + currentText);
                                        }
                                    }
                                }
                                Task newTask;
                                String size;
                                switch (arr[0]) {
                                    case "todo":
                                        if (arr.length == 1) {
                                            throw new UjinException("Oops! There is no task!");
                                        }
                                        newTask = new Todo(task);
                                        li.add(newTask);
                                        System.out.println("\t " + "Got it. I've added this task:\n" + "\t\t" + newTask + '\n');
                                        size = String.valueOf(li.size());
                                        System.out.println("\t " + "Now you have " + size + " tasks in the list.\n");
                                        break;
                                    case "deadline":
                                        if (arr.length == 1) {
                                            throw new UjinException("Oops! There is no task!");
                                        }
                                        newTask = new Deadline(task, start);
                                        li.add(newTask);
                                        System.out.println("\t " + "Got it. I've added this task:\n" + "\t\t" + newTask + '\n');
                                        size = String.valueOf(li.size());
                                        System.out.println("\t " + "Now you have " + size + " tasks in the list.\n");
                                        break;
                                    case "event":
                                        if (arr.length == 1) {
                                            throw new UjinException("Oops! There is no task!");
                                        }
                                        newTask = new Event(task, start, end);
                                        li.add(newTask);
                                        System.out.println("\t " + "Got it. I've added this task:\n" + "\t\t" + newTask + '\n');
                                        size = String.valueOf(li.size());
                                        System.out.println("\t " + "Now you have " + size + " tasks in the list.\n");
                                        break;
                                    case "bye":
                                        break;
                                    default:
                                        throw new UjinException("Please check the first word! It should be about the task!");
                                }

                            }
                        }
                    }
                }
            } catch (UjinException e) {
                System.out.println("\t" + e.getMessage());
            }

            if (!text.equals("bye")) {
                System.out.println("\t" + horLine + '\n');
            }
        } while (!(text.equals("Bye") || text.equals("bye") || text.equals("bYe") || text.equals("ByE") ||
                text.equals("BYE") || text.equals("BYe") || text.equals("bYE") || text.equals("byE")));
        System.out.println("\t Bye. Hope to see liyou again soon!\n");
        System.out.println("\t" + horLine);
        TaskProcessor.writeTasksToFile(li);
    }

}
