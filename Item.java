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
    

