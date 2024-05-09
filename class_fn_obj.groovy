// The constructor example
class Person {
    // Properties
    String name
    int age

    // Constructor to initialize the properties
    Person(String name, int age) {
        this.name = name
        this.age = age
    }

    // Method to display person's information
    void displayInfo() {
        println "Name: ${name}, Age: ${age}"
    }
}

static void main(String[] args) {
    // Creating an object of the Person class
    Person person = new Person("John Doe", 30)

    // Calling the method to display person's information
    person.displayInfo()

}
