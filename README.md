Sales Tax Application
Overview
This application calculates sales tax for a shopping basket, applying basic sales tax and import duty according to specific rules.
Features

Calculates sales tax for different types of items
Handles exempt items (books, food, medical products)
Applies import duty for imported items
Generates detailed receipts

Tax Rules

Basic sales tax: 10% on all goods except exempt items
Import duty: 5% on all imported goods
Exempt items: Books, food, medical products
Tax is rounded up to the nearest 0.05

Project Structure

model/Item.java: Abstract base class for items
model/RegularItem.java: Concrete item implementation
service/TaxService.java: Handles tax calculations
service/ReceiptPrinter.java: Generates receipts
SalesTaxApp.java: Main application entry point

Requirements

Java 11 or higher
Spring Boot 2.x
JUnit 5

Running the Application
Build with Maven
bashCopymvn clean install
Run Tests
bashCopymvn test
Run Application
bashCopymvn spring-boot:run
Example Usage
javaCopyList<Item> basket = new ArrayList<>();
basket.add(new RegularItem("book", 12.49, false));
basket.add(new RegularItem("music CD", 14.99, false));

TaxService taxService = new TaxService();
ReceiptPrinter receiptPrinter = new ReceiptPrinter(taxService);
receiptPrinter.printReceipt(basket);
Test Cases Covered

Basic sales tax calculation
Exempt item tax calculation
Import duty calculation
Combined tax scenarios
Total price calculation
Exemption rule verification

Rounding Method
Tax is rounded up to the nearest 0.05 using the formula:
CopyMath.ceil(amount * 20) / 20.0
Extensibility

Easy to add new item types
Flexible exemption rules
Dependency injection for tax calculator
