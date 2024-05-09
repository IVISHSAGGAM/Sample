#!/usr/bin/env groovy
// User input handling in Groovy

println "This is ${this.getClass().getName()} script"

// Handling command-line arguments
if (args.length > 1) {
    println "User inputs ${args[0]}, ${args[1]}"
} else {
    println "Please provide at least two arguments."
}

// Reading user input for name
def console = System.console()
if (console) {
    def name = console.readLine("Please enter your name: ")
    def password = console.readPassword("Please enter your password: ")
    
    println "You have entered: $name"
    println "Your password is: ${new String(password)}" // Convert char[] to String for printing
} else {
    println "No console available. Please run this script from a command line."
}
