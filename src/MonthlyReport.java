import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class MonthlyReport {
    static HashMap<Integer, MonthExpense> monthExpenses = new HashMap<>();
    static Integer expNumber = 1;


    static void printMonthReport(){
        for (Integer expNumber : monthExpenses.keySet()){
            System.out.println(
                    "Затрата № " + expNumber +
                            ", Название "+ MonthExpense.item_name+
                            ", затрата "+ MonthExpense.is_expense+
                            ", кол-во "+ MonthExpense.quantity+
                            ", стоимость "+ MonthExpense.sum_of_one);
        }
    }

   static void addExpense(){
        System.out.println("name the expense");
        Scanner scanner = new Scanner(System.in);
        String item_name = scanner.nextLine();
        System.out.println("is it expense ?");
        Boolean is_expense = scanner.hasNextBoolean();
        System.out.println("enter quantity");
        Integer quantity = scanner.nextInt();
        System.out.println("enter sum of one");
        Integer sum_of_one = scanner.nextInt();

        MonthExpense first = new MonthExpense(item_name, is_expense, quantity, sum_of_one);
        monthExpenses.put(expNumber, first);
        expNumber++;
    }


}
