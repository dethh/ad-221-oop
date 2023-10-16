package lb2;
class Item {
    private String name;
    private float price;

    public Item(String name, float initialPrice) {
        this.name = name;
        if (initialPrice < 0) {
            this.price = 0;
        } else {
            this.price = initialPrice;
        }
    }

    public void increasePrice(float percent) {
        if (percent > 0) {
            this.price += this.price * percent / 100;
        }
    }

    public void decreasePrice(float percent) {
        if (percent > 0) {
            this.price -= this.price * percent / 100;
            if (this.price < 0) {
                this.price = 0;
            }
        }
    }

    public float getPrice() {
        return price;
    }
}

class Cart {
    private Item[] items;
    private int top; // индекс вершины стека
    private int maxSize; // максимальное количество элементов в стеке

    public Cart(int maxSize) {
        this.maxSize = maxSize;
        items = new Item[maxSize];
        top = -1; // исходно стек пуст
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(Item item) {
        if (!isFull()) {
            items[++top] = item;
        } else {
            System.out.println("Корзина переполнена. Нельзя добавить больше товаров.");
        }
    }

    public Item extraction() {
        if (!isEmpty()) {
            return items[top--];
        } else {
            System.out.println("Корзина пуста. Нельзя извлечь товар.");
            return null;
        }
    }

    public float calculateTotalPrice() {
        float total = 0;
        for (int i = 0; i <= top; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public void increasePricesInCart(float percent) {
        for (int i = 0; i <= top; i++) {
            items[i].increasePrice(percent);
        }
    }

    public void decreasePricesInCart(float percent) {
        for (int i = 0; i <= top; i++) {
            items[i].decreasePrice(percent);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart(10); // Максимальное количество элементов в корзине

        Item item1 = new Item("Товар 1", 50.0f);
        Item item2 = new Item("Товар 2", 30.0f);
        Item item3 = new Item("Товар 3", 20.0f);

        cart.push(item1);
        cart.push(item2);
        cart.push(item3);

        float totalPrice = cart.calculateTotalPrice();
        System.out.println("Сумма цен товаров в корзине: " + totalPrice);

        cart.increasePricesInCart(15);
        float newTotalPrice1 = cart.calculateTotalPrice();
        System.out.println("Измененная сумма цен после повышения на 15%: " + newTotalPrice1);

        cart.decreasePricesInCart(30);
        float newTotalPrice2 = cart.calculateTotalPrice();
        System.out.println("Измененная сумма цен после снижения на 30%: " + newTotalPrice2);
    }
}
