import java.io.File 

//Read file using eachLine
class Example { 
   static void main(String[] args) { 
      new File("users.json").eachLine {  
         line -> println "line : $line"; 
      } 
   } 
}

//Reading the Contents of a File as an Entire String
class Example { 
   static void main(String[] args) { 
      File file = new File("users.json") 
      println file.text 
   } 
}

//write, read and check the size of the file
class Example { 
   static void main(String[] args) { 
      new File("sample.txt").withWriter('utf-8') { 
         writer -> writer.writeLine 'Hello World'    
      }
      File file = new File("sample.txt") 
      println file.text  
      // Size of file
      println "The file ${file.absolutePath} has ${file.length()} bytes"
   } 
}

//Check userinput is a file or directory
class Example { 
   static void main(String[] args) { 
      def console = System.console()
      def file_name = console.readLine("Enter the file name: ").trim()
      def file = new File(file_name) 
      if (file.isFile()) {
          println "The $file is a file"
      } else if (file.isDirectory()) {
          println "The $file is a directory"
      } else {
          println "The $file is not a file nor directory"
      }
   } 
}

//Create directory
class Example {
   static void main(String[] args) {
      def console = System.console()
      def d_name = console.readLine("Enter the directory name to create: ").trim()
      def dir_name = new File(d_name)
      if (dir_name.isFile()) {
        println "The $dir_name file is already exists"
        return
      }
      if (dir_name.isDirectory()){
        println "The $dir_name directory is already exists"
        return
      }
      dir_name.mkdir()
      println "The $dir_name is created."
   } 
}

//Delete directory
class Example {
   static void main(String[] args) {
      def console = System.console()
      def d_name = console.readLine("Enter the directory name to delete: ").trim()
      def dir_name = new File(d_name)
      if (dir_name.isFile()) {
        println "The $dir_name is a file."
      }
      else if (dir_name.isDirectory()){
        dir_name.delete()
        println "The $dir_name directory is deleted"
      }
      else {
        println "The $dir_name is not a file nor directory exist"
      } 
   } 
}

//Copy file
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

class Example {
    static void main(String[] args) {
        def console = System.console()
        if (console == null) {
            println "No console available. Please run this program in a console."
            return
        }

        def s_file = console.readLine("Enter the file name to copy: ").trim()
        def srcPath = Paths.get(s_file)

        def d_file = console.readLine("Enter the new file name for the copy: ").trim()
        def dstPath = Paths.get(d_file)

        // Check if srcPath exists and is not a directory
        if (!Files.exists(srcPath) || Files.isDirectory(srcPath)) {
            println "The source path must exist and should not be a directory."
            return
        }
        
        // Check if dstPath does not exist or is not a directory
        if (Files.exists(dstPath) && Files.isDirectory(dstPath)) {
            println "The destination path exists as a directory. Please specify a different destination."
            return
        }

        // Proceed with copying if all conditions are met
        Files.copy(srcPath, dstPath, StandardCopyOption.REPLACE_EXISTING)
        println "The file was copied successfully to $d_file."
    }
}

// list the directory contents
class Example {
    static void main(String[] args) {
        def console = System.console()
        if (console == null) {
            println "No console available."
            return
        }
        
        def d_name = console.readLine("Enter the directory name to list the contents: ").trim()
        def directory = new File(d_name)
        
        if (!directory.exists()) {
            println "The directory $d_name does not exist."
            return
        }

        if (!directory.isDirectory()) {
            println "The path $d_name is not a directory."
            return
        }

        println "Contents of $d_name:"
        directory.eachFile { file ->
            println file.absolutePath
        }
    }
}
