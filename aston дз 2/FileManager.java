import java.io.*;
import java.nio.file.*;

class FileOperationException extends Exception {
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class FileManager {
    
    public static void writeToFile(String filename, String data) throws FileOperationException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            writer.write(data);
            System.out.println("Данные успешно записаны в файл: " + filename);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл: " + filename, e);
        }
    }
    
    public static String readFromFile(String filename) throws FileOperationException {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            System.out.println("Данные успешно прочитаны из файла: " + filename);
            return content;
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения из файла: " + filename, e);
        }
    }
    
    public static void main(String[] args) {
        String filename = "example.txt";
        String data = "Привет! \n Это тестовый вывод.";
        
        try {
            writeToFile(filename, data);
            
            String content = readFromFile(filename);
            System.out.println("Содержимое файла: \n" + content);
            
        } catch (FileOperationException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}