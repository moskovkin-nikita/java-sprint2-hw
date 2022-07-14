import java.util.Scanner;
public class report {
    public static void main(String[] args) {
        System.out.println("Вас приветствует программа бухгалтерской отчетности !");
        MonthlyReport[] mreport = new MonthlyReport[3];
        YearlyReport yreport = null;
        String[] months = {"Январь", "Февраль", "Март"};

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                for (int i = 0; i < mreport.length; i++) {
                    mreport[i] = new MonthlyReport(i, "resources/m.20210" + (i + 1) + ".csv");
                }
            } else if (userInput == 2) {
                yreport = new YearlyReport(2021, "resources/y.2021.csv");
                //вызов метода считывания годового отчета из класса годовых отчетов
            } else if (userInput == 3) {
                if(yreport != null && mreport[0]!= null) {
                    boolean check = true;
                    for (int i = 0; i < mreport.length; i++) {
                        if (mreport[i].sumIncome() != yreport.sumIncomeInMonth(i)) {
                            System.out.println("В месяце " + months[i] + " обнаружено несоответствие по Приходам");
                            check = false;
                        }
                    }
                    for (int i = 0; i < mreport.length; i++) {
                        if (mreport[i].sumExpence() != yreport.sumExpenseInMonth(i)) {
                            System.out.println("В месяце " + months[i] + " обнаружено несоответствие по Расходам");
                            check = false;
                        }
                    }
                    if (check) {
                        System.out.println("Операция сверки завершена успешно !");
                    }
                }
                else{
                    System.out.println("Сверка не возможна, отсутствуют данные по году/месяцам !");
                }
            }
                    // вызов метода сверки отчетов
            else if (userInput == 4) {
                    for (int i = 0; i < mreport.length; i++) {
                        if (mreport[i] == null) {
                            System.out.println("Отсутствуют данные по месяцу " + months[i]);
                        } else {
                            System.out.println("Название месяца: " + months[i]);
                            System.out.println("Самый прибыльный товар: " + mreport[i].maxIncomeItem() + ", " + mreport[i].maxIncome());
                            System.out.println("Самая большая трата: " + mreport[i].maxExpenceItem() + ", " + mreport[i].maxExpence());
                            System.out.println();
                        }
                    }
                    // вызов метода печати информации из класса месячных очетов
                }
            else if (userInput == 5) {
                    if(yreport != null) {
                        System.out.println("Рассматриваемый год: " + yreport.year);
                        for (int i = 0; i < mreport.length; i++) {
                            System.out.println("Прибыль по месяцу " + months[i] + ": " + (yreport.sumIncomeInMonth(i) - yreport.sumExpenseInMonth(i)));
                        }
                        System.out.println("Средний расход за все месяцы в году: " + yreport.averageExpense());
                        System.out.println("Средний доход за все месяцы в году: " + yreport.averageIncome());
                    }
                    else{
                        System.out.println("Отсутствуют данные по году ");
                    }
                // вызов метода печати информации из класса годового отчета
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
    }
}