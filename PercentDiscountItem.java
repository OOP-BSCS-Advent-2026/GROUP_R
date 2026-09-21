public class PercentDiscountItem extends Item{ // class for items with a percentage discount 
    
    private final int threshold;  //constant variable to hold the minimum quantity required to apply the discount.
    private final double percentOff; // constant variable to hold the percentage discount to be applied if the threshold is met.

    public PercentDiscountItem(String name, double price, int threshold, double percentOff) {//constructor to initialize the name, price, threshold, and percentOff.
        super(name, price); //calls the constructor of the parent class.

        this.threshold = threshold; //minimum quantity required to apply the discount.
        this.percentOff = percentOff; //percentage discount to be applied if the threshold is met.
    }

    @Override //overrides the calculateTotal method of the parent class to apply the percentage discount if the threshold is met.
    public double calculateTotal(int quantity) { //method to calculate the total cost of the item based on the quantity.
        double subtotal = super.calculateTotal(quantity);//calls the calculateTotal method of the parent class.

        if (quantity >= threshold) { //if the quantity is greater than or equal to the threshold, apply the percentage discount.
            subtotal = subtotal * (1 - percentOff / 100.0);//applies the percentage discount to the subtotal.
        }

        return subtotal; //returns the total cost of the item after applying the discount (if applicable).
    }

    @Override
    public String getDiscountDescription(int quantity) {
        if (quantity >= threshold) {
            return percentOff + "% discount applied";
        }

        return "No discount";
    }
}
