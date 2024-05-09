// You can add try catch block, index and name search

def languages = []

def createList() {
    languages = ['python', 'groovy', 'ruby', 'html', 'go-lang']
    println "List created: $languages"
}

def updateList() {
    println "Current list: $languages"
    println "Enter index to update (0-based index):"
    def index = System.console().readLine() as Integer
    println "Enter new language name:"
    def language = System.console().readLine()
    languages[index] = language
    println "After update: $languages"
}

def deleteFromList() {
    println "Current list: $languages"
    println "Enter language name to delete:"
    def language = System.console().readLine()
    languages.remove(language)
    println "After delete: $languages"
}

def insertIntoList() {
    println "Current list: $languages"
    println "Enter index to insert at (0-based index):"
    def index = System.console().readLine() as Integer
    println "Enter language name to insert:"
    def language = System.console().readLine()
    languages.add(index, language)
    println "After insert: $languages"
}

def displayMenu() {
    println """
    1. Create list
    2. Update list
    3. Delete from list
    4. Insert into list
    5. Display list
    6. Exit
    Choose an option:
    """
}

def main() {
    while (true) {
        displayMenu()
        def choice = System.console().readLine() as Integer
        switch (choice) {
            case 1:
                createList()
                break
            case 2:
                updateList()
                break
            case 3:
                deleteFromList()
                break
            case 4:
                insertIntoList()
                break
            case 5:
                println "Current list: $languages"
                break
            case 6:
                println "Exiting..."
                return
            default:
                println "Invalid choice, please try again."
        }
    }
}

main()
