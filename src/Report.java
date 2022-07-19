import java.util.Scanner;
public class Report {
    public static void main(String[] args) {
        System.out.println("Вас приветствует программа бухгалтерской отчетности !");

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                Manager.parseMonthReports();
            } else if (userInput == 2) {
                Manager.parseYearsReports();
            } else if (userInput == 3) {
              Manager.checkReports();
            }
            else if (userInput == 4) {
                Manager.printMonthReport();
                }
            else if (userInput == 5) {
                    Manager.printYearReport();
                }
            else if (userInput == 123) {
                    System.out.println("Пользователь завершил работу с приложением.");
                    break;
                }
            else {
                    System.out.println("Такой команды нет, повторите ввод");
                }
            }
        }

    public static void printMenu() {
        System.out.println();
        System.out.println("Выберите нужный пункт меню:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("123 - Завершить работу приложения ");
    }
}