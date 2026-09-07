package com.mycompany.shoppingsystem;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Cart> carts;
    private ArrayList<Bill> bills;

    // constactor
    public Customer(String name) {
        this.name = name;
        this.carts = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    // getter
    public String getName() {
        return name;
    }

    public ArrayList<Cart> getCarts() {
        return carts;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + '}';
    }
}
