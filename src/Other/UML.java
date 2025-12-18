package Other;

// UML Diagram Representation

/*User
--------------------
- id: long
- email: String
--------------------
+ getEmail(): String

Admin
--------------------
- role: String
--------------------
+ getRole(): String

UserService
--------------------
+ createUser(email: String): User
 */

public class UML {

    class User {
        private long id;
        private String email;

        public User(long id, String email) {
            this.id = id;
            this.email = email;
        }

        public String getEmail() {
            System.out.println("Getting email: " + email + " for user ID: " + id);
            return email;
        }
    }

    class Admin extends User {
        private String role;

        public Admin(long id, String email, String role) {
            super(id, email);
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

    public class UserService {
        public User createUser(String email) {
            return new User(1L, email);
        }
    }
    
}



