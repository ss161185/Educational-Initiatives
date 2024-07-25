//Factory Pattern
//Use Case: Creating different types of animals without specifying the exact class.

// Product interface
interface Animal {
    void speak();
}

// Concrete products
class Dog implements Animal {
    public void speak() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meow");
    }
}

// Factory
class AnimalFactory {
    public static Animal createAnimal(String type) {
        switch (type) {
            case "Dog": return new Dog();
            case "Cat": return new Cat();
            default: throw new IllegalArgumentException("Unknown animal type");
        }
    }
}