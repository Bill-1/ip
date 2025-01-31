package ujin.helper;

import ujin.task.Task;
import ujin.task.Deadline;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaskProcessorTest {
    @Test
    public void TestTaskToText() {
        Task task = new Deadline("borrow book", "2024/07/28");
        assertEquals("D | 0 | borrow book | 2024-07-28 23:59", TaskProcessor.taskToText(task));
    }
}