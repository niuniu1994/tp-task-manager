import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("TaskManger is launched");
        String line;
        do {
            line = scanner.nextLine();
            taskManager.taskHandler(line);
        }while (!line.equals("q"));
        System.out.println("Bye");
    }

}
