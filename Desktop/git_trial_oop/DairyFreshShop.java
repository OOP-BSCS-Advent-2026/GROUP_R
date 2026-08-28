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


    // Method 1: Display the price list using a loop
    public static void displayPriceList(String[] items, double[] prices) {

        System.out.println("==== DAIRYFRESH SHOP ====");
        System.out.println("PRICE LIST");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-15s UGX %.2f%n",
                    i + 1, items[i], prices[i]);
        }

        System.out.println();
    }

    }   


    
    
}
    

