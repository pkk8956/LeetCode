package Design_Patterns.Architectural;

import java.util.*;

public class Repository {

    // ===== DOMAIN ENTITY =====
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

    // ===== REPOSITORY INTERFACE =====
    interface UserRepository {
        Optional<User> findById(Long id);
        Optional<User> findActiveByEmail(String email);
        List<User> findAllActive();
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
        public Optional<User> findActiveByEmail(String email) {
            return storage.values().stream()
                    .filter(u -> u.isActive() && u.getEmail().equals(email))
                    .findFirst();
        }

        @Override
        public List<User> findAllActive() {
            return storage.values().stream()
                    .filter(User::isActive)
                    .toList();
        }

        @Override
        public void save(User user) {
            storage.put(user.getId(), user);
        }
    }

    // ===== SERVICE (uses Repository) =====
    static class UserService {
        private final UserRepository repository;

        public UserService(UserRepository repository) {
            this.repository = repository;
        }

        public void register(User user) {
            repository.save(user);
        }

        public User getActiveUser(String email) {
            return repository.findActiveByEmail(email)
                    .orElseThrow();
        }
    }

    public static void main(String[] args) {
        UserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);

        service.register(new User(1L, "a@mail.com", true));
        service.register(new User(2L, "b@mail.com", false));

        User user = service.getActiveUser("a@mail.com");
        System.out.println(user.getEmail());
    }
}
