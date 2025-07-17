import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileUtility{
    //write content to file (overwrite mode)
    public static void writeFile(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
        System.out.println("File writtten successfully.");

    }
    //Read content from file
    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));

    }

    //Appened content to file
    public static void appenedToFiles(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(fileName, true); //true = append mode
        writer.write(content);
        writer.close();
        System.out.println("Content appended successfully.");
    }
    //Modify specific line in file
    public static void modifyLines(String fileName, int lineNumber, String newLine) throws IOException {
        List<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));

        if (lineNumber <= 0 || lineNumber > lines.size()){
            System.out.println("Invalid line number.");
            return;
        }

        lines.set(lineNumber - 1, newLine);
        Files.write(Paths.get(fileName), lines);
        System.out.println("Line modified successfully.");
    }
    //Example usage
    public static void main(String[] args){
        String fileName = "example.txt";

        try {
            //write to file
            writeFile(fileName, "Line 1\nLine 2\nLine 3");

            //Read file
            System.out.println("\nFile Content:\n" + readFile(fileName));

            //Append to file
            appenedToFiles(fileName, "\nLine 4");

            //Modify line 2
            modifyLines(fileName, 2, "Updated Line 2");

            //Read again
            System.out.println("\nModified Content:\n" + readFile(fileName));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }        
}  
