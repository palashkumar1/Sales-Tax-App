Sales Tax Application

Overview

This application calculates sales tax for a shopping basket, applying basic sales tax and import duty according to specific rules. It handles different types of items, including exempt items and imported goods, and generates detailed receipts with tax breakdowns.

Features

Sales tax calculation: Calculates sales tax for different types of items.
Exempt items: Handles exempt items such as books, food, and medical products.
Import duty: Applies import duty for imported items.
Receipt generation: Produces detailed receipts showing item prices, taxes, and totals.

Tax Rules

Basic sales tax: 10% on all goods except exempt items.
Import duty: 5% on all imported goods, regardless of exemption status.
Exempt items: Books, food, and medical products are exempt from the basic sales tax.
Rounding: Tax is rounded up to the nearest 0.05.

Project Structure

model/Item.java: Abstract base class for items.
model/RegularItem.java: Concrete item implementation for regular items.
model/ExemptItem.java: Concrete item implementation for exempt items.
model/ImportedItem.java: Concrete item implementation for imported items.
service/TaxService.java: Handles tax calculations for items.
service/ReceiptPrinter.java: Generates formatted receipts for the shopping basket.
SalesTaxApp.java: Main application entry point for running the application.

Requirements

Java: Version 11 or higher
Spring Boot: 2.x or higher
JUnit: 5 for unit testing

Running the Application

Build with Maven

To build the project, use the following command:
mvn clean install

Run Tests

To run the tests, use the following command:
mvn test

Run Application

To run the application, use the following command:
mvn spring-boot:run


Example Usage

Here is an example of how to use the application:

List<Item> basket = new ArrayList<>();
basket.add(new RegularItem("book", 12.49, false));
basket.add(new RegularItem("music CD", 14.99, false));

TaxService taxService = new TaxService();
ReceiptPrinter receiptPrinter = new ReceiptPrinter(taxService);
receiptPrinter.printReceipt(basket);
This will generate a receipt for the items in the basket, including tax calculations and total amounts.

Test Cases Covered

The following test cases are covered:

Basic sales tax calculation for regular items.
Sales tax calculation for exempt items (books, food, and medical products).
Import duty calculation for imported items.
Combined tax scenarios (both sales tax and import duty).
Total price calculation including tax.
Exemption rule verification for books, food, and medical products.
Rounding Method
The tax is rounded up to the nearest 0.05 using the formula:

Math.ceil(amount * 20) / 20.0
This ensures that the tax amount is always rounded up to the nearest 0.05.

Extensibility

New item types: The application is easy to extend with new types of items (e.g., luxury items, discounted items).
Flexible exemption rules: You can modify the exemption rules to include additional categories as needed.
Dependency Injection: The TaxService is designed with dependency injection, making it easy to test and extend.
