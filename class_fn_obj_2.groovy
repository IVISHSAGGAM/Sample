// Print the size of serializable object
class Person implements Serializable {
    String name
    int age

    Person(String name, int age) {
        this.name = name
        this.age = age
    }
}

// Method to estimate the size of a serializable object
long estimateObjectSize(Serializable obj) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream()
    ObjectOutputStream oos = new ObjectOutputStream(baos)
    oos.writeObject(obj)
    oos.close()
    return baos.size() // This is the size in bytes
}

// Creating an instance of Person
Person person = new Person("John Doe", 30)

// Estimating the size of the person object
long size = estimateObjectSize(person)
println "Estimated size of the Person object is ${size} bytes"
