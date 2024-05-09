// Define a static list of names
def staticList = ['Python', 'Groovy', 'Ruby', 'HTML']

// Iterate over the list and print each name
println "Static list contents:"
staticList.each { name ->
    println name
}


//=====================================

// Define an empty dynamic list
def dynamicList = []

// Adding elements to the list based on some logic
dynamicList << 'Groovy' // Using the shorthand append operator
dynamicList.add('Ruby') // Using the add method to append an item
println dynamicList

// Adding multiple elements without conditional logic
dynamicList += ['Python', 'HTML'] // Adding multiple elements directly
println dynamicList

// Removing an element
dynamicList.remove('HTML')

// Iterating over the dynamic list to print its contents
println "Dynamic list contents:"
dynamicList.each { name ->
    println name
}

//=====================================

// Define a list of numbers
def numbers = [5, 3, 9, 1, 7]

// contains(): Check if the list contains a specific element
println "Contains 3? ${numbers.contains(3)}"

// get(): Retrieve the element at a specific index
println "Element at index 2: ${numbers.get(2)}"

// isEmpty(): Check if the list is empty
println "Is the list empty? ${numbers.isEmpty()}"


// minus(): Create a new list by removing specific elements
def withoutNine = numbers.minus(9)
println "List without 9: $withoutNine"

// plus(): Create a new list by adding elements
def plusNumbers = numbers.plus(11)
println "List plus 11: $plusNumbers"

// pop(): Removes and returns the last element of the list
def lastElement = numbers.pop()
println "Popped element: $lastElement"
println "List after pop: $numbers"

// reverse(): Returns a new list with elements in reversed order
def reversedNumbers = numbers.reverse()
println "Reversed list: $reversedNumbers"

// size(): Returns the number of elements in the list
println "Size of the list: ${numbers.size()}"

// sort(): Returns a new list with elements sorted
def sortedNumbers = numbers.sort()
println "Sorted list: $sortedNumbers"

