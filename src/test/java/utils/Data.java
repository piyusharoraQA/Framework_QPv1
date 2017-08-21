package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author piyusharora
 */
public class Data{

    static String user_dir = System.getProperty("user.dir");
    static String filename = "data.txt";
    static String filepath = user_dir + "\\src\\test\\resources\\Data\\" + filename;
    static String key_value = "";

    public static String data_reader(String cred) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line = "";
            while ((line = br.readLine()) != null) {
                if (cred.equalsIgnoreCase(line.split(": ")[0])) {
                    key_value = line;
                    break;
                }

            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry " + filename + " not found ... " + ex);
        } catch (IOException ex) {
            System.out.println("Sorry " + filename + " not found ... " + ex);

        }
        System.out.println("dataReader function : "+key_value.split(": ")[1]);
        return key_value.split(": ")[1];
    }

}
