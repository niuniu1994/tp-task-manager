import static  org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TaskMangerTest {

    TaskManager taskManager;

    @BeforeEach
    public void init(){
        taskManager = new TaskManager();
        Task task = new Task(1,"Learn computer",TaskStatus.DONE);
        taskManager.taskMap.put(task.getId(),task);
    }

    @Test
    public void parseAddTaskTest(){
        Map<Character, Task> taskMap = new HashMap<>();
        Task task = new Task(2,"Eat",TaskStatus.TO_DO);
        taskMap.put('+',task);
        String input = "+ Eat";
        assertEquals(taskMap,taskManager.parseUserInput(input));
    }


    @Test
    public void parseRemoveTaskTest(){
        Map<Character, Task> taskMap = new HashMap<>();
        Task task = new Task(1,"Learn computer",TaskStatus.DONE);
        taskMap.put('-',task);
        String input = "- 1";
        assertEquals(taskMap,taskManager.parseUserInput(input));
    }

    @Test
    public void parseSetStatusDoneTest(){

    }

    @Test
    public void parserSetStatusTodo(){

    }

}
