package de.therazzerapp.hcr.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class FileFilter {
    public static FilenameFilter jsonFilenameFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".json");
        }
    };

    public static java.io.FileFilter buildSettingsDirFilter = new java.io.FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory()
                    && new File(pathname, "config.json").exists()
                    && new File(pathname, "vvis.json").exists()
                    && new File(pathname, "vrad.json").exists()
                    && new File(pathname, "vbsp.json").exists();
        }
    };

    public static  FilenameFilter vmfFilenameFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".vmf");
        }
    };
}
