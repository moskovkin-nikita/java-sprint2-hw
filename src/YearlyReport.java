import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReport {
    int year;
    ArrayList<YRecord> rows = new ArrayList<>();

    public YearlyReport(int year, String path){
        this.year = year;
        String content = readFileContentsOrNull(path);
        String[] lines = content.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0].trim());
            int ammount = Integer.parseInt(parts[1].trim());
            boolean isExpence = Boolean.parseBoolean(parts[2].trim());
            YRecord record = new YRecord(month, ammount, isExpence);
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

    public int sumExpenseInMonth(int month){
        int sum = 0;
        for (YRecord row : rows) {
            if(row.month == (month + 1)){
                if(row.isExpense){
                    sum += row.ammount;
                }
            }
        }
        return sum;
    }

    public int sumIncomeInMonth(int month){
        int sum = 0;
        for (YRecord row : rows) {
            if(row.month == (month + 1)){
                if(!row.isExpense){
                    sum += row.ammount;
                }
            }
        }
        return sum;
    }

    public int averageExpense(){
        int sum = 0;
        int rowNumber = 0;
        for (YRecord row : rows) {
            if(row.isExpense){
                sum += row.ammount;
                rowNumber++;
            }
        }
        return sum / rowNumber;
    }
            
    public int averageIncome(){
        int sum = 0;
        int rowNumber = 0;
        for (YRecord row : rows) {
            if(!row.isExpense){
                sum += row.ammount;
                rowNumber++;
            }
        }
        return sum / rowNumber;
    }
}
