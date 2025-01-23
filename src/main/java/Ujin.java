import java.util.Scanner;
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
       do {
          text = scanner.nextLine();
          System.out.println("\t" + horLine);
          System.out.println("\t " + text + '\n');
          System.out.println("\t" + horLine + '\n');
       } while(!(text.equals("Bye") || text.equals("bye") || text.equals("bYe") || text.equals("ByE") ||
               text.equals("BYE") || text.equals("BYe") || text.equals("bYE") || text.equals("byE")));
       System.out.println("\t Bye. Hope to see you again soon!\n");
       System.out.println("\t" + horLine);

    }
}
