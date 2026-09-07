package com.mycompany.shoppingsystem;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int cartId;
    private Customer customer;
    private ArrayList<Item> items;

    // constactor
    public Cart(int cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    // getter
    public int getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    // setter
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0;

        for (Item item : items) {
            total = total + item.getSubtotal();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartId=" + cartId + ", customer=" + customer + ", items=" + items + '}';
    }
}
