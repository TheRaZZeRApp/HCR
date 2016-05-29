package de.therazzerapp.hcr;

import java.io.File;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class HCRUtils {
    public static boolean deleteDirectory(File dir) {

        if (dir.isDirectory()) {
            for (File d : dir.listFiles()){
                deleteDirectory(d);
            }
        }
        // The directory is now empty or this is a file so delete it
        return dir.delete();
    }
}
