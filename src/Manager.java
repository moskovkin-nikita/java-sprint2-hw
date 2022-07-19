public class Manager {
    static MonthlyReport[] mreport = new MonthlyReport[3];
    static YearlyReport yreport = null;
    static String[] months = {"Январь", "Февраль", "Март"};

    public static void parseMonthReports() {   // метод считывания файлов с месячными отчетами
        for (int i = 0; i < mreport.length; i++) {
            mreport[i] = new MonthlyReport(i, "resources/m.20210" + (i + 1) + ".csv");

        }
    }

    public static void parseYearsReports(){    // метод считывания файла с годовым отчетом
        yreport = new YearlyReport(2021, "resources/y.2021.csv");
    }

    public static void checkReports(){      // метод сверки месячных и годового отчетов

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

    public static void printMonthReport(){      // метод печати месячных отчетов
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

    }

    public static void printYearReport(){       // метод печати годового отчета
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

    }

}
