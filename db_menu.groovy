import groovy.sql.Sql
import groovy.json.JsonBuilder
import java.sql.SQLException


def getDatabaseConnection() {
    def url = 'jdbc:mysql://localhost:3306/testdb' // Change to your actual database
    def user = 'root' // Change to your MySQL username
    def password = 'password' // Change to your MySQL password
    def driver = 'com.mysql.cj.jdbc.Driver'
    Sql.newInstance(url, user, password, driver)
}

def readEmployees(Sql sql) {
    println "\nReading employee records..."
    sql.eachRow('SELECT id, name, position FROM employees') { row ->
        println "${row.id}, ${row.name}, ${row.position}"
    }
}

def searchEmployeeByName(Sql sql) {
    def name = System.console().readLine('Enter employee name to search for: ')
    def found = sql.firstRow("SELECT id, name, position FROM employees WHERE name LIKE ?", ['%'+name+'%'])
    if (found) {
        println "Found Employee - ID: ${found.id}, Name: ${found.name}, Position: ${found.position}"
    } else {
        println "No employee found with name: $name"
    }
}

def updateEmployeeRecord(Sql sql) {
    def choice = System.console().readLine('Update by (1) Name (2) ID: ')
    if (choice == '1') {
        def name = System.console().readLine('Enter employee name to update: ')
        def newPosition = System.console().readLine('Enter new position: ')
        int result = sql.executeUpdate("UPDATE employees SET position = ? WHERE name = ?", [newPosition, name])
        if (result > 0) println "Employee updated successfully."
        else println "No employee found with name: $name"
    } else if (choice == '2') {
        def id = System.console().readLine('Enter employee ID to update: ').toInteger()
        def newPosition = System.console().readLine('Enter new position: ')
        int result = sql.executeUpdate("UPDATE employees SET position = ? WHERE id = ?", [newPosition, id])
        if (result > 0) println "Employee updated successfully."
        else println "No employee found with ID: $id"
    } else {
        println "Invalid choice."
    }
}

def deleteEmployeeRecord(Sql sql) {
    def id = System.console().readLine('Enter employee ID to delete: ').toInteger()
    int result = sql.executeUpdate("DELETE FROM employees WHERE id = ?", [id])
    if (result > 0) println "Employee deleted successfully."
    else println "No employee found with ID: $id"
}

def insertNewRecord(Sql sql) {
    def name = System.console().readLine('Enter employee name: ')
    def position = System.console().readLine('Enter employee position: ')
    int result = sql.executeUpdate("INSERT INTO employees (name, position) VALUES (?, ?)", [name, position])
    if (result > 0) println "Employee inserted successfully."
}

def readAndExportRecords(Sql sql) {
    try {
        showTableNames(sql)
        def tableName = System.console().readLine('Enter tablename from above list: ').trim().toLowerCase().toLowerCase()
        if (!tableExists(sql, tableName)) {
            println "The table $tableName does not exist."
            return // Skip the rest of the function if the table does not exist
        }
        println "\nReading records from $tableName..."
        String query = "SELECT * FROM ${tableName}"
        List<Map> records = []
        sql.eachRow(query) { row ->
            Map<String, Object> record = [:]
            row.getMetaData().columnCount.times { colIdx ->
                record.put(row.getMetaData().getColumnName(colIdx + 1), row.getObject(colIdx + 1))
            }
            records << record
        }
        
        def format = System.console().readLine('Export as (1) JSON (2) CSV: ')
        def filename = System.console().readLine('Enter filename for export (without extension): ')
        switch (format) {
            case '1':
                exportToJson(records, "${filename}.json")
                break
            case '2':
                exportToCsv(records, "${filename}.csv")
                break
            default:
                println "Invalid format selected."
        }
    }
    catch (SQLException | MissingPropertyException e){
        println "Table '$tableName' does not exist or an error occurred: ${e.message}"
    }
}

def tableExists(Sql sql, String tableName) {
    def dbMeta = sql.connection.metaData
    def rs = dbMeta.getTables(null, null, tableName, null)
    boolean exists = rs.next()
    rs.close() // Always close ResultSet objects to free up resources
    return exists
}

def exportToJson(List<Map> records, String filename) {
    def json = new JsonBuilder(records).toPrettyString()
    new File(filename).text = json
    println "Data exported to ${filename}"
}

def exportToCsv(List<Map> records, String tableName) {
    if (records.isEmpty()) {
        println "No records to export."
        return
    }
    
    def filename = "${tableName}"
    File csvFile = new File(filename)
    
    csvFile.withWriter('UTF-8') { writer ->
        // Write header
        writer.writeLine(records[0].keySet().join(','))
        
        // Write data rows
        records.each { record ->
            writer.writeLine(record.values().collect { 
                it.toString().replaceAll("\"", "\"\"") // Escape double quotes
            }.join(','))
        }
    }
    
    println "Data exported to ${filename}"
}

def showTableNames(Sql sql) {
    println "\nList of tables in the database:"
    sql.eachRow('SHOW TABLES') { row ->
        println row[0] // Assuming the default column name for the result of SHOW TABLES is 'Tables_in_<dbname>'
    }
}

def showMenu() {
    println """
    1. Read Employees
    2. Search Employee by Name
    3. Update Employee Record
    4. Delete Employee Record
    5. Insert New Record
    6. Read and Export Record
    7. Exit
    Enter choice:
    """
}

def main() {
    def sql = getDatabaseConnection()
    while (true) {
        showMenu()
        def choice = System.console().readLine().toInteger()
        switch (choice) {
            case 1:
                readEmployees(sql)
                break
            case 2:
                searchEmployeeByName(sql)
                break
            case 3:
                updateEmployeeRecord(sql)
                readEmployees(sql)
                break
            case 4:
                deleteEmployeeRecord(sql)
                readEmployees(sql)
                break
            case 5:
                insertNewRecord(sql)
                readEmployees(sql)
                break
            case 6:
                readAndExportRecords(sql)
                break
            case 7:
                sql.close()
                return
            default:
                println "Invalid choice."
        }
    }
}

main()
