package strings;

import java.io.File;

/**
 * Created by sarkarri on 1/23/17.
 */
public class Substrings {
    public static void main(String[] args) {
        File  indexMappingFile = new File("audits.json");
        String index = indexMappingFile.getName().substring(0, indexMappingFile.getName().toLowerCase().indexOf(".json"));
        System.out.println(index);
    }
}
