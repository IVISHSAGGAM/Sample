println "Basic Try-Catch"
try {
    // Code that might throw an exception
    int result = 10 / 0
} catch (ArithmeticException e) {
    // Handle the specific exception
    println "Cannot divide by zero: ${e.message}"
}
catch (Exception e) {
    // Handle the specific exception
    println "${e.message}"
}

println "\nCatching Multiple Exceptions"
try {
    // Code that might throw different types of exceptions
    int[] numbers = [1, 2, 3]
    int result = numbers[3] // This will throw an IndexOutOfBoundsException
} catch (ArithmeticException | IndexOutOfBoundsException e) {
    // Handle both exceptions here
    println "An error occurred: ${e.message}"
}

println "\nFinally Block"
try {
    // Code that might throw an exception
    int result = 10 / 2
    println "$result"
} catch (Exception e) {
    // Handle exception
    println "An error occurred: ${e.message}"
} finally {
    // Code here is always executed
    println "This is the finally block."
}

println "\nGroovy's Exception Handling Enhancements"
List<Integer> numbers = [1, 2, 3, 4, 5]
numbers.each { number ->
    if (number > 3) {
        throw new Exception("Number exceeds limit")
    }
    println number
}
