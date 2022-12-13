import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FileReader {

    public void getDataFromFile(Path path) throws IOException {
//      1. Read file:
//        String contentsString = Files.readString(path);
//        System.out.println("Read file: \n" + contentsString);

        String rawText = readFile(path);

//     2. Format string data from file into one string:
//        String formattedData = contentsString.
//                replaceAll("\\n", ",")
//                .replaceAll("\\s", "");
//        System.out.println("One string data: " + formattedData);

        String oneString = oneString(rawText);

//      3. Parse string for key-value pairs
//        Map<String, String> stringToMap = Arrays
//                .stream(formattedData.split(","))
//                .map(entry -> entry.split(":"))
//                .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
//        System.out.println("string to map: " + stringToMap);

        Map<String, String> stringToMap = stringToMap(oneString);

//      4. Create Profile
//        Profile profile = new Profile();
//
//        profile.setAge(Integer.parseInt(stringToMap.get("Age")));
//        profile.setName(stringToMap.get("Name"));
//        profile.setEmail(stringToMap.get("Email"));
//        profile.setPhone(Long.parseLong(stringToMap.get("Phone")));
//
//        System.out.println("Profile: " + profile);

        Profile profile = profile(stringToMap);
        System.out.println(profile);

    }

    private String readFile(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {

        }
        return null;
    }

    public String oneString(String string) {

        return string.replaceAll("\\n", ",")
                .replaceAll("\\s", "");
    }

    public Map<String, String> stringToMap(String string) {
        return Arrays
                .stream(string.split(","))
                .map(entry -> entry.split(":"))
                .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
    }

    public Profile profile (Map<String, String> stringToMap) {

        Profile profile = new Profile();

        profile.setAge(Integer.parseInt(stringToMap.get("Age")));
        profile.setName(stringToMap.get("Name"));
        profile.setEmail(stringToMap.get("Email"));
        profile.setPhone(Long.parseLong(stringToMap.get("Phone")));

        return profile;
    }
}
