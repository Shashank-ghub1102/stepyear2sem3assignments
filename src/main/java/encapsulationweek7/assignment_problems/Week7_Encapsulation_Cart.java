package encapsulationweek7.assignment_problems;

class Cart {
    private final double[] prices;
    private int itemCount;

    Cart(int capacity) {
        prices = new double[Math.max(0, capacity)];
    }

    public void addItem(double price) {
        if (price >= 0 && itemCount < prices.length) prices[itemCount++] = price;
    }

    public double getTotal() {
        double total = 0;
        for (int index = 0; index < itemCount; index++) total += prices[index];
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }
}

public class Week7_Encapsulation_Cart {
    public static void main(String[] args) {
        Cart cart = new Cart(5);
        cart.addItem(99.50);
        cart.addItem(40.00);
        System.out.println("Items: " + cart.getItemCount() + " | Total: " + cart.getTotal());
    }
}
