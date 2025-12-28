package Design_Patterns.Architectural;

import java.util.*;

public class ServiceLayer {

    // ===== ENTITY =====
    static class User {
        private Long id;
        private String email;
        private boolean active;

        public User(Long id, String email, boolean active) {
            this.id = id;
            this.email = email;
            this.active = active;
        }

        public Long getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public boolean isActive() {
            return active;
        }
    }

    // ===== REPOSITORY =====
    interface UserRepository {
        Optional<User> findById(Long id);
        Optional<User> findByEmail(String email);
        void save(User user);
    }

    // ===== REPOSITORY IMPLEMENTATION =====
    static class InMemoryUserRepository implements UserRepository {

        private final Map<Long, User> storage = new HashMap<>();

        @Override
        public Optional<User> findById(Long id) {
            return Optional.ofNullable(storage.get(id));
        }

        @Override
        public Optional<User> findByEmail(String email) {
            return storage.values().stream()
                    .filter(u -> u.getEmail().equals(email))
                    .findFirst();
        }

        @Override
        public void save(User user) {
            storage.put(user.getId(), user);
        }
    }

    // ===== SERVICE LAYER =====
    static class UserService {

        private final UserRepository repository;

        public UserService(UserRepository repository) {
            this.repository = repository;
        }

        public void register(Long id, String email) {
            if (repository.findByEmail(email).isPresent()) {
                throw new IllegalStateException("Email already exists");
            }

            User user = new User(id, email, true);
            repository.save(user);
        }

        public void deactivate(Long id) {
            User user = repository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("User not found"));

            User updated = new User(user.getId(), user.getEmail(), false);
            repository.save(updated);
        }

        public User getActiveUser(String email) {
            User user = repository.findByEmail(email)
                    .orElseThrow(() -> new IllegalStateException("Not found"));

            if (!user.isActive()) {
                throw new IllegalStateException("User inactive");
            }

            return user;
        }
    }

    // ===== CONTROLLER (simulation) =====
    static class UserController {

        private final UserService service;

        public UserController(UserService service) {
            this.service = service;
        }

        public void register(String email) {
            service.register(new Random().nextLong(), email);
        }

        public void show(String email) {
            User user = service.getActiveUser(email);
            System.out.println("User: " + user.getEmail());
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        UserRepository repository = new InMemoryUserRepository();
        UserService service = new UserService(repository);
        UserController controller = new UserController(service);

        controller.register("a@mail.com");
        controller.register("b@mail.com");

        controller.show("a@mail.com");
    }
}
