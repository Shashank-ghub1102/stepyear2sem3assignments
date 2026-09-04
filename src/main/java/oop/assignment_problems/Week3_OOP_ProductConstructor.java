package oop.assignment_problems;

class Product {
    String productId;
    String productName;

    Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}

public class Week3_OOP_ProductConstructor {
    public static void main(String[] args) {
        Product product = new Product("P-1042", "Wireless Mouse");
        System.out.println(product.productId + " - " + product.productName);
    }
}
