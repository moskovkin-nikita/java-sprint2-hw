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
               MonthlyReportNew mreportOne = new MonthlyReportNew(01, "resources/m.202101.csv"); 
               MonthlyReportNew mreportTwo = new MonthlyReportNew(02, "resources/m.202102.csv");
               MonthlyReportNew mreportThree = new MonthlyReportNew(03, "resources/m.202103.csv");
                // вызов метода считывания месячных отчетов
            }
            else if (userInput == 2){
                YearlyReport yreport = new YearlyReport(2021, "resources/y.2021.csv");
                    //вызов метода считывания годового отчета из класса годовых отчетов
            }
            else if (userInput == 3){
                int incomeOne = mreportOne.sumIncome();
                int expenseOne = mreportOne.sumExpence();
                
                int incomeTwo = mreportTwo.sumIncome();
                int expenseTwo = mreportTwo.sumExpence();
                
                int incomeThree = mreportThree.sumIncome();
                int expenseThree = mreportThree.sumExpence();
                
                int msumIncome = incomeOne + incomeTwo + incomeThree;
                int msumExpense = expenseOne + expenseTwo + expenseThree;
                
                if (yreport.sumExpence() == msumExpense){
                    System.out.println("Проверка по расходам пройдена")
                }
                else {
                     System.out.println("Проверка по расходам НЕ пройдена")
                }
                
                if (yreport.sumIncome() == msumIncome){
                    System.out.println("Проверка по приходам пройдена")
                }
                else {
                     System.out.println("Проверка по приходам НЕ пройдена")
                }                
                
                
                // вызов метода сверки отчетов
            }
            else if (userInput == 4){
                System.out.println("Название месяца: " + mreportOne.month);
                System.out.println("Самая большая трата: " + mreportOne.maxIncome() + ", " + mreportOne.maxIncomeItem());
                System.out.println("Самая большая трата: " + mreportOne.maxExpence() + ", " + mreportOne.maxExpenceItem());
                println();
                System.out.println("Название месяца: " + mreportTwo.month);
                System.out.println("Самая большая трата: " + mreportTwo.maxIncome() + ", " + mreportTwo.maxIncomeItem());
                System.out.println("Самая большая трата: " + mreportTwo.maxExpence() + ", " + mreportTwo.maxExpenceItem());
                println();
                System.out.println("Название месяца: " + mreportThree.month);
                System.out.println("Самая большая трата: " + mreportThree.maxIncome() + ", " + mreportThree.maxIncomeItem());
                System.out.println("Самая большая трата: " + mreportThree.maxExpence() + ", " + mreportThree.maxExpenceItem());               
                
                // вызов метода печати информации из класса месячных очетов
            }
            else if (userInput == 5){
                System.out.println("Рассматриваемый год: " + yreport.year);
                
                System.out.println("Прибыль по месяцам: " + (yreport.sumIncomeInMonth(0) - yreport.sumExpenceInMonth(0)));
                System.out.println("Прибыль по месяцам: " + (yreport.sumIncomeInMonth(1) - yreport.sumExpenceInMonth(1)));
                System.out.println("Прибыль по месяцам: " + (yreport.sumIncomeInMonth(2) - yreport.sumExpenceInMonth(2)));                
                
                System.out.println("Средний расход за все месяцы в году: " + yreport.averageExpence());
                System.out.println("Средний доход за все месяцы в году: " + yreport.averageIncome());                
                                
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

