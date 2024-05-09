class Language {
    private String name
    private String version
    
    // Constructor
    Language(String name, String version) {
        this.name = name
        this.version = version
    }

    // Public method to access the private name property
    public String getName() {
        // Assigned in "Language" constructor
        return name
    }

    // Public method to access the private version property
    public String getVersion() {
        // Assigned in "Language" constructor
        return version
    }

    // Private method that can only be called within this class
    private void displayMessage() {
        println "Welcome to $name version $version."
    }

    // Public method that internally calls a private method
    public void shareDetails() {
        displayMessage()
    }
}

// Creating an object of the Language class
Language language = new Language("Groovy", "4.0.18")

// Accessing public methods
println "Language get function call: ${language.getName()}, Version: ${language.getVersion()}"

// Accessing a private method through a public interface
language.shareDetails()
