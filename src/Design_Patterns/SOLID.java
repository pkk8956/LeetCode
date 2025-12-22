package Design_Patterns;

// solid.java

// S - Single Responsibility Principle (SRP)
// Each class has only one reason to change
class Report {
    private String content;

    public Report(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Responsibility for saving report
class ReportPersistence {
    public void saveToFile(Report report) {
        System.out.println("Saving report: " + report.getContent());
    }
}

// O - Open/Closed Principle (OCP)
// Class should be open for extension, closed for modification
interface Formatter {
    String format(String text);
}

class HtmlFormatter implements Formatter {
    public String format(String text) {
        return "<html>" + text + "</html>";
    }
}

class JsonFormatter implements Formatter {
    public String format(String text) {
        return "{ \"report\": \"" + text + "\" }";
    }
}

// L - Liskov Substitution Principle (LSP)
// Subtypes must be substitutable for their base types
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }
}

class Ostrich extends Bird {
    // Ostrich cannot fly, so we override carefully
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly!");
    }
}

// Better: separate Flyable interface
interface Flyable {
    void fly();
}

class Eagle implements Flyable {
    public void fly() {
        System.out.println("Eagle flying");
    }
}

// I - Interface Segregation Principle (ISP)
// Prefer many small interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    public void work() {
        System.out.println("Working...");
    }

    public void eat() {
        System.out.println("Eating...");
    }
}

class RobotWorker implements Workable {
    public void work() {
        System.out.println("Robot working...");
    }
}

// D - Dependency Inversion Principle (DIP)
// High-level modules should not depend on low-level modules
// Both should depend on abstractions
interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class Notification {
    private MessageService service;

    public Notification(MessageService service) {
        this.service = service; // dependency injected
    }

    public void send(String message) {
        service.sendMessage(message);
    }
}

// Client code
public class SOLID {
    public static void main(String[] args) {
        // SRP
        Report report = new Report("SOLID report");
        ReportPersistence persistence = new ReportPersistence();
        persistence.saveToFile(report);

        // OCP
        Formatter htmlFormatter = new HtmlFormatter();
        Formatter jsonFormatter = new JsonFormatter();
        System.out.println(htmlFormatter.format(report.getContent()));
        System.out.println(jsonFormatter.format(report.getContent()));

        // LSP
        Bird sparrow = new Sparrow();
        sparrow.fly();

        Flyable eagle = new Eagle();
        eagle.fly();

        // ISP
        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();
        human.work(); human.eat();
        robot.work();

        // DIP
        MessageService emailService = new EmailService();
        Notification notification = new Notification(emailService);
        notification.send("Hello SOLID!");
    }
}

