println "Print map"
def person = [name: 'John Doe', age: 32, email: 'johndoe@example.com']
println person
println "Name: ${person.name}"
println "Age: ${person['age']}"

// Adding a new key-value pair
person['phone'] = '123-456-7890'

println "\nUpdating an existing key"
// Updating an existing key
person.age = 33

println person

// Remove an entry by key
println "\nEmail removed"
person.remove('email')
println person

// Iterating over map entries
println "\nIterating over map entries"
person.each { key, value ->
    println "$key: $value"
}

// Using entrySet() for iteration
println "\nUsing entrySet() for iteration"
for (entry in person.entrySet()) {
    println "${entry.key}: ${entry.value}"
}

// Check if a key exists in the map
println "\nCheck if a key exists in the map"
if (person.containsKey('name')) {
    println "Name is present."
}

// Check if a value exists in the map
println "\nCheck if a value exists in the map"
if (person.containsValue(33)) {
    println "There is a person 33 years old."
}

// Filtering a map
println "\nFiltering a map"
def adults = person.findAll { entry ->
    entry.key == 'age' && entry.value >= 18
}
println adults

// Combining two maps
println "\nCombining two maps"
def additionalInfo = [occupation: 'Software Developer', country: 'USA']
person.putAll(additionalInfo)

println person

