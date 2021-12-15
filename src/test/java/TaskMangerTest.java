import static  org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TaskMangerTest {

    TaskManager taskManager;

    @BeforeAll
    public void init(){
        taskManager = new TaskManager();
        Task task = new Task(1,"Learn computer",TaskStatus.DONE);
    }

    @Test
    public void parseAddTaskTest(){


    }

    @Test
    public void parseRemoveTaskTest(){

    }

    @Test
    public void parseSetStatusDoneTest(){

    }

    @Test
    public void parserSetStatusTodo(){

    }

}
