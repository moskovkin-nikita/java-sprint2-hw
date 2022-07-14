public class MRecord {
    String item_name;
    boolean isExpense;
    int quantity;
    int sumOfOne;

    public YRecord(String item_name, boolean isExpense, int quantity,  int sumOfOne) {
        this.item_name = item_name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
