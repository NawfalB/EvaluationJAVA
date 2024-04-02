package model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> products = new ArrayList<>();
    private double totalSalesTax = 0;
    private double totalAmount = 0;

    public void addProduct(Product product) {
        products.add(product);
        double tax = calculateTax(product);
        totalSalesTax += tax;
        totalAmount += product.getPrice() + tax;
    }

    public void printReceipt() {
        for (Product product : products) {
            System.out.println(product.getName() + " : " + String.format("%.2f", product.getPrice() + calculateTax(product)));
        }
        System.out.println("--------------------");
        System.out.println("Sales Taxes : " + String.format("%.2f", totalSalesTax));
        System.out.println("Total : " + String.format("%.2f", totalAmount));
    }

    private double calculateTax(Product product) {
        double tax = 0;
        if (!product.isExempt()) {
            tax += product.getPrice() * 0.10;
        }
        if (product.isImported()) {
            tax += product.getPrice() * 0.05;
        }
        return tax;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotalSalesTax(double totalSalesTax) {
        this.totalSalesTax = totalSalesTax;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
