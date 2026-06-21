
public class OrderProcessor {
    public void calculateTotal(double amount) {
        double tax = amount * 0.13;
        double serviceFee = amount > 100 ? amount * 0.05 : 10;
        double discount = amount > 500 ? 50 : 0;
        double total = amount + tax + serviceFee - discount;

        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + tax);
        System.out.println("Service Fee: " + serviceFee);
        System.out.println("Discount: " + discount);
        System.out.println("Total: " + total);
    }
}
