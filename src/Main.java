import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        printMenu();
        while (userInput != 6) {
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    manager.createTask();
                    printMenu();
                    break;
                case 2:
                    manager.createSubtask();
                    printMenu();
                    break;
                case 3:
                    manager.displayAllTasks();
                    printMenu();
                    break;
                case 4:
                    manager.updateTask();
                    printMenu();
                    break;
                case 5:
                    manager.deleteTasks();
                    printMenu();
                    break;
                case 6:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Некорректный ввод! Выберите опцию из меню...");
                    printMenu();
            }
        }
    }

    private static void printMenu () {
        System.out.println("1. Создать новую задачу \n2. Создать подзадачу для эпик-задачи \n" +
                "3. Посмотреть список задач \n4. Изменить статус задачи \n5. Удалить задачу  \n6. Выход из программы");
    }
}