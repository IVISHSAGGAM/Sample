#!/usr/bin/env groovy
// Example script demonstrating various if conditions in Groovy

// Simple if statement
def age = 18
if (age >= 18) {
    println "You are eligible to vote."
} else {
    println "You are not eligible to vote."
}

// Using Groovy truth with a list
def names = ['Python', 'Ruby', 'Groovy']
if (names) { // In Groovy, a non-empty list is true
    println "The list is not empty."
} else {
    println "The list is empty."
}

// Prompt the user for input
println "Enter values separated by commas (e.g., item1,item2,item3):"
def input = System.console().readLine().trim()

// Split the input into a list based on the comma delimiter
def list = input.split(",")

// Check if the list or any of its items are empty
if (list.any { it.trim().isEmpty() } || list.size() == 0) {
    println "The list is empty or contains empty values."
} else {
    println "The list contains values: ${list.join(', ')}"
}


// Using if-else-if ladder
def score = 75
if (score > 90) {
    println "Grade: A"
} else if (score > 80) {
    println "Grade: B"
} else if (score > 70) {
    println "Grade: C"
} else {
    println "Grade: D"
}

// Using if with a closure for lazy evaluation
def isWeekend = { day ->
    day in ['Saturday', 'Sunday']
}
def today = 'Saturday'
if (isWeekend(today)) {
    println "It's time to relax!"
} else {
    println "Maybe it's time to work."
}

// Using if with Groovy's Elvis operator
def username = null

def displayName = username ?: "Guest"
println "Welcome, $displayName"

// Using if to check map contents
def userRoles = ['admin': true, 'editor': false]
if (userRoles['admin']) {
    println "You have admin access."
} else {
    println "You are a regular user."
}
