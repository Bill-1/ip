import java.io.*;
import java.nio.file.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskProcessor {

    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void writeTasksToFile(TaskList taskList, String filePath) {
        boolean firstTime = true;
        int size = taskList.size();
        for (int i = 0; i < size; i++) {
            Task task = taskList.get(i);
            String line = taskToText(task);
            try (FileWriter writer = new FileWriter(filePath, !firstTime)) { // false means overwrite mode
                writer.write(line + "\n"); // Writing a single line
                firstTime = false;
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }

    public static List<Task> readTasksFromFile(String filePath) {
        List<Task> li = new ArrayList<>();

        File file = new File(filePath);
        if (file.exists()) {
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
                if (!file.getParentFile().mkdirs()) {
                    System.out.println("Error creating folder: " + file.getParent());
                }
                else {
                    if(!file.createNewFile()) {
                        System.out.println("Error creating file: " + file.getAbsolutePath());
                    }
                }
            }
            catch (Exception e) {
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