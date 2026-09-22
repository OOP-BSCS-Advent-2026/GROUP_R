 public class FlatDiscountItem extends Item { // subclass of Item

    private final int threshold; // a constant variable that holds the minimum quantity required to apply the discount.
    private final double flatAmount;// a constant variable that holds the flat discount amount to be applied if the threshold is met.

    public FlatDiscountItem(String name, double price, int threshold, double flatAmount) {// constructor that initializes the name, price, threshold, and flatAmount.
        super(name, price);// calls the constructor of the parent class.

        this.threshold = threshold; // minimum quantity required to apply the discount.
        this.flatAmount = flatAmount;// flat discount amount to be applied if the threshold is met.
    }

    @Override
    public double calculateTotal(int quantity) {
        double subtotal = super.calculateTotal(quantity);

        if (quantity >= threshold) {
            subtotal = Math.max(0, subtotal - flatAmount); // applies the flat discount if the threshold is met.
        }

        return subtotal;
    }

   @Override
    public String getDiscountDescription(int quantity) {
        if (quantity >= threshold) {
            return "UGX " + flatAmount + " removed so the "+" discount applied";
        }

        return "No discount";
    }
} 
