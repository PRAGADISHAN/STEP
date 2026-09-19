class Cart {
    private double[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        prices = new double[capacity];
        count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count++] = price;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal()); // 500
        System.out.println(cart.getItemCount()); // 3
    }
}