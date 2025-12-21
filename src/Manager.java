import task.Epic;
import task.Task;

import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    protected HashMap <Integer, Epic> epics;
    protected HashMap <Integer, Task> tasks;

    public Manager () {
        epics = new HashMap<>();
        tasks = new HashMap<>();
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    protected void createTask () {
        int userInput;

        System.out.println("Выберите тип добавляемой задачи: \n 1. Обычная задача \n 2. Эпик-задача");
        userInput = scanner.nextInt();
        scanner.nextLine();
        switch (userInput) {
            case 1:
                System.out.println("Введите название задачи: ");
                String taskName = scanner.nextLine();
                System.out.println("Введите описание задачи: ");
                String taskDescription = scanner.nextLine();
                Task task = new Task(taskName, taskDescription);
                if (tasks.containsKey(task.getId())) {
                    System.out.println("Такая задача уже есть!");
                } else {
                    tasks.put(task.getId(), task);
                    System.out.println("Задача успешно добавлена");
                }
                break;
            case 2:
                System.out.println("Введите название эпик-задачи: ");
                String epicName = scanner.nextLine();
                System.out.println("Введите описание эпик-задачи: ");
                String epicDescription = scanner.nextLine();
                Epic epic = new Epic(epicName, epicDescription);
                if (epics.containsKey(epic.getId())) {
                    System.out.println("Такая эпик-задача уже есть!");
                } else {
                    epics.put(epic.getId(), epic);
                    System.out.println("Эпик-задача успешно добавлена!");
                }
                break;
            default:
                System.out.println("Некорректный тип задачи.");
        }
    }

    public void displayAllTasks () {
        System.out.println("Выберите тип задач для отображения: ");
        System.out.println("1. Обычные задачи, \n 2. Эпик-задачи, \n 3. Все задачи");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                displayOnlyTasks();
                break;
            case 2:
                displayOnlyEpics();
                break;
            case 3:
                System.out.println("======== ВСЕ ЗАДАЧИ... =======");
                displayOnlyTasks();
                displayOnlyEpics();
                break;
            default:
                System.out.println("Некорректный тип задач!");
        }
    }

    public void displayOnlyTasks() {
        System.out.println(">> ОБЫЧНЫЕ ЗАДАЧИ...");
        if (!tasks.isEmpty()) {
            int count = 1;

            for (Task task : tasks.values()) {
                System.out.println(count + ". Название задачи: " + task.getName() + ", Описание задачи: "
                        + task.getDescription() + ", Статус задачи: " + task.getStatus());
                ++count;
            }
        } else {
            System.out.println("Список обычных задач пуст.");
        }
    }

    public void displayOnlyEpics () {
        System.out.println(">> ЭПИК-ЗАДАЧИ...");
        if (!epics.isEmpty()) {
            int count = 1;

            for (Epic epic : epics.values()) {
                System.out.println(count + ". Название эпик-задачи: " + epic.getName() + ", Описание эпик-задачи: "
                        + epic.getDescription() + ", Статус эпик-задачи: " + epic.getStatus());
                ++count;
            }
        } else {
            System.out.println("Список эпик-задач пуст.");
        }
    }
}
