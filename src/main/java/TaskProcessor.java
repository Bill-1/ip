import java.io.*;
import java.nio.file.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskProcessor {
    protected static String folderPath = "./folder";
    protected static String filePath = "./folder/tasks.txt";
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void writeTasksToFile(List<Task> li) {
        boolean firstTime = true;
        for (Task task : li) {
            String line = taskToText(task);
            try (FileWriter writer = new FileWriter(filePath, !firstTime)) { // false means overwrite mode
                writer.write(line + "\n"); // Writing a single line
                firstTime = false;
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }

    public static List<Task> readTasksFromFile() {
        List<Task> li = new ArrayList<>();

        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                try{
                    List<String> lines = Files.readAllLines(Paths.get(filePath));
                    for (String line : lines) {
                        li.add(textToTask(line));
                    }
                    return li;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                try {
                    Files.createFile(Paths.get(filePath));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        else {
            Path path = Paths.get(folderPath);
            try {
                Files.createDirectory(path);
                Files.createFile(Paths.get(filePath));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return li;
    }

    public static String taskToText(Task task) {
        String text = "";
        if (task instanceof Todo) {
            text += "T";
        }
        if (task instanceof Deadline) {
            text += "D";
        }
        if (task instanceof Event) {
            text += "E";
        }
        text += " | ";
        text += (task.isDone ? "1" : "0");
        text += " | ";
        if (task instanceof Todo) {
            text += task.description;
        }
        if (task instanceof Deadline) {
            text += task.description;
            text += " | ";
            text += ((Deadline) task).by.format(formatter);
        }
        if (task instanceof Event) {
            text += task.description;
            text += " | ";
            text += ((Event) task).start.format(formatter);
            text += " | ";
            text += ((Event) task).end.format(formatter);
        }
        return text;
    }

    public static Task textToTask(String text) {
        Task task;
        String[] parts = text.split("\\|");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        switch (parts[0]) {
            case "T":
                task = new Todo(parts[2]);
                if (parts[0].equals("1")) {
                    task.markAsDone();
                }
                break;
            case "D":
                task = new Deadline(parts[2], parts[3]);
                if (parts[0].equals("1")) {
                    task.markAsDone();
                }
                break;
            case "E":
                task = new Event(parts[2], parts[3], parts[4]);
                if (parts[0].equals("1")) {
                    task.markAsDone();
                }
                break;
            default:
                task = null;
        }
        return task;
    }
}