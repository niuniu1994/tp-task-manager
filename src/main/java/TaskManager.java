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
        Map<Character, Task> taskMap1 = parseUserInput(input);
        Character action = taskMap1.keySet().stream().findFirst().get();
        Task task = taskMap1.get(action);
        if (action.equals('-')){
            taskMap.remove(task.getId());
        }else {
            taskMap.put(task.getId(),task);
        }

        System.out.println(parseMap2String());
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
                Integer id = taskMap.keySet().stream().max(Comparator.comparingInt(x-> x)).orElse(0);
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

    public String parseMap2String(){
        StringBuilder stringBuilder = new StringBuilder();
        taskMap.keySet().forEach(key -> {
            Task task = taskMap.get(key);
            stringBuilder.append(String.format("%d [%s] %s\n",task.getId(),task.getStatus().getStatus(),task.getDesc()));
        });
        return stringBuilder.toString().substring(0,stringBuilder.length() > 0 ? stringBuilder.length()-1 : 0);
    }


    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }
    public String parseMap2String(){
        StringBuilder stringBuilder = new StringBuilder();
        taskMap.keySet().forEach(key -> {
            Task task = taskMap.get(key);
            stringBuilder.append(String.format("%d [%s] %s\n",task.getId(),task.getStatus().getStatus(),task.getDesc()));
        });
        return stringBuilder.toString();
    }

}
