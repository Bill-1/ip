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
                   Task newTask = new Task(text);
                   li.add(newTask);
                   System.out.println("\t " + "added: " + text + '\n');
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
