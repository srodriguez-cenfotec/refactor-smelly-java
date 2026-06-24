// Tópico 11: Modularidad violada
public class OrderSummaryPrinter {

    public void print(double amount, double tax, double serviceFee, double discount, double total) {
        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + tax);
        System.out.println("Service Fee: " + serviceFee);
        System.out.println("Discount: " + discount);
        System.out.println("Total: " + total);
    }
}
