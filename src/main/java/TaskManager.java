import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private final static List<Character> ACTIONS  = Arrays.asList('+','-','o','x');
    Map<Integer, Task> taskMap;

    public TaskManager() {
        this.taskMap = new HashMap<>();
    }

    public TaskManager(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }

    public void taskHandler(String input){

    }

    public Map<Character, Task> parseUserInput(String input){
        Character action = input.charAt(0);
        String desc = input.substring(1).trim();
        Map<Character, Task> map = new HashMap<>();
        if (!ACTIONS.contains(action)){
           throw new IllegalArgumentException();
        }

        switch (action){
            case '+' :
                Integer id = taskMap.keySet().stream().max((x,y) -> x - y).orElse(1);
                map.put('+',new Task(id + 1,desc,TaskStatus.TO_DO));
            default:
        }

        return map;
    }
}
