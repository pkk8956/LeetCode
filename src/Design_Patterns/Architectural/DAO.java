package Design_Patterns.Architectural;

// Java program to illustrate Data Access Object Pattern

// Importing required classes 
import java.util.ArrayList;
import java.util.List;

// Class 1
// Helper class
class Developer {

    private String name;
    private int DeveloperId;

    // Constructor of Developer class
    Developer(String name, int DeveloperId)
    {
        // This keyword refers to current instance itself
        this.name = name;
        this.DeveloperId = DeveloperId;
    }

    // Method 1
    public String getName() { return name; }

    // Method 2
    public void setName(String name) { this.name = name; }

    // Method 3
    public int getDeveloperId() { return DeveloperId; }

    // Method 4
    public void setDeveloperId(int DeveloperId)
    {
        this.DeveloperId = DeveloperId;
    }
}

// Interface
interface DeveloperDao {
    public List<Developer> getAllDevelopers();
    public Developer getDeveloper(int DeveloperId);
    public void updateDeveloper(Developer Developer);
    public void deleteDeveloper(Developer Developer);
}

// Class 2
// Implementing above defined interface
class DeveloperDaoImpl implements DeveloperDao {

    List<Developer> Developers;

    // Method 1
    public DeveloperDaoImpl()
    {
        Developers = new ArrayList<Developer>();
        Developer Developer1 = new Developer("Kushagra", 0);
        Developer Developer2 = new Developer("Vikram", 1);
        Developers.add(Developer1);
        Developers.add(Developer2);
    }

    // Method 2
    @Override
    public void deleteDeveloper(Developer Developer)
    {
        Developers.remove(Developer.getDeveloperId());
        System.out.println("DeveloperId "
                           + Developer.getDeveloperId()
                           + ", deleted from database");
    }

    // Method 3
    @Override public List<Developer> getAllDevelopers()
    {
        return Developers;
    }

    // Method 4
    @Override public Developer getDeveloper(int DeveloperId)
    {
        return Developers.get(DeveloperId);
    }

    // Method 5
    @Override
    public void updateDeveloper(Developer Developer)
    {
        Developers.get(Developer.getDeveloperId())
            .setName(Developer.getName());
        System.out.println("DeveloperId "
                           + Developer.getDeveloperId()
                           + ", updated in the database");
    }
}

// Class 3
// DaoPatternDemo
public class DAO {

    // Main driver method
    public static void main(String[] args)
    {

        DeveloperDao DeveloperDao = new DeveloperDaoImpl();

        for (Developer Developer :
             DeveloperDao.getAllDevelopers()) {
            System.out.println("DeveloperId : "
                               + Developer.getDeveloperId()
                               + ", Name : "
                               + Developer.getName());
        }

        Developer Developer
            = DeveloperDao.getAllDevelopers().get(0);

        Developer.setName("Lokesh");
        DeveloperDao.updateDeveloper(Developer);

        DeveloperDao.getDeveloper(0);
        System.out.println(
            "DeveloperId : " + Developer.getDeveloperId()
            + ", Name : " + Developer.getName());
    }
}
