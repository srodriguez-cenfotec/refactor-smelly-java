// Tópico 11: Modularidad violada - clase con única responsabilidad de imprimir el resumen de una orden
public class OrderSummaryPrinter {

    public void print(double amount, double tax, double serviceFee, double discount, double total) {
        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + tax);
        System.out.println("Service Fee: " + serviceFee);
        System.out.println("Discount: " + discount);
        System.out.println("Total: " + total);
    }
}
