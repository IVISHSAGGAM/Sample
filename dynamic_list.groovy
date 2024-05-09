// Create an empty list
def items = []

println "Enter items and type 'exit' when finished:"

while(true) {
    def input = System.console().readLine('Enter item: ').trim()
    if (input.equalsIgnoreCase('exit') || input.trim().isEmpty()) {
        break // Exit the loop if user types 'exit'
    } else {
        items << input // Add input to the list
    }
}

println "\nYou've entered the following items:"
items.each { item ->
    println "- $item"
}
