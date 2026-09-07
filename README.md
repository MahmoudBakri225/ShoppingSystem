# 🛒 Shopping System

> **Java OOP Assignment — Store Shopping & Billing System**

A simple **Java Object-Oriented Programming (OOP)** application that simulates a store shopping process. The system allows customers to manage shopping carts, add products with quantities and prices, calculate the total purchase amount, and generate a bill showing the purchased items and final amount to pay.

---

## 📌 Project Overview

The **Shopping System** is designed to demonstrate how real-world entities can be modeled using Java classes and Object-Oriented Programming concepts.

The system is built around **four required domain classes**:

* `Item`
* `Cart`
* `Bill`
* `Customer`

The application also contains a `ShoppingSystem` class that provides the `main()` method used to run and demonstrate the system.

### 🛍️ Main Workflow

```text
Customer
    │
    ├── Owns Carts
    │       │
    │       └── Contains Items
    │
    └── Owns Bills
            │
            └── Generated from Cart
                    │
                    └── Calculates Total
```

---

# 🎯 Objectives

The main objectives of this project are to:

* Apply Java OOP principles to a real-world scenario.
* Model customers, carts, products, and bills as objects.
* Demonstrate relationships between Java classes.
* Use `ArrayList` to manage collections.
* Calculate item subtotals and cart totals.
* Generate a bill from a shopping cart.
* Display customer and purchase information clearly.

---

# ✨ Features

* 👤 Create and manage customers.
* 🛒 Create shopping carts.
* 📦 Add multiple products to a cart.
* 💰 Store product prices.
* 🔢 Store product quantities.
* 🧮 Calculate item subtotals.
* 💵 Calculate the complete cart total.
* 🧾 Generate a bill from a cart.
* 📋 Display all purchased items.
* 👤 Display customer information.
* 🗂️ Store multiple carts using `ArrayList`.
* 🧾 Store multiple bills using `ArrayList`.
* ✅ Successfully build and run using Maven.

---

# 🏗️ System Architecture

```text
                         SHOPPING SYSTEM
                                │
                                ▼
                        ┌─────────────────┐
                        │    Customer     │
                        ├─────────────────┤
                        │ name            │
                        │ carts           │
                        │ bills           │
                        └───────┬─────────┘
                                │
                    ┌───────────┴───────────┐
                    │                       │
                    ▼                       ▼
             ┌─────────────┐         ┌─────────────┐
             │    Cart     │         │    Bill     │
             ├─────────────┤         ├─────────────┤
             │ cartId      │         │ billId      │
             │ customer    │         │ cart        │
             │ items       │         │ totalAmount │
             └──────┬──────┘         └──────┬──────┘
                    │                       │
                    ▼                       │
             ┌─────────────┐                │
             │    Item     │◄───────────────┘
             ├─────────────┤
             │ name        │
             │ price       │
             │ quantity    │
             └─────────────┘
```

---

# 🔗 Class Relationships

The project uses composition to connect the main classes.

```text
Customer
   │
   ├── ArrayList<Cart>
   │
   └── ArrayList<Bill>


Cart
   │
   ├── Customer
   │
   └── ArrayList<Item>


Bill
   │
   └── Cart
```

### Relationship Summary

| Class               | Relationship                    |
| ------------------- | ------------------------------- |
| `Customer` → `Cart` | Customer owns one or more carts |
| `Customer` → `Bill` | Customer owns one or more bills |
| `Cart` → `Customer` | Cart belongs to a customer      |
| `Cart` → `Item`     | Cart contains multiple items    |
| `Bill` → `Cart`     | Bill is created from a cart     |

---

# 📦 Class Design

## 1. `Item`

The `Item` class represents a product that can be purchased from the store.

### Attributes

```java
private String name;
private double price;
private int quantity;
```

### Methods

```java
Item(String name, double price, int quantity)

getName()
getPrice()
getQuantity()

setName(String name)
setPrice(double price)
setQuantity(int quantity)

getSubtotal()
```

### Responsibility

The class stores product information and calculates the subtotal based on price and quantity.

```text
Subtotal = Price × Quantity
```

---

## 2. `Cart`

The `Cart` class represents a customer's shopping cart.

### Attributes

```java
private int cartId;
private Customer customer;
private ArrayList<Item> items;
```

### Methods

```java
Cart(int cartId, Customer customer)

getCartId()
getCustomer()
getItems()

setCartId(int cartId)
setCustomer(Customer customer)
setItems(ArrayList<Item> items)

addItem(Item item)

calculateTotal()
```

### Composition

```text
Cart
 │
 ├── Customer
 │
 └── ArrayList<Item>
```

### Responsibility

The cart stores the items selected by the customer and calculates the total purchase amount.

---

## 3. `Bill`

The `Bill` class represents the final bill generated from a shopping cart.

### Attributes

```java
private int billId;
private Cart cart;
private double totalAmount;
```

### Methods

```java
Bill(int billId, Cart cart)

getBillId()
getCart()
getTotalAmount()

setBillId(int billId)
setCart(Cart cart)
setTotalAmount(double totalAmount)

printBill()
```

### Composition

```text
Bill
 │
 └── Cart
```

### Responsibility

The bill uses the customer's cart to display the purchased items and calculate the final amount to pay.

---

## 4. `Customer`

The `Customer` class represents a store customer.

### Attributes

```java
private String name;
private ArrayList<Cart> carts;
private ArrayList<Bill> bills;
```

### Methods

```java
Customer(String name)

getName()
getCarts()
getBills()

setName(String name)
setCarts(ArrayList<Cart> carts)
setBills(ArrayList<Bill> bills)

addCart(Cart cart)
addBill(Bill bill)
```

### Composition

```text
Customer
 │
 ├── ArrayList<Cart>
 │
 └── ArrayList<Bill>
```

### Responsibility

The customer stores their name and maintains their shopping carts and generated bills.

---

# 🧠 OOP Concepts Demonstrated

## 🔒 Encapsulation

All important attributes are declared as `private`.

Access is provided through public getters and setters.

Example:

```java
private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
```

This protects the internal state of each object and provides controlled access to its data.

---

## 🧩 Composition

Composition is used throughout the system to model relationships between objects.

### Customer → Carts

```java
ArrayList<Cart>
```

A customer can own multiple shopping carts.

### Customer → Bills

```java
ArrayList<Bill>
```

A customer can own multiple bills.

### Cart → Items

```java
ArrayList<Item>
```

A shopping cart contains multiple purchased items.

### Cart → Customer

```java
Customer customer
```

Each cart is associated with its customer.

### Bill → Cart

```java
Cart cart
```

Each bill is generated from a shopping cart.

---

# 🔄 System Workflow

The application follows this process:

```text
1. Create Customer
        ↓
2. Create Cart
        ↓
3. Assign Cart to Customer
        ↓
4. Create Items
        ↓
5. Add Items to Cart
        ↓
6. Calculate Cart Total
        ↓
7. Create Bill from Cart
        ↓
8. Add Bill to Customer
        ↓
9. Print Bill
        ↓
10. Display Final Amount
```

---

# 🧪 Example Scenario

The current implementation creates a customer named **Ahmed** and a shopping cart with ID `1`.

The cart is associated with Ahmed before products are added.

### Customer

```text
Name: Ahmed
Cart ID: 1
```

### Purchased Items

| Product   | Price | Quantity | Subtotal |
| --------- | ----: | -------: | -------: |
| Chips     |  10.0 |        2 |     20.0 |
| Water     |   5.0 |        3 |     15.0 |
| Chocolate |  15.0 |        1 |     15.0 |
| Juice     |  12.0 |        2 |     24.0 |
| **Total** |       |          | **74.0** |

The four products are created with their prices and quantities and then added to the cart.

---

# 🧮 Calculation

The subtotal of each item is calculated as:

```text
Chips      → 10.0 × 2 = 20.0
Water      → 5.0 × 3  = 15.0
Chocolate  → 15.0 × 1 = 15.0
Juice      → 12.0 × 2 = 24.0
```

Therefore:

```text
Total = 20.0 + 15.0 + 15.0 + 24.0

Total = 74.0
```

The application calculates the cart total before generating the bill.

---

# 🧾 Bill Generation

Once the cart has been completed, the application creates a bill from the cart:

```java
Bill bill = new Bill(1, cart);
```

The generated bill is then added to the customer's bills:

```java
ahmed.addBill(bill);
```

The bill displays all purchased items and the final total amount.

---

# 🖥️ Program Output

The application was successfully compiled and executed using **Apache NetBeans and Maven**.

```text
Customer Name: Ahmed

Cart ID: 1
Customer: Ahmed

----- Shopping Cart -----
Chips | Price: 10.0 | Quantity: 2 | Subtotal: 20.0
Water | Price: 5.0 | Quantity: 3 | Subtotal: 15.0
Chocolate | Price: 15.0 | Quantity: 1 | Subtotal: 15.0
Juice | Price: 12.0 | Quantity: 2 | Subtotal: 24.0

Total before checkout = 74.0

----- Bill 1 -----
Chips x2 = 20.0
Water x3 = 15.0
Chocolate x1 = 15.0
Juice x2 = 24.0
Total = 74.0

----- Customer Information -----
Name: Ahmed
Number of Carts: 1
Number of Bills: 1

Final Amount to Pay = 74.0

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 0.808 s
```

---

# 📊 Output Summary

| Information           |          Result |
| --------------------- | --------------: |
| Customer              |           Ahmed |
| Cart ID               |               1 |
| Number of Items       |               4 |
| Number of Carts       |               1 |
| Number of Bills       |               1 |
| Total Before Checkout |            74.0 |
| Bill Total            |            74.0 |
| Final Amount to Pay   |            74.0 |
| Build Status          | ✅ BUILD SUCCESS |

The main application also displays the number of carts and bills owned by the customer.

---

# 📁 Project Structure

```text
ShoppingSystem/
│
├── pom.xml
│
└── src/
    └── main/
        └── java/
            └── com/
                └── mycompany/
                    └── shoppingsystem/
                        │
                        ├── Item.java
                        ├── Cart.java
                        ├── Bill.java
                        ├── Customer.java
                        └── ShoppingSystem.java
```

### Main Entry Point

```text
ShoppingSystem.java
```

The `ShoppingSystem` class contains the `main()` method used to demonstrate the complete shopping workflow.

> `ShoppingSystem` is the application entry point and is separate from the four required domain classes.

---

# 💻 Technologies Used

| Technology          | Purpose                       |
| ------------------- | ----------------------------- |
| **Java**            | Application development       |
| **OOP**             | Object-oriented system design |
| **ArrayList**       | Managing collections          |
| **Maven**           | Build and project management  |
| **Apache NetBeans** | Development environment       |

---

# ▶️ How to Run

## Prerequisites

Before running the project, make sure you have:

* Java JDK installed
* Apache Maven installed
* Apache NetBeans, IntelliJ IDEA, or Eclipse

---

## Run with Maven

Open a terminal inside the project directory:

```bash
cd ShoppingSystem
```

Compile the project:

```bash
mvn clean compile
```

Run the application:

```bash
mvn exec:java
```

Alternatively, run:

```text
ShoppingSystem.java
```

directly from your IDE.

---

# ✅ Assignment Requirements

| Requirement                      | Status |
| -------------------------------- | ------ |
| `Item` class                     | ✅      |
| `Cart` class                     | ✅      |
| `Bill` class                     | ✅      |
| `Customer` class                 | ✅      |
| Item represents a product        | ✅      |
| Item stores name                 | ✅      |
| Item stores price                | ✅      |
| Item stores quantity             | ✅      |
| Cart belongs to a customer       | ✅      |
| Cart contains items              | ✅      |
| Bill is created from a cart      | ✅      |
| Bill calculates total amount     | ✅      |
| Customer stores a name           | ✅      |
| Customer owns carts              | ✅      |
| Customer owns bills              | ✅      |
| `ArrayList` used for collections | ✅      |
| Constructors implemented         | ✅      |
| Getters implemented              | ✅      |
| Setters implemented              | ✅      |
| Useful methods implemented       | ✅      |
| Composition clearly demonstrated | ✅      |

---

# 🎓 Learning Outcomes

Through this project, the following concepts are demonstrated:

* Java class design
* Object creation
* Constructors
* Getters and setters
* Encapsulation
* Composition
* Object relationships
* `ArrayList`
* Iterating through collections
* Calculations using object data
* Real-world object modeling
* Maven project structure
* Building a complete Java OOP application

---

# 🚀 Future Improvements

The current implementation satisfies the assignment requirements.

Possible future enhancements include:

* 🆔 Add unique product IDs.
* 📦 Add inventory and stock management.
* 💸 Add discounts and promotional codes.
* 🧾 Add tax calculation.
* 💳 Add different payment methods.
* 📅 Add invoice and purchase dates.
* 👥 Add customer IDs and additional customer information.
* 💾 Store data in a database.
* 🖥️ Add a graphical user interface.
* 🧪 Add automated unit tests.
* 📊 Add purchase history and reporting.

---

# 📌 Design Summary

The project can be summarized by the following object relationship:

```text
                     CUSTOMER
                        │
              ┌─────────┴─────────┐
              │                   │
              ▼                   ▼
            CART                 BILL
              │                   │
              │                   ▼
              │                  CART
              │
              ▼
            ITEMS
```

The complete business flow is:

```text
Customer
   ↓
Cart
   ↓
Items
   ↓
Calculate Subtotals
   ↓
Calculate Cart Total
   ↓
Generate Bill
   ↓
Final Amount to Pay
```

This structure keeps the system organized by giving each class a clear responsibility while using composition to connect the different objects.

---

# 👨‍💻 Author

**Mahmoud Bakri**

**Java | Object-Oriented Programming | Software Testing & Quality Assurance**

---

## 📄 License

This project was created for **educational purposes** as part of a Java Object-Oriented Programming assignment.
