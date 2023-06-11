import java.io.*;
public class FileManager {

    public static void ReadFromFile(String FILE_PATH) {
        try {
            File file = new File(FILE_PATH);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            if (file.exists()) {
                while (true) {
                    String line = reader.readLine();
                    if (line != null) {
                        System.out.println(line);
                    }
                    else {
                        reader.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int RecoverFromFile(String FILE_PATH) {
        try {
            File file = new File(FILE_PATH);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            if (file.exists()) {
                String line = reader.readLine();
                if (line != null) {
                    int savedThing = Integer.parseInt(line);
                    return savedThing;
                }
                else {
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void SaveToFile(String FILE_PATH, int saveThing) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(Integer.toString(saveThing));
            writer.close();
            System.out.println("Salvo no arquivo: " + saveThing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
