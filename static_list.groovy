// Define a static list of elements
def languages = ['python', 'groovy', 'ruby', 'html', 'go-lang']

// Prompt the user for an element to search
println "Enter a language to search for:"
def input = System.console().readLine().trim().toLowerCase().toLowerCase()

// Search for the element in the list
if (languages.contains(input)) {
    println "'$input' is in the list."
} else {
    println "'$input' is not in the list."
}
