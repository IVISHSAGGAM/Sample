import groovy.sql.Sql

def getDatabaseConnection(url, user, password, driver) {
    try {
        Sql sql = Sql.newInstance(url, user, password, driver)
        println 'Successfully connected to the database.'
        return sql
    } catch (Exception e) {
        e.printStackTrace()
        println 'Failed to connect to the database.'
        return null
    }
}

def searchEmployeeByName(Sql sql) {
    if (sql) {
        def name = System.console().readLine('Enter employee name to search for: ')
        String query = "SELECT id, name, position FROM employees WHERE name LIKE ?"
        
        // Initialize a flag to track if any rows are found
        boolean found = false
        
        sql.eachRow(query, ['%'+name+'%']) { row ->
            println "Found Employee - ID: ${row.id}, Name: ${row.name}, Position: ${row.position}"
            found = true // Set the flag to true if at least one row is found
        }
        
        // Check the flag and print a message if no rows were found
        if (!found) {
            println "No employees found matching the name: $name"
        }
    } else {
        println "Invalid SQL connection. Cannot search for employees."
    }
}

// Database connection parameters
def url = 'jdbc:mysql://localhost:3306/testdb' // Change 'testdb' to your actual database name
def user = 'root' // Change to your MySQL username
def password = 'password' // Change to your MySQL password
def driver = 'com.mysql.cj.jdbc.Driver'

def sql = getDatabaseConnection(url, user, password, driver)

// Execute the search
searchEmployeeByName(sql)

if (sql) {
    sql.close()
}