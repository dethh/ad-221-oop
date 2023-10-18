import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bill regularCustomerBill = new Bill();
        System.out.println("Постійний клієнт:");
        regularCustomerBill.addItem(new Item("Товар 1", 50.0, 15.0));
        regularCustomerBill.addItem(new Item("Товар 2", 20.0, 13.5));
        regularCustomerBill.addItem(new Item("Товар 3", 700.0, 199.5));
        regularCustomerBill.addItem(new Item("Товар 4", 80.0, 5.0));
        regularCustomerBill.addItem(new Item("Товар 5", 100.0, 10.0));
        regularCustomerBill.printBill();
        commonBill commonCustomerBill = new commonBill();
        System.out.println("Звичайний клієнт:");
        commonCustomerBill.addItem(new Item("Товар 1", 50.0, 15.0));
        commonCustomerBill.addItem(new Item("Товар 2", 20.0, 13.5));
        commonCustomerBill.addItem(new Item("Товар 3", 700.0, 199.5));
        commonCustomerBill.addItem(new Item("Товар 4", 80.0, 0.0));
        commonCustomerBill.addItem(new Item("Товар 5", 100.0, 0.0));
        commonCustomerBill.printBill();
    }
    static class Item {
        private String name;
        private double price;
        private double discount;
        public Item(String name, double price, double discount) {
            this.name = name;
            this.price = price;
            this.discount = discount;
        }
        public double getDiscountedPrice() {
            return price - discount;
        }
        public double getDiscount() {
            return discount;
        }
        public double getPrice() {
            return price;
        }
        public String getName() {
            return name;
        }

    }
    public static class commonBill extends Bill{
        public void addItem(Item item){
            items.add(new Item(item.getName(), item.getPrice(), 0.0));
        }
    }
    public static class Bill{

        public List<Item> items;

        public Bill() {
            this.items = new ArrayList<>();
        }
        public void addItem(Item item) {
            items.add(item);
        }
        public List<Item> getItems() {
            return items;
        }
        public double calculateTotal() {
            double total = 0.0;
            for (Item item : items) {
                total += item.getDiscountedPrice();
            }
            return total;
        }
        public void printBill() {
            double totalDiscount = 0;
            double totalAmount = 0;

            for (Item item : items) {
                double itemDiscount = item.getDiscount();
                double newPrise = item.getPrice() - itemDiscount;

                totalAmount += newPrise;
                totalDiscount += itemDiscount;

                System.out.println( item.getName() + ", Ціна: " + item.getPrice() + " грн, " +
                        "Знижка: " + itemDiscount + " грн, " +
                        "Сума зі знижкою: " + newPrise + " грн");
            }

            System.out.println("Сума кошика: " + totalAmount + " грн");
            System.out.println("Сума знижки: " + totalDiscount + " грн");
        }
    }

}