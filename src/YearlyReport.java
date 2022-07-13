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
            int month = Integer.parseInt(parts[0]);
            int ammount = Integer.parseInt(parts[1]);
            boolean isExpence = Boolean.parseBoolean(parts[2]);
            YRecord record = new YRecord(month, ammount, isExpence);
            rows.add(record);
        }
    }

    public int maxExpence(){
        int max = 0;
        for (YRecord row : rows) {
            if(row.isExpense){
                if (row.ammount > max){
                    max = row.ammount;
                }
            }
        }
        return max;
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

}
