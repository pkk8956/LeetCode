package Design_Patterns.Architectural;

public class MVC {

    // ===== MODEL =====
    static class UserModel {
        private String name;

        public UserModel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // ===== VIEW =====
    static class UserView {
        public void showUser(String name) {
            System.out.println("User name: " + name);
        }
    }

    // ===== CONTROLLER =====
    static class UserController {
        private UserModel model;
        private UserView view;

        public UserController(UserModel model, UserView view) {
            this.model = model;
            this.view = view;
        }

        public void setUserName(String name) {
            model.setName(name);
        }

        public String getUserName() {
            return model.getName();
        }

        public void updateView() {
            view.showUser(model.getName());
        }
    }

    public static void main(String[] args) {
        UserModel model = new UserModel("Alex");
        UserView view = new UserView();
        UserController controller = new UserController(model, view);

        controller.updateView();

        controller.setUserName("John");
        controller.updateView();
    }
}
