import java.io.*;
public class ReadFile {
    private static final String FILE_PATH = "SaveThings.txt";

    public static void ReadFromFile() {
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
}
