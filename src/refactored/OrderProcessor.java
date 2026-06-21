
public class OrderProcessor {

    public static final double TAX_PERCENTAGE = 0.13;

    public static final double SERVICE_FEE_PERCENTAGE = 0.05;

    public static final int DEFAULT_SERVICE_FEE = 10;

    public static final int DEFAULT_DISCOUNT = 0;

    public static final int SERVICE_FEE_MIN_AMOUNT = 100;

    public static final int DISCOUNT_MIN_AMOUNT = 500;

    public static final int FIXED_DISCOUNT = 50;


    public void calculateTotal(double amount) {
        double tax = amount * TAX_PERCENTAGE;
        double serviceFee = amount > SERVICE_FEE_MIN_AMOUNT ? amount * SERVICE_FEE_PERCENTAGE : DEFAULT_SERVICE_FEE;
        double discount = amount > DISCOUNT_MIN_AMOUNT ? FIXED_DISCOUNT : DEFAULT_DISCOUNT;
        double total = amount + tax + serviceFee - discount;

        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + tax);
        System.out.println("Service Fee: " + serviceFee);
        System.out.println("Discount: " + discount);
        System.out.println("Total: " + total);
    }
}
