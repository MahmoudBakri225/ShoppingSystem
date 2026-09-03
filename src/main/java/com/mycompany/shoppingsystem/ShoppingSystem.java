/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.shoppingsystem;

/**
 *
 * @author KA
 */
public class ShoppingSystem {

    public static void main(String[] args) {

        // Create Customer
        Customer ahmed = new Customer("Ahmed");

        // Display customer name
        System.out.println("Customer Name: " + ahmed.getName());
        System.out.println();

        // Create Shopping Cart
        Cart cart = new Cart(1, ahmed);

        // Add cart to customer
        ahmed.addCart(cart);

        // Display cart information
        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Customer: " + cart.getCustomer().getName());
        System.out.println();

        // Create Items
        Item chips = new Item("Chips", 10.0, 2);
        Item water = new Item("Water", 5.0, 3);
        Item chocolate = new Item("Chocolate", 15.0, 1);
        Item juice = new Item("Juice", 12.0, 2);

        // Add items to the cart
        cart.addItem(chips);
        cart.addItem(water);
        cart.addItem(chocolate);
        cart.addItem(juice);

        // Display cart items
        System.out.println("----- Shopping Cart -----");

        for (Item item : cart.getItems()) {
            System.out.println(
                    item.getName()
                    + " | Price: " + item.getPrice()
                    + " | Quantity: " + item.getQuantity()
                    + " | Subtotal: " + item.getSubtotal()
            );
        }

        // Calculate total
        System.out.println();
        System.out.println("Total before checkout = "
                + cart.calculateTotal());

        // Create Bill from Cart
        Bill bill = new Bill(1, cart);

        // Add bill to customer
        ahmed.addBill(bill);

        // Display Bill
        System.out.println();
        bill.printBill();

        // Display customer information
        System.out.println();
        System.out.println("----- Customer Information -----");
        System.out.println("Name: " + ahmed.getName());
        System.out.println("Number of Carts: "
                + ahmed.getCarts().size());
        System.out.println("Number of Bills: "
                + ahmed.getBills().size());

        // Display final total
        System.out.println();
        System.out.println("Final Amount to Pay = "
                + bill.getTotalAmount());
    }
}


//The code is a Shopping System built using Java and OOP. It manages the Customer, Cart, Items, and Bill. The customer can have a shopping cart, add items with their prices and quantities, calculate the total amount, and create a bill that displays the purchased items and the final total. It also uses ArrayList to store the customer's carts and bills.
