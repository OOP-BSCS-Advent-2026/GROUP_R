public class Main { // main class.
    public static void main(String[] args) {  // main method.

        Item[] items = { // array of the different objects of the different classes.

            new PercentDiscountItem("Milk (litre)", 2500.00, 6, 5), //object 1
            new NoDiscountItem("Yogurt", 3000.00),                                        //object 2
            new FlatDiscountItem("Cheese", 8000.00, 3, 1000),       //object 3
            new PercentDiscountItem("Eggs (tray)", 12000.00, 4, 10)  //object 4
        };

        int[] quantities = {5, 2, 2, 4};  // array of the quantity of each item.

        double total = 0;                //initialise the total to zero.


      displayPriceList(items);   // calling the method to display the PriceList.

        

        for (int i = 0; i < items.length; i++) {
            double lineTotal = items[i].calculateTotal(quantities[i]);


           // Display discount only when it was actually applied
            if (items[i].getDiscountDescription(quantities[i]).equals("No discount")) {
                System.out.printf(
                    "%s x%d = UGX %.2f    (%s)%n\n",
                    items[i].getName(),
                    quantities[i],
                    lineTotal,
                    items[i].getDiscountDescription(quantities[i]) );
            }else {
                System.out.printf(
                    "%s x%d = UGX %.2f    (%s)%n\n",
                    items[i].getName(),
                    quantities[i],
                    lineTotal,
                    items[i].getDiscountDescription(quantities[i]) );
            }

            total += lineTotal;
        }
        System.out.println("==========================================");

        System.out.printf("TOTAL = UGX %.2f%n", total);
        System.out.println("==========================================");
    }
    

   public static void displayPriceList(Item[] items) {
     System.out.println("================== DAIRYFRESH SHOP ===================");
     System.out.println("==================== PRICE LIST ======================");

     for (int i = 0; i < items.length; i++) {
         System.out.printf("%d. %-15s UGX %.2f%n",
                i + 1,
                items[i].getName(),
                items[i].getPrice());
        }

     System.out.println("=======================================================");
     System.out.println();
    }
}

public class Item { // parent class for all items in the shop.

    private String name; // variable to hold the name of the item.
    private double price; // variable to hold the price of the item.

    public Item(String name, double price) {
        if (price <= 0) { // if the price is less than or equal to zero, throw an exception
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        this.name = name;
        this.price = price;
    }

    public String getName() { // an access modifier for accessing the name of the item.
        return name;
    }

    public double getPrice() { // an access modifier for accessing the price of the item.
        return price;
    }

    public double calculateTotal(int quantity) { // method to calculate the total cost of the item based on the quantity.

        if (quantity < 0) { // if the quantity is less than zero, throw an exception.
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

          // return the total cost of the item.
        return price * quantity; 
    }
          // method to get the discount description for the item. 
    public String getDiscountDescription(int quantity) { 
     return "No discount";
    }
} 
    


