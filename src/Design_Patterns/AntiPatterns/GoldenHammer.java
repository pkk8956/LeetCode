package Design_Patterns.AntiPatterns;

public class GoldenHammer {
    public static void main(String[] args) {
        // We need to store a list of user names
        // The developer decides to use a fixed-size array of 100 elements
        String[] users = new String[100];

        // Adding users
        users[0] = "Alice";
        users[1] = "Bob";
        users[2] = "Charlie";

        // Trying to remove user "Bob"
        // But arrays cannot dynamically remove elements, so we hack it
        for (int i = 0; i < users.length; i++) {
            if ("Bob".equals(users[i])) {
                users[i] = null;
            }
        }

        // Printing all users
        System.out.println("Users:");
        for (String user : users) {
            if (user != null) {
                System.out.println(user);
            }
        }

        // Adding another user, filling "empty" slots manually
        users[1] = "David"; // hacky solution
        System.out.println("After adding David:");
        for (String user : users) {
            if (user != null) {
                System.out.println(user);
            }
        }

        // All of this is for a simple task of storing a user list,
        // even though ArrayList would be much simpler and cleaner
    }
}
