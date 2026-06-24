
public class OrderProcessor {

    public static final double TAX_PERCENTAGE = 0.13;
    public static final double SERVICE_FEE_PERCENTAGE = 0.05;
    public static final int DEFAULT_SERVICE_FEE = 10;
    public static final int DEFAULT_DISCOUNT = 0;
    public static final int SERVICE_FEE_MIN_AMOUNT = 100;
    public static final int DISCOUNT_MIN_AMOUNT = 500;
    public static final int FIXED_DISCOUNT = 50;

    // Tópico 11: Modularidad violada - delega la impresión a una clase con esa única responsabilidad
    private final OrderSummaryPrinter summaryPrinter = new OrderSummaryPrinter();

    public void calculateTotal(double amount) {
        double tax = calculateTax(amount);
        double serviceFee = calculateServiceFee(amount);
        double discount = calculateDiscount(amount);
        double total = amount + tax + serviceFee - discount;

        summaryPrinter.print(amount, tax, serviceFee, discount, total);
    }

    private double calculateTax(double amount) {
        return amount * TAX_PERCENTAGE;
    }

    private double calculateServiceFee(double amount) {
        return amount > SERVICE_FEE_MIN_AMOUNT ? amount * SERVICE_FEE_PERCENTAGE : DEFAULT_SERVICE_FEE;
    }

    private double calculateDiscount(double amount) {
        return amount > DISCOUNT_MIN_AMOUNT ? FIXED_DISCOUNT : DEFAULT_DISCOUNT;
    }
}
