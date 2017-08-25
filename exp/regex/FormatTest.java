package exp.regex;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by sarkarri on 9/22/16.
 */
public class FormatTest {
    public static void main(String[] args) throws IOException {
        Pattern digitPattern = Pattern.compile("B-\\d{3} .*");
        boolean match = digitPattern.matcher("B-0a8 MyName").matches();
        //System.out.println("match "+match);

        Pattern wordP = Pattern.compile("^(?i)(ERROR|INFO|DEBUG|WARN)\\s.*$");
        System.out.println(wordP.matcher("error  [2017-01-30 14:14:19] [NA] [55116136e4b0a87f1b1f4569] " +
                "ERROR [2017-01-30 14:14:19] [NA] [55116136e4b0a87f1b1f4569]").matches());
    }

}
