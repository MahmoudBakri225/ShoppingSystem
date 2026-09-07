package com.mycompany.shoppingsystem;

public class Bill {

    private int billId;
    private Cart cart;
    private double totalAmount;

    
    // constactor
    public Bill(int billId, Cart cart) {
        this.billId = billId;
        this.cart = cart;
        this.totalAmount = cart.calculateTotal();
    }

    // getter
    public int getBillId() {
        return billId;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // setter
    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        this.totalAmount = cart.calculateTotal();
    }

    public void printBill() {
        System.out.println("----- Bill " + billId + " -----");

        for (Item item : cart.getItems()) {
            System.out.println(item.getName() + " x" + item.getQuantity() + " = " + item.getSubtotal());
        }

        System.out.println("Total = " + totalAmount);
    }

    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId + ", cart=" + cart + ", totalAmount=" + totalAmount + '}';
    }
}
