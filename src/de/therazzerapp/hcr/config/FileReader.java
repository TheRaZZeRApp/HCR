package de.therazzerapp.hcr.config;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class FileReader {
    public static ArrayList<String> getFileContent(File file){
        ArrayList<String> text = new ArrayList<>();
        BufferedReader br;
        InputStream is = null;
        InputStreamReader isr;
        try {
            is = new FileInputStream(file);
            isr = new InputStreamReader(is, Charset.forName("windows-1252"));
            br = new BufferedReader(isr);

            String line = br.readLine();
            while (line != null) {
                text.add(line);
                line = br.readLine();
            }
        } catch (IOException ioe) {
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
            }
        }
        return text;
    }
}
