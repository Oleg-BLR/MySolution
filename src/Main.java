import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("src/data/Profile.txt");

        FileReader fileReader = new FileReader();
        try {
            fileReader.getDataFromFile(path);
        } catch (IOException e) {

        }
    }
}
