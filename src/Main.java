import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        printMenu();
        while (userInput != 4) {
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    manager.createTask();
                    printMenu();
                    break;
                case 2:
                    manager.displayAllTasks();
                    printMenu();
                    break;
                case 3:
                    manager.deleteTasks();
                    printMenu();
                    break;
                case 4:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Некорректный ввод! Выберите опцию из меню...");
                    printMenu();
            }
        }
    }

    private static void printMenu () {
        System.out.println(" 1. Создать новую задачу/подзадачи \n 2. Посмотреть список задач \n 3. Удалить задачу \n " +
                "4. Выход из программы");
    }
}