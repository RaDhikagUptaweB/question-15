//ques 18)Write a program to find file properties using stat() function.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FilePropertiesExample {
    public static void main(String[] args) {
        String filename = "path_to_your_file";
        try {
            Path filePath = Paths.get(filename);

  
            BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);

            // Print file properties
            System.out.println("File Properties:");
            System.out.println("File Size: " + fileAttributes.size() + " bytes");
            System.out.println("Creation Time: " + fileAttributes.creationTime());
            System.out.println("Last Accessed Time: " + fileAttributes.lastAccessTime());
            System.out.println("Last Modified Time: " + fileAttributes.lastModifiedTime());
            System.out.println("Is Directory: " + fileAttributes.isDirectory());
            System.out.println("Is Regular File: " + fileAttributes.isRegularFile());
            System.out.println("Is Symbolic Link: " + fileAttributes.isSymbolicLink());
            System.out.println("File Owner: " + Files.getOwner(filePath));
            System.out.println("File Permissions: " + Files.getPosixFilePermissions(filePath));

        } catch (IOException e) {
            System.out.println("Error: Unable to get file properties.");
            e.printStackTrace();
        }
    }
}