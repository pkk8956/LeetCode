package Design_Patterns;

// OOP.java

// 1. Encapsulation
// Hiding internal state and providing getters/setters
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) this.age = age; // simple validation
    }
}

// 2. Abstraction
// Hiding implementation details via abstract class or interface
abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses
    public abstract void makeSound();

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// 3. Inheritance
// Reusing code via subclassing
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// 4. Polymorphism
// Ability to treat objects of different subclasses uniformly
class OOPDemo {
    public static void main(String[] args) {
        // Encapsulation
        Person person = new Person("Alice", 30);
        System.out.println("Person: " + person.getName() + ", Age: " + person.getAge());
        person.setAge(31);
        System.out.println("Updated Age: " + person.getAge());

        System.out.println();

        // Abstraction + Inheritance + Polymorphism
        Animal dog = new Dog("Buddy");   // abstract type reference
        Animal cat = new Cat("Whiskers");

        // Polymorphism: same method call, different behavior
        Animal[] animals = {dog, cat};
        for(Animal animal : animals) {
            animal.makeSound(); // calls Dog/Cat implementation
            animal.sleep();     // calls shared method from Animal
            System.out.println();
        }
    }
}
