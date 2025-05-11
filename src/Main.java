import task_solutions.*;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("Введите номер задания:\n " +
                    "[1] - Task1\n " +
                    "[2] - Task2\n " +
                    "[3] - Task3\n " +
                    "[4] - Task4\n " +
                    "[5] - Task5\n " +
                    "[0] - выход");
            int taskNumber = scanner.nextInt();

            switch (taskNumber) {
                case 1:
                    System.out.println("Введите строку:");
                    task_solutions.Task1Kt.main();
                    break;
                case 2:
                    Task2 task2 = new Task2();
                    System.out.println("Введите количество веток в городе:");
                    task2.getBranches();
                    System.out.println("Введите первый момент, когда поезд" +
                            " приезжает на станцию и промежуток между поездами парой:");
                    task2.timetable();
                    System.out.println("Введите количество запросов: ");
                    task2.requests();
                    System.out.println("Введите номер ветки и момент времени," +
                            " когда друзья придут на станцию парой:");
                    task2.meetingTrain();
                    task2.checkData();
                    break;
                case 3:
                    System.out.println("Введите размер массива и его элементы: ");
                    task_solutions.Task3Kt.main();
                    break;
                case 4:
                    System.out.println("Введите размер массива и его элементы: ");
                    task_solutions.Task4Kt.main();
                    break;
                case 5:
                    System.out.println("Введите данные: ");
                    task_solutions.Task5Kt.main();
                    break;
                case 6:
                    System.out.println("Введите данные: ");
                    task_solutions.Task6Kt.main();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный номер задания. Повторите ввод.");
            }
        }
    }
}