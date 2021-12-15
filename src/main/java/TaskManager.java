import java.util.*;

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
                Integer id = taskMap.keySet().stream().max(Comparator.comparingInt(x-> x)).orElse(1);
                map.put('+',new Task(id + 1,desc,TaskStatus.TO_DO));
                break;
            case '-':
                if (taskMap.containsKey(Integer.parseInt(desc))){
                    map.put('-',taskMap.get(Integer.parseInt(desc)));
                }else {
                    throw new IllegalArgumentException();
                }
                break;
            case 'o':
                if (taskMap.containsKey(Integer.parseInt(desc))){
                    Task task = taskMap.get(Integer.parseInt(desc));
                    task.setStatus(TaskStatus.TO_DO);
                    map.put('o',task);
                }else {
                    throw new IllegalArgumentException();
                }
                break;
            case 'x':
                if (taskMap.containsKey(Integer.parseInt(desc))){
                    Task task = taskMap.get(Integer.parseInt(desc));
                    task.setStatus(TaskStatus.DONE);
                    map.put('x',task);
                }else {
                    throw new IllegalArgumentException();
                }
                break;
            default:
                break;
        }

        return map;
    }
}
