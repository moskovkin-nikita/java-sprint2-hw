import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
  int month;
  ArrayList<MRecord> rows = new ArrayList<>();
  
  public MonthlyReport(int month, String path){
    this.month = month;
    String content = readFileContentsOrNull(path);
    String[] lines = content.split("\r?\n");
    for(int i = 1; i < lines.length; i++){

      String line = lines[i];
      String[] parts = line.split(",");
      String itemName = parts[0].trim();
      boolean isExpense = Boolean.parseBoolean(parts[1].trim());
      int quantity = Integer.parseInt(parts[2].trim());
      int sumOfOne = Integer.parseInt(parts[3].trim());
      MRecord record = new MRecord(itemName, isExpense, quantity, sumOfOne);
      rows.add(record);
      }      
    }
    
    private String readFileContentsOrNull(String path)
    {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
  
      public int sumExpence(){
        int sum = 0;
        for (MRecord row : rows) {
            if(row.isExpense){
             sum += row.quantity * row.sumOfOne;   
                }
            }
          return sum;
        }


  
      public int sumIncome(){
        int sum = 0;
        for (MRecord row : rows) {
            if(!row.isExpense){
             sum += row.quantity * row.sumOfOne;   
                }
            }

        return sum;
    }



    public int maxIncome(){
        int max = 0;
        for (MRecord row : rows) {
            if(!row.isExpense){
                if ((row.quantity * row.sumOfOne) > max){
                    max = row.quantity * row.sumOfOne;
                }
            }
        }
        return max;
    }

    public String maxIncomeItem(){
        int max = 0;
        String item = null;
        for (MRecord row : rows) {
            if(!row.isExpense){
                if ((row.quantity * row.sumOfOne) > max){
                    max = row.quantity * row.sumOfOne;
                    item = row.itemName;
                }
            }
        }
        return item;
    }




    public int maxExpence(){
        int max = 0;
        for (MRecord row : rows) {
            if(row.isExpense){
                if ((row.quantity * row.sumOfOne) > max){
                    max = row.quantity * row.sumOfOne;
                }
            }
        }
        return max;
    }

    public String maxExpenceItem(){
        int max = 0;
        String item = null;
        for (MRecord row : rows) {
            if(row.isExpense){
                if ((row.quantity * row.sumOfOne) > max){
                    max = row.quantity * row.sumOfOne;
                    item = row.itemName;
                }
            }
        }
        return item;
    }

}

