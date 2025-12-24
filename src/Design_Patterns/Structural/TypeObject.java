package Design_Patterns.Structural;

class ProductType {
    private String name;
    private double taxRate;

    public ProductType(String name, double taxRate) {
        this.name = name;
        this.taxRate = taxRate;
    }

    public double calculateTax(double price) {
        return price * taxRate;
    }

    public String getName() {
        return name;
    }
}

class Product {
    private String name;
    private double price;
    private ProductType type; 

    public Product(String name, double price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public void printInfo() {
        System.out.println("Product: " + name + 
                           ", Type: " + type.getName() + 
                           ", Price: " + price + 
                           ", Tax: " + type.calculateTax(price));
    }
}

public class TypeObject {
    public static void main(String[] args) {
        ProductType bookType = new ProductType("Book", 0.05);
        ProductType electronicsType = new ProductType("Electronics", 0.2);

        Product p1 = new Product("Java Book", 100, bookType);
        Product p2 = new Product("Laptop", 1000, electronicsType);

        p1.printInfo(); 
        p2.printInfo(); //
    }
}
