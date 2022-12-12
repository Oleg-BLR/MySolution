import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FileReader {

    public void getDataFromFile(Path path) throws IOException {
//      1. Read file:
        String contentsString = Files.readString(path);
        System.out.println("Read file: \n" + contentsString);

//     2. Format string data from file into one string:
        String formattedData = contentsString.
                replaceAll("\\n", ",")
                .replaceAll("\\s", "");
        System.out.println("One string data: " + formattedData);

//      3. Parse string for key-value pairs
        Map<String, String> stringToMap = Arrays
                .stream(formattedData.split(","))
                .map(entry -> entry.split(":"))
                .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
        System.out.println("string to map: " + stringToMap);

//      4. Create Profile
        Profile profile = new Profile();

        profile.setAge(Integer.parseInt(stringToMap.get("Age")));
        profile.setName(stringToMap.get("Name"));
        profile.setEmail(stringToMap.get("Email"));
        profile.setPhone(Long.parseLong(stringToMap.get("Phone")));

        System.out.println("Profile: " + profile);
    }
}
