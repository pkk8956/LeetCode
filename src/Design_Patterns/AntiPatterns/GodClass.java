package Design_Patterns.AntiPatterns;

public class GodClass {
    // Data for users
    private String[] users = new String[100];
    private int userCount = 0;

    // Data for products
    private String[] products = new String[100];
    private int productCount = 0;

    // Add a user
    public void addUser(String name) {
        users[userCount++] = name;
    }

    // Add a product
    public void addProduct(String product) {
        products[productCount++] = product;
    }

    // Print users
    public void printUsers() {
        System.out.println("Users:");
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i]);
        }
    }

    // Print products
    public void printProducts() {
        System.out.println("Products:");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i]);
        }
    }

    // Calculate factorial (unrelated to users/products)
    public int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Main method
    public static void main(String[] args) {
        GodClass gc = new GodClass();

        gc.addUser("Alice");
        gc.addUser("Bob");

        gc.addProduct("Laptop");
        gc.addProduct("Phone");

        gc.printUsers();
        gc.printProducts();

        System.out.println("Factorial of 5 = " + gc.factorial(5));
    }
}

