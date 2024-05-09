class GroovyInfo {
    // Static property to hold the version of Groovy
    static String version = "4.0.18"

    // Static method to display information about Groovy
    static void displayLanguageInfo() {
        println "Groovy Language Version: $version"
    }
}

// Accessing the static property directly without creating an object
println "Current Groovy Version: ${GroovyInfo.version}"

// Calling the static method to display language information
GroovyInfo.displayLanguageInfo()
