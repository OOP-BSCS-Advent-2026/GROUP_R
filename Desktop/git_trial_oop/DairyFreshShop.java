 public class DairyFreshShop {

    public static void main(String[] args) {

        // Store item names and prices in arrays
        String[] items = {"Milk (litre)", "Yogurt", "Cheese", "Eggs (tray)"};
        double[] prices = {2500.00, 3000.00, 8000.00, 12000.00};

        // Customer quantities
        int[] quantities = {5, 2, 2, 4};
      // Display the shop price list
        displayPriceList(items, prices);

        // Calculate the discounted subtotal for each item
        double[] subtotals = new double[items.length];

        for (int i = 0; i < items.length; i++) {
            subtotals[i] = calculateSubtotal(
                    items[i],
                    prices[i],
                    quantities[i]
            );
        }

        // Print the receipt and grand total
        printReceipt(items, prices, quantities, subtotals);
    }

//This is method one  that displays the prices of our products
public static void displaypriceList(String[] items, double[] prices) {
    System.out.println("====DAILYFRESH SHOP ====");
    System.out.println("PRICE LIST");


    for (int i = 0; i < items.length; i++) {
        System.out.printf("%d. %-15s UGX %.2f%n",
                i + 1, items[i], prices[i]);
    }

    System.out.println();//My method ends here
}


    
    
}
//Method 2: Calculate the subtotal and apply the correct discount
    public static double calculateSubtotal(String item, double price, int quantity) {

        // Calculate the original subtotal
        double subtotal = price * quantity;

        // Milk: 5% discount when buying 6 or more
        if (item.equals("Milk (litre)") && quantity >= 6) {
            subtotal = subtotal * 0.95;
        }

        // Yogurt: Never discounted
        else if (item.equals("Yogurt")) {
            subtotal = subtotal;
        }

        // Cheese: UGX 1,000 off when buying 3 or more
        else if (item.equals("Cheese") && quantity >= 3) {
            subtotal = subtotal - 1000;
        }

        // Eggs: 10% discount when buying 4 or more
        else if (item.equals("Eggs (tray)") && quantity >= 4) {
            subtotal = subtotal * 0.90;
        }

        return subtotal;
    }


    // Method 3: Print the itemised receipt
    public static void printReceipt(String[] items,
                                    double[] prices,
                                    int[] quantities,
                                    double[] subtotals) {

        System.out.println("==== RECEIPT==== ");

        double grandTotal = 0;

        // Loop through all four items
       for (int i = 0; i < items.length; i++) {

        // Milk discount conditions
        if (items[i].equals("Milk (litre)")) {

            if (quantities[i] >= 6) {
                System.out.printf("%-15s x%d = UGX %.2f (5%% discount applied: bought 6 or more litres)%n",
                        items[i], quantities[i], subtotals[i]);
            } else {
                System.out.printf("%-15s x%d = UGX %.2f (No discount: bought less than 6 litres)%n",
                        items[i], quantities[i], subtotals[i]);
            }
        }
         // Yogurt discount conditions
        else if (items[i].equals("Yogurt")) {

            System.out.printf("%-15s x%d = UGX %.2f (No discount: Yogurt is never discounted)%n",
                    items[i], quantities[i], subtotals[i]);
        }
        // Cheese discount conditions
        else if (items[i].equals("Cheese")) {

            if (quantities[i] >= 3) {
                System.out.printf("%-15s x%d = UGX %.2f (UGX 1,000 discount applied: bought 3 or more)%n",
                        items[i], quantities[i], subtotals[i]);
            } else {
                System.out.printf("%-15s x%d = UGX %.2f (No discount: bought less than 3)%n",
                        items[i], quantities[i], subtotals[i]);
            }
        }

        // Eggs discount conditions
        else if (items[i].equals("Eggs (tray)")) {

            if (quantities[i] >= 4) {
                System.out.printf("%-15s x%d = UGX %.2f (10%% discount applied: bought 4 or more trays)%n",
                        items[i], quantities[i], subtotals[i]);
            } else {
                System.out.printf("%-15s x%d = UGX %.2f (No discount: bought less than 4 trays)%n",
                        items[i], quantities[i], subtotals[i]);
            }
        }

        // Add subtotal to grand total
        grandTotal += subtotals[i];
    }

        System.out.println("  .....  ");
        System.out.printf("TOTAL          = UGX %.2f%n", grandTotal);
    }


    
}// This is the last of the code
    

