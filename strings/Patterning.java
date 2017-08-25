package strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sarkarri on 8/8/17.
 */
public class Patterning {
    Pattern[] adminUriPatterns;

    public static void main(String[] args) {

        Patterning pt = new Patterning();
        String[] values = {"^\\/iamsvc/roles\\/*"};
        pt.setAdminUris(values);
        String uri = "/iamsvc/roles";
        pt.issMatch(uri);
    }

    boolean issMatch(String uri) {
        if (adminUriPatterns == null || adminUriPatterns.length == 0) {
            System.out.println("admin URI patterns are not defined.");
            return false;
        }

        // Check if the reuqest URI matches any of the auditable-URI-patterns
        //String uri = request.getRequestURI();
        Matcher m;
        System.out.println("adminUriPatterns[0] {} " + adminUriPatterns[0]);
        System.out.println("URI  {}" + uri);
        for (Pattern pattern : adminUriPatterns) {
            m = pattern.matcher(uri);
            if (m.matches()) {
                System.out.println("uri = '{}' matched admin URI pattern = '{}'" + uri + " " + pattern.toString());
                return true;
            }
        }
        System.out.println("uri = '{}' did not match any admin URI pattern {}" + uri + " " + Arrays.toString(adminUriPatterns));
        return false;
    }

    public void setAdminUris(String[] uris) {
        if (uris == null) {
            uris = new String[0];
        }

        adminUriPatterns = new Pattern[uris.length];
        for (int i = 0; i < uris.length; i++) {
            adminUriPatterns[i] = Pattern.compile(uris[i]);
        }

    }

}
