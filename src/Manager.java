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
        String taskName;
        String taskDescription;
        String epicName;
        String epicDescription;

        System.out.println("Выберите тип добавляемой задачи: \n1. Обычная задача \n2. Эпик-задача");
        userInput = scanner.nextInt();
        scanner.nextLine();
        switch (userInput) {
            case 1:
                System.out.println("Введите название задачи: ");
                taskName = scanner.nextLine();
                System.out.println("Введите описание задачи: ");
                taskDescription = scanner.nextLine();
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
                epicName = scanner.nextLine();
                System.out.println("Введите описание эпик-задачи: ");
                epicDescription = scanner.nextLine();
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
        int userInput;

        System.out.println("Выберите тип задач для отображения: ");
        System.out.println("1. Обычные задачи, \n2. Эпик-задачи, \n3. Все задачи");
        userInput = scanner.nextInt();
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
        int count;

        System.out.println(">> ОБЫЧНЫЕ ЗАДАЧИ...");
        if (!tasks.isEmpty()) {
            count = 1;

            for (Task task : tasks.values()) {
                System.out.println(count + ". Название задачи: " + task.getName() + "(ID:" + task.getId() + ")" + ", Описание задачи: "
                        + task.getDescription() + ", Статус задачи: " + task.getStatus());
                ++count;
            }
        } else {
            System.out.println("Список обычных задач пуст.");
        }
    }

    public void displayOnlyEpics () {
        int count;

        System.out.println(">> ЭПИК-ЗАДАЧИ...");
        if (!epics.isEmpty()) {
            count = 1;

            for (Epic epic : epics.values()) {
                System.out.println(count + ". Название эпик-задачи: " + epic.getName() + "(ID:" + epic.getId() + ")" + ", Описание эпик-задачи: "
                        + epic.getDescription() + ", Статус эпик-задачи: " + epic.getStatus());
                ++count;
            }
        } else {
            System.out.println("Список эпик-задач пуст.");
        }
    }

    public void deleteTasks () {
        int id;
        int userInput;

        System.out.println("Выберите опцию для удаления:");
        System.out.println("1. Удалить задачу, \n2. Удалить эпик-задачу, \n3. Удалить все задачи");
        userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                displayOnlyTasks();
                if (tasks.isEmpty()) {
                    break;
                } else {
                    System.out.println("Введите ID задачи:");
                    id = scanner.nextInt();
                    if (tasks.containsKey(id)) {
                        System.out.println("Задача " + tasks.get(id).getName() + " успешно удалена!");
                        tasks.remove(id);
                    } else {
                        System.out.println("Задачи с ID" + id + " не существует!");
                    }
                }
                break;
            case 2:
                displayOnlyEpics();
                if (epics.isEmpty()) {
                    break;
                } else {
                    System.out.println("Введите ID эпик-задачи:");
                    id = scanner.nextInt();
                    if (epics.containsKey(id)) {
                        System.out.println("Эпик-задача " + epics.get(id).getName() + " успешно удалена!");
                        epics.remove(id);
                    } else {
                        System.out.println("Эпик-задачи с ID " + id + " не существует");
                    }
                }
                break;
            case 3:
                System.out.println("Вы точно уверены что хотите удалить все задачи?");
                System.out.println("1. ДА,\n2. НЕТ");
                userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        if (tasks.isEmpty() && epics.isEmpty()) {
                            System.out.println("Список задач пуст, удаление невозможно.");
                        } else {
                            tasks.clear();
                            epics.clear();
                            System.out.println("Все задачи были успешно удалены.");
                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Некорректный выбор опции.");
                }
                break;
            default:
                System.out.println("Некорректный выбор опции.");
        }
    }
}
