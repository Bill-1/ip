import java.sql.Array;
import java.util.*;
public class Ujin {
    public static void main(String[] args) {
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
       List<Task> li = new ArrayList<>();
       do {
          text = scanner.nextLine();
          System.out.println("\t" + horLine);
          if (text.equals("list")) {
             for (int i = 0; i < li.size(); i++) {
                String index = String.valueOf(i + 1);
                System.out.println("\t " + index + "." + li.get(i));
             }
          }
          else {
             String[] arr = text.split(" ");
             if (arr[0].equals("mark")) {
                int index;
                try {
                   index = Integer.parseInt(arr[1]);
                   li.get(index - 1).markAsDone();
                   System.out.println("\t Nice! I've marked this task as done:\n");
                   System.out.println("\t\t" + li.get(index - 1));
                } catch (Exception e) {
                   System.out.println("Error!");
                }
             }
             else {
                if (arr[0].equals("unmark")) {
                   int index;
                   try {
                      index = Integer.parseInt(arr[1]);
                      li.get(index - 1).unmarkAsDone();
                      System.out.println("\t OK, I've marked this task as not done yet:\n");
                      System.out.println("\t\t" + li.get(index - 1));
                   } catch (Exception e) {
                      System.out.println("Error!");
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
                      }
                      else {
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
                   if (arr[0].equals("todo")) {
                      newTask = new Todo(task);
                      li.add(newTask);
                      System.out.println("\t " + "Got it. I've added this task:\n" + "\t\t" + newTask + '\n');
                   }
                   if (arr[0].equals("deadline")) {
                      newTask = new Deadline(task, start);
                      li.add(newTask);
                      System.out.println("\t " + "Got it. I've added this task:\n" + "\t\t" + newTask + '\n');
                   }
                   if (arr[0].equals("event")) {
                      newTask = new Event(task, start, end);
                      li.add(newTask);
                      System.out.println("\t " + "Got it. I've added this task:\n" + "\t\t" + newTask + '\n');
                   }
                   String size = String.valueOf(li.size());
                   System.out.println("\t " + "Now you have " + size + " tasks in the list.\n");
                }
             }
          }

          System.out.println("\t" + horLine + '\n');
       } while(!(text.equals("Bye") || text.equals("bye") || text.equals("bYe") || text.equals("ByE") ||
               text.equals("BYE") || text.equals("BYe") || text.equals("bYE") || text.equals("byE")));
       System.out.println("\t Bye. Hope to see you again soon!\n");
       System.out.println("\t" + horLine);

    }
}
