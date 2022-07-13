import java.sql.SQLOutput;
import java.util.Scanner;
public class report {
    public void main(String[] args) {
        System.out.println("Вас приветствует программа бухгалтерской отчетности!");
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        while(true) {
            if (userInput == 1){
                // вызов метода считывания месячного отчета из класса месячных отчетов
            }
            else if (userInput == 2){
                YearlyReport yreport = new YearlyReport(2021, "resources/y.2021.csv");//вызов метода считывания годового отчета из класса годовых отчетов
            }
            else if (userInput == 3){
                // вызов метода сверки отчетов
            }
            else if (userInput == 4){
                // вызов метода печати информации из класса месячных очетов
            }
            else if (userInput == 5){
                // вызов метода печати информации из класса годового отчета
            }
            else if (userInput == 123){
                System.out.println("Пользователь завершил работу с приложением.");
            }
            else {
                System.out.println("Такой команды нет, повторите ввод");
            }
        }
    }
     public void printMenu(){
        System.out.println("Выберите нужный пункт меню:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
    }
}

